package com.guoci.fastnotebook.process;

import com.guoci.fastnotebook.domain.NoteData;

import java.util.List;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class DefaultSourceNoteData implements SourceNoteData {

    private String fileName;
    private String topic;
    private List<NoteData> noteDataList;

    public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteDataList) {
        this.fileName = fileName;
        this.topic = topic;
        this.noteDataList = noteDataList;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteDataList() {
        return noteDataList;
    }
}
