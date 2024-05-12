package com.guoci.fastnotebook.process;

import freemarker.template.Template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * author: guoci
 * date:  2024/5/12
 */
public abstract class AbstractFreeMarkerDocumentProcessor implements DocumentProcessor {

    protected abstract Object getModel(SourceNoteData sourceNoteData);

    protected abstract Template getTempate() throws IOException;

    protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws Exception;

    @Override
    public final void process(SourceNoteData sourceNoteData) throws Exception {

        Template tempate = getTempate();
        Writer writer = getWriter(sourceNoteData);
        tempate.process(sourceNoteData,writer);
    }
}
