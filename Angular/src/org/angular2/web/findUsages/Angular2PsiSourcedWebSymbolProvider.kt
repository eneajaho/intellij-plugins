package org.angular2.web.findUsages

import com.intellij.lang.javascript.psi.ecma6.TypeScriptClass
import com.intellij.lang.javascript.psi.ecma6.TypeScriptField
import com.intellij.psi.PsiElement
import com.intellij.psi.util.contextOfType
import com.intellij.webSymbols.PsiSourcedWebSymbol
import com.intellij.webSymbols.PsiSourcedWebSymbolProvider
import org.angular2.entities.Angular2EntitiesProvider

class Angular2PsiSourcedWebSymbolProvider : PsiSourcedWebSymbolProvider {

  override fun getWebSymbols(element: PsiElement): List<PsiSourcedWebSymbol> {
    if (element is TypeScriptField) {
      Angular2EntitiesProvider.getDirective(element.contextOfType<TypeScriptClass>())
        ?.inOuts
        ?.find { (it as? PsiSourcedWebSymbol)?.source == element }
        ?.let {
          return listOf(it as PsiSourcedWebSymbol)
        }
    }
    return emptyList()
  }

}