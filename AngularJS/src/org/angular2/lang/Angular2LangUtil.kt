// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.angular2.lang

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.webSymbols.context.WebSymbolsContext
import org.angular2.Angular2Framework.Companion.instance
import org.angular2.lang.html.Angular2HtmlLanguage
import org.angular2.lang.html.Angular2TemplateSyntax
import org.angular2.lang.svg.Angular2SvgLanguage

object Angular2LangUtil {
  const val ANGULAR_CORE_PACKAGE: String = "@angular/core"
  const val ANGULAR_COMMON_PACKAGE: String = "@angular/common"
  const val ANGULAR_FORMS_PACKAGE: String = "@angular/forms"
  const val ANGULAR_ROUTER_PACKAGE: String = "@angular/router"
  const val ANGULAR_CLI_PACKAGE: String = "@angular/cli"
  const val `$IMPLICIT`: String = "\$implicit"
  const val EVENT_EMITTER: String = "EventEmitter"
  const val OUTPUT_CHANGE_SUFFIX: String = "Change"

  @JvmStatic
  fun isAngular2Context(context: PsiElement): Boolean {
    return instance.isInContext(context)
  }

  @JvmStatic
  fun getTemplateSyntax(context: PsiElement?): Angular2TemplateSyntax =
    getTemplateSyntax { context?.let { WebSymbolsContext.get("angular-template-syntax", it) } }

  @JvmStatic
  fun getTemplateSyntax(project: Project?, context: VirtualFile?): Angular2TemplateSyntax =
    getTemplateSyntax {
      if (project != null && context != null)
        WebSymbolsContext.get("angular-template-syntax", context, project)
      else
        null
    }

  @JvmStatic
  fun isAngular2Context(project: Project, context: VirtualFile): Boolean {
    return instance.isInContext(context, project)
  }

  fun isAngular2HtmlFileType(fileType: FileType?) =
    fileType is LanguageFileType && fileType.language.isKindOf(Angular2HtmlLanguage.INSTANCE)

  fun isAngular2SvgFileType(fileType: FileType?) =
    fileType is LanguageFileType && fileType.language.isKindOf(Angular2SvgLanguage.INSTANCE)

  private fun getTemplateSyntax(contextProvider: () -> String?): Angular2TemplateSyntax =
    contextProvider()
      ?.let { syntax -> Angular2TemplateSyntax.entries.find { it.name.equals(syntax, true) } }
    ?: Angular2TemplateSyntax.V_2

}