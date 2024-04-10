package org.intellij.terraform

import com.intellij.openapi.application.readAction
import com.intellij.openapi.application.runWriteActionAndWait
import com.intellij.openapi.application.writeAction
import com.intellij.openapi.components.service
import com.intellij.openapi.progress.blockingContextToIndicator
import com.intellij.testFramework.common.timeoutRunBlocking
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.testFramework.fixtures.impl.CodeInsightTestFixtureImpl
import org.intellij.terraform.config.inspection.HCLBlockMissingPropertyInspection
import org.intellij.terraform.config.inspection.TFDuplicatedVariableInspection
import org.intellij.terraform.config.inspection.TFVARSIncorrectElementInspection
import org.intellij.terraform.config.model.TypeModelProvider
import org.intellij.terraform.config.model.local.LocalSchemaService

class TerraformModuleVariablesTest() : TerraformModuleVariablesTestBase("terraform/variables/tf-modules-subdirs") {

  fun testModuleVariableDeclarationRename() = timeoutRunBlocking {
    val file = myFixture.configureByFile("modules/fake_module/variables.tf")
    val varToRename = file.text.indexOf("fake_var_1")
    writeAction {
      myFixture.editor.caretModel.moveToOffset(varToRename + 1)
    }
    val findUsages = readAction {
      blockingContextToIndicator {
        val elementAtCaret = myFixture.elementAtCaret
        myFixture.findUsages(elementAtCaret)
      }
    }

    assertEquals(1, findUsages.size)
    writeAction { myFixture.renameElementAtCaret("new_fake_var_1") }
    myFixture.checkResult("main.tf", """
      module "main" {
        source = "./modules/fake_module"

        new_fake_var_1 = ""
        fake_var_2 = ""

        fake_var_4 = ""
      }
      
      module "this" {
        source    = "cloudposse/label/null"
        version   = "0.25.0"
        namespace = "em"
        stage     = "test-stage"
        name      = "test-name"
        delimiter = "-"
      }
      
    """.trimIndent(), true)
  }
}

class TerraformModuleVariablesUninitialisedTest() : TerraformModuleVariablesTestBase("terraform/variables/tf-modules-subdirs-uninitialised")

abstract class TerraformModuleVariablesTestBase(private val testDataRoot: String) : BasePlatformTestCase() {

  override fun getTestDataPath(): String? = TerraformTestUtils.getTestDataPath()

  override fun runInDispatchThread(): Boolean = false

  override fun setUp() {
    super.setUp()
    (myFixture as CodeInsightTestFixtureImpl).canChangeDocumentDuringHighlighting(true)
    TypeModelProvider.globalModel // ensure loaded, to avoid falling on the timeout
    myFixture.enableInspections(
      TFVARSIncorrectElementInspection::class.java,
      TFDuplicatedVariableInspection::class.java,
      HCLBlockMissingPropertyInspection::class.java,
    )
    runWriteActionAndWait {
      myFixture.copyDirectoryToProject(testDataRoot, ".")
    }
    timeoutRunBlocking {
      project.service<LocalSchemaService>().awaitModelsReady()
    }
  }

  fun testMissingVariables() {
    myFixture.testHighlighting("main.tf")
  }

  fun testMainVariables() {
    myFixture.testHighlighting("variables.tf")
  }

  fun testDuplicateInModule() {
    myFixture.testHighlighting("modules/fake_module/variables.tf")
  }

}