package com.guoci.fastnotebook.domain;

import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class DataCenter {
    public static String NOTE_TITLE;
    public static String NOTE_CONTENT;
    /** the current select content */
    public static String CURRENT_SELECT_TEXT;
    public static String CURRENT_SELECT_FILE_NAME;
    public static List<NoteData> NOTE_DATA_LIST = new LinkedList<>();
    public static boolean addNoteData(NoteData noteData) {
        return NOTE_DATA_LIST.add(noteData);
    }
    public static String[] NOTE_TABLE_COLUMNS_HEADER = {"title","remark","fileName","segement"};
    public static DefaultTableModel NOTE_TABLE_MODEL = new DefaultTableModel(null, NOTE_TABLE_COLUMNS_HEADER);
    public static void addRowToModel(String[] row) {
        NOTE_TABLE_MODEL.addRow(row);
    }

    public static void reset() {
        NOTE_DATA_LIST.clear();
        NOTE_TABLE_MODEL.setDataVector(null, NOTE_TABLE_COLUMNS_HEADER);
    }
}
