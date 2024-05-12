package com.guoci.fastnotebook.window;

import com.google.protobuf.Message;
import com.guoci.fastnotebook.domain.DataCenter;
import com.guoci.fastnotebook.process.DefaultSourceNoteData;
import com.guoci.fastnotebook.process.DocumentProcessor;
import com.guoci.fastnotebook.process.MdFreeMarkerProcessor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class NoteBookListWindow {
    private JTextField noteTitleField;
    private JTable noteDataListTable;
    private JButton btnGenerate;
    private JButton btnClearList;
    private JButton btnClose;
    private JPanel noteWindowPanel;

    private void init() {
        noteDataListTable.setModel(DataCenter.NOTE_TABLE_MODEL);
        noteDataListTable.setEnabled(true);
    }
    public NoteBookListWindow(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        init();

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noteTitle = noteTitleField.getText();
                String fileName = noteTitle + ".md";
                if (noteTitle == null || "".equals(noteTitle)) {
                    MessageDialogBuilder.yesNo("result","note title can not be empty");
                    return;
                }

                VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                if (virtualFile != null) {
                    String path = virtualFile.getPath();
                    String fileFullPath = path + File.separator + fileName;
                    DefaultSourceNoteData defaultSourceNoteData = new DefaultSourceNoteData(fileFullPath, noteTitle, DataCenter.NOTE_DATA_LIST);
                    DocumentProcessor processor = new MdFreeMarkerProcessor();
                    try {
                        processor.process(defaultSourceNoteData);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        btnClearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide();
            }
        });
    }

    public JPanel getNoteWindowPanel() {
        return noteWindowPanel;
    }
}
