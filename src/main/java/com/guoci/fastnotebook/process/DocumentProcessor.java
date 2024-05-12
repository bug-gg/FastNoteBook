package com.guoci.fastnotebook.process;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * author: guoci
 * date:  2024/5/12
 */
public interface DocumentProcessor {
    void process(SourceNoteData sourceNoteData) throws Exception;

}
