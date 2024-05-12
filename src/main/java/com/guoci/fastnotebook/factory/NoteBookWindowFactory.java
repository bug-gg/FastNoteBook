package com.guoci.fastnotebook.factory;

import com.guoci.fastnotebook.window.NoteBookListWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class NoteBookWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        NoteBookListWindow noteBookListWindow = new NoteBookListWindow(project, toolWindow);
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(noteBookListWindow.getNoteWindowPanel(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
