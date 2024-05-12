package com.guoci.fastnotebook.domain;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class DataConvert {

    public static String[] convert(NoteData noteData) {
        String[] row = new String[4];
        row[0] = noteData.getTitle();
        row[1] = noteData.getMark();
        row[2] = noteData.getFileName();
        row[3] = noteData.getContent();
        return row;
    }
}
