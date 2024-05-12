package com.guoci.fastnotebook.process;

import com.guoci.fastnotebook.domain.NoteData;

import java.util.List;

/**
 * author: guoci
 * date:  2024/5/12
 */
public interface SourceNoteData {
    String getFileName();
    String getTopic();
    List<NoteData> getNoteDataList();

}
