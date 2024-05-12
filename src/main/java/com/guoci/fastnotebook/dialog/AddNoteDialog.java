package com.guoci.fastnotebook.dialog;

import com.guoci.fastnotebook.domain.DataCenter;
import com.guoci.fastnotebook.domain.DataConvert;
import com.guoci.fastnotebook.domain.NoteData;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class AddNoteDialog extends DialogWrapper {

    private EditorTextField noteTitle;
    private EditorTextField noteMark;

    public AddNoteDialog() {
        super(true);
        setTitle("add note");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
         noteTitle = new EditorTextField("note title");
         noteMark = new EditorTextField("note mark");
         noteMark.setPreferredSize(new Dimension(200,100));
        jPanel.add(noteTitle,BorderLayout.NORTH);
        jPanel.add(noteMark,BorderLayout.CENTER);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton button = new JButton("add note to list");
        button.addActionListener(e->{
            String title = noteTitle.getText();
            String mark = noteMark.getText();
            String fileName = DataCenter.CURRENT_SELECT_FILE_NAME;
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            NoteData noteData = new NoteData(title, mark, DataCenter.CURRENT_SELECT_TEXT, fileName, fileType);
            DataCenter.addNoteData(noteData);
            DataCenter.addRowToModel(DataConvert.convert(noteData));

        });
        jPanel.add(button);
        return jPanel;
    }
}
