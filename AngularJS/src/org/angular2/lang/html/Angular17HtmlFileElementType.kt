// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.angular2.lang.html

import com.intellij.psi.impl.source.html.HtmlFileImpl
import com.intellij.psi.stubs.PsiFileStub
import com.intellij.psi.tree.IStubFileElementType

class Angular17HtmlFileElementType private constructor()
  : IStubFileElementType<PsiFileStub<HtmlFileImpl>>("html.angular17", Angular17HtmlLanguage.INSTANCE) {
  override fun getStubVersion(): Int {
    return Angular2HtmlFileElementType.angular2HtmlStubVersion
  }

  companion object {
    @JvmField
    val INSTANCE: IStubFileElementType<PsiFileStub<HtmlFileImpl>> = Angular17HtmlFileElementType()
  }
}