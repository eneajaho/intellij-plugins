package com.jetbrains.plugins.meteor;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootEvent;
import com.intellij.openapi.roots.ModuleRootListener;
import com.jetbrains.plugins.meteor.ide.action.MeteorLibraryUpdater;
import org.jetbrains.annotations.NotNull;

final class MeteorRootListener implements ModuleRootListener {
  @Override
  public void rootsChanged(@NotNull ModuleRootEvent event) {
    Object source = event.getSource();
    if (source instanceof Project project) {
      if (!project.isDisposed() && !project.isDefault() /* not really sure if it's the root of the problem */) {
        MeteorLibraryUpdater.Companion.getInstance(project).scheduleProjectUpdate();
      }
    }
  }
}
