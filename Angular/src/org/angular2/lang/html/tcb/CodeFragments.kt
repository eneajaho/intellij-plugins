package org.angular2.lang.html.tcb

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.util.containers.MultiMap
import org.angular2.lang.html.Angular2HtmlFile

internal class Expression(builder: ExpressionBuilder.() -> Unit) {

  constructor(code: String)
    : this({ append(code) })

  constructor(
    code: String,
    originalRange: TextRange?,
    types: Boolean,
    diagnosticsRange: TextRange? = originalRange,
  )
    : this({ append(code, originalRange, types, diagnosticsRange) })

  constructor(id: Identifier)
    : this({ append(id) })

  private val code: StringBuilder

  private val sourceMappings: Set<SourceMappingData>

  init {
    val expression = ExpressionBuilderImpl().apply(builder)
    code = expression.code
    sourceMappings = expression.sourceMappings
  }

  override fun toString(): String =
    code.toString()

  fun asTranspiledTemplate(
    templateFile: Angular2HtmlFile,
  ): Angular2TemplateTranspiler.TranspiledTemplate =
    object : Angular2TemplateTranspiler.TranspiledTemplate {
      override val templateFile: Angular2HtmlFile = templateFile
      override val generatedCode: String = code.toString()
      override val sourceMappings: List<Angular2TemplateTranspiler.SourceMapping> = this@Expression.sourceMappings.toList()
    }

  interface ExpressionBuilder {
    fun append(code: String): ExpressionBuilder

    fun append(id: Identifier): ExpressionBuilder

    fun append(
      code: String,
      originalRange: TextRange?,
      types: Boolean,
      diagnosticsRange: TextRange? = originalRange,
    ): ExpressionBuilder

    fun append(
      id: Identifier,
      originalRange: TextRange?,
      types: Boolean,
      diagnosticsRange: TextRange? = originalRange,
    ): ExpressionBuilder

    fun append(expression: Expression): ExpressionBuilder

    fun append(expression: ExpressionBuilder.() -> Unit): ExpressionBuilder

    fun withSourceSpan(
      originalRange: TextRange?,
      types: Boolean,
      diagnosticsRange: TextRange? = originalRange,
      builder: ExpressionBuilder.() -> Unit,
    )

    fun withIgnoreDiagnostics(builder: ExpressionBuilder.() -> Unit)

    fun codeBlock(builder: BlockBuilder.() -> Unit)

    fun statements(builder: BlockBuilder.() -> Unit)

    fun newLine()

    fun removeMappings(range: TextRange)
  }

  interface BlockBuilder : ExpressionBuilder {

    fun appendStatement(statement: Statement): BlockBuilder

    fun appendStatement(expression: ExpressionBuilder.() -> Unit): BlockBuilder

  }

  private class ExpressionBuilderImpl : ExpressionBuilder, BlockBuilder {
    val code = StringBuilder()

    val sourceMappings = mutableSetOf<SourceMappingData>()

    private var ignoreDiagnostics = false

    override fun removeMappings(range: TextRange) {
      sourceMappings.removeIf {
        it.sourceOffset == range.startOffset
        && it.sourceOffset + it.sourceLength == range.endOffset
      }
    }

    override fun append(code: String): ExpressionBuilder {
      this.code.append(code)
      return this
    }

    override fun append(id: Identifier): ExpressionBuilder {
      this.code.append(id.toString())
      return this
    }

    override fun append(code: String, originalRange: TextRange?, types: Boolean, diagnosticsRange: TextRange?): ExpressionBuilder {
      if (originalRange != null) {
        sourceMappings.add(SourceMappingData(
          sourceOffset = originalRange.startOffset,
          sourceLength = originalRange.length,
          generatedOffset = this.code.length,
          generatedLength = code.length,
          diagnosticsOffset = diagnosticsRange?.startOffset?.takeIf { !ignoreDiagnostics },
          diagnosticsLength = diagnosticsRange?.length?.takeIf { !ignoreDiagnostics },
          types = types,
        ))
      }
      this.code.append(code)
      return this
    }

    override fun append(id: Identifier, originalRange: TextRange?, types: Boolean, diagnosticsRange: TextRange?): ExpressionBuilder =
      append(id.toString(), originalRange, types, diagnosticsRange)

    override fun append(expression: Expression): ExpressionBuilder {
      val offset = this.code.length
      expression.sourceMappings.mapTo(this.sourceMappings) { sourceMapping ->
        sourceMapping.copy(
          generatedOffset = sourceMapping.generatedOffset + offset,
          diagnosticsOffset = sourceMapping.diagnosticsOffset?.takeIf { !ignoreDiagnostics },
          diagnosticsLength = sourceMapping.diagnosticsLength?.takeIf { !ignoreDiagnostics },
        )
      }
      this.code.append(expression.code)
      return this
    }

    override fun append(expression: ExpressionBuilder.() -> Unit): ExpressionBuilder {
      append(Expression(expression))
      return this
    }

    override fun withSourceSpan(
      originalRange: TextRange?, types: Boolean,
      diagnosticsRange: TextRange?, builder: ExpressionBuilder.() -> Unit,
    ) {
      if (originalRange != null) {
        val offset = this.code.length
        this.builder()
        sourceMappings.add(SourceMappingData(
          sourceOffset = originalRange.startOffset,
          sourceLength = originalRange.length,
          generatedOffset = offset,
          generatedLength = this.code.length - offset,
          diagnosticsOffset = diagnosticsRange?.startOffset?.takeIf { !ignoreDiagnostics },
          diagnosticsLength = diagnosticsRange?.length?.takeIf { !ignoreDiagnostics },
          types = types
        ))
      }
      else {
        this.builder()
      }
    }

    override fun withIgnoreDiagnostics(builder: ExpressionBuilder.() -> Unit) {
      ignoreDiagnostics = true
      this.builder()
      ignoreDiagnostics = false
    }

    override fun codeBlock(builder: BlockBuilder.() -> Unit) {
      append("{\n")
      this.builder()
      append("}")
    }

    override fun statements(builder: BlockBuilder.() -> Unit) {
      this.builder()
    }

    override fun newLine() {
      append("\n")
    }

    override fun appendStatement(statement: Statement): BlockBuilder {
      append(statement.expression).newLine()
      return this
    }

    override fun appendStatement(expression: ExpressionBuilder.() -> Unit): BlockBuilder {
      appendStatement(Statement(expression))
      return this
    }

    override fun toString(): String =
      code.toString()

  }
}

internal class Identifier(val name: String, val sourceSpan: TextRange? = null, val kind: ExpressionIdentifier? = null) {
  override fun toString(): String = name
}

internal class Statement private constructor(val expression: Expression) {
  constructor(builder: Expression.ExpressionBuilder.() -> Unit) : this(Expression(builder))
}

internal data class SourceMappingData(
  override val sourceOffset: Int,
  override val sourceLength: Int,
  override val generatedOffset: Int,
  override val generatedLength: Int,
  override val diagnosticsOffset: Int?,
  override val diagnosticsLength: Int?,
  override val types: Boolean,
) : Angular2TemplateTranspiler.SourceMapping {
  override fun offsetBy(generatedOffset: Int, sourceOffset: Int): Angular2TemplateTranspiler.SourceMapping =
    copy(sourceOffset = this.sourceOffset + sourceOffset,
         generatedOffset = this.generatedOffset + generatedOffset,
         diagnosticsOffset = this.diagnosticsOffset?.let { it + sourceOffset })
}
