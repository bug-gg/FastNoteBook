package com.guoci.fastnotebook.domain;

import lombok.Data;

/**
 * author: guoci
 * date:  2024/5/12
 */
@Data
public class NoteData {
    private String title;
    private String mark;
    private String content;
    private String fileName;
    private String fileType;

    public NoteData(String title, String mark, String content, String fileName, String fileType) {
        this.title = title;
        this.mark = mark;
        this.content = content;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "NoteData{" +
                "title='" + title + '\'' +
                ", mark='" + mark + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
