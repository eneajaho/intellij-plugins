package com.intellij.flex.uiDesigner.actions;

import com.intellij.flex.uiDesigner.DesignerApplicationManager;
import com.intellij.javascript.flex.mxml.FlexCommonTypeNames;
import com.intellij.lang.javascript.JavaScriptSupportLoader;
import com.intellij.lang.javascript.flex.XmlBackedJSClassImpl;
import com.intellij.lang.javascript.psi.ecmal4.JSClass;
import com.intellij.lang.javascript.psi.resolve.JSInheritanceUtil;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;

public class RunDesignViewAction extends DumbAwareAction {
  @Override
  public void actionPerformed(final AnActionEvent event) {
    final DataContext dataContext = event.getDataContext();
    final Project project = PlatformDataKeys.PROJECT.getData(dataContext);
    assert project != null;

    final XmlFile psiFile = (XmlFile)PsiDocumentManager.getInstance(project)
      .getPsiFile(getDocument(project, dataContext, ActionPlaces.isPopupPlace(event.getPlace())));
    assert psiFile != null;
    final VirtualFile file = psiFile.getVirtualFile();
    assert file != null;
    final Module module = ModuleUtil.findModuleForFile(file, project);
    assert module != null;

    FileDocumentManager.getInstance().saveAllDocuments();
    // saveAllDocuments may cause open this document
    if (!DesignerApplicationManager.getInstance().isDocumentOpening()) {
      DesignerApplicationManager.getInstance().openDocument(module, psiFile, isDebug());
    }
  }

  protected boolean isDebug() {
    return false;
  }

  public void update(final AnActionEvent event) {
    final boolean popupPlace = ActionPlaces.isPopupPlace(event.getPlace());
    final boolean enabled = isEnabled(event.getDataContext(), popupPlace) && !DesignerApplicationManager.getInstance().isDocumentOpening();
    if (popupPlace) {
      event.getPresentation().setVisible(enabled);
    }
    else {
      event.getPresentation().setEnabled(enabled);
    }
  }

  private static Document getDocument(Project project, DataContext dataContext, boolean popupPlace) {
    if (popupPlace) {
      final VirtualFile virtualFile = PlatformDataKeys.VIRTUAL_FILE.getData(dataContext);
      if (virtualFile != null) {
        return FileDocumentManager.getInstance().getDocument(virtualFile);
      }
    }
    else {
      Editor editor = PlatformDataKeys.EDITOR.getData(dataContext);
      if (editor == null) {
        editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
      }

      return editor == null ? null : editor.getDocument();
    }

    return null;
  }

  private static boolean isEnabled(final DataContext dataContext, boolean popupPlace) {
    final Project project = PlatformDataKeys.PROJECT.getData(dataContext);
    if (project == null || DumbService.isDumb(project)) {
      return false;
    }

    final Document document = getDocument(project, dataContext, popupPlace);
    if (document == null) {
      return false;
    }

    final PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
    if (psiFile == null || !JavaScriptSupportLoader.isFlexMxmFile(psiFile)) {
      return false;
    }
    final VirtualFile file = psiFile.getVirtualFile();
    if (file == null || !ProjectRootManager.getInstance(project).getFileIndex().isInSourceContent(file)) {
      return false;
    }
    final XmlTag rootTag = ((XmlFile)psiFile).getRootTag();
    if (rootTag == null || rootTag.getPrefixByNamespace(JavaScriptSupportLoader.MXML_URI3) == null) {
      return false;
    }

    final JSClass jsClass = XmlBackedJSClassImpl.getXmlBackedClass(rootTag);
    return jsClass != null && (JSInheritanceUtil.isParentClass(jsClass, FlexCommonTypeNames.FLASH_DISPLAY_OBJECT_CONTAINER) || JSInheritanceUtil.isParentClass(jsClass, FlexCommonTypeNames.IUI_COMPONENT));
  }
}
