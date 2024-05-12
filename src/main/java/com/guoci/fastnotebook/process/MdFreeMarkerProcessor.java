package com.guoci.fastnotebook.process;

import com.intellij.ide.fileTemplates.impl.UrlUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * author: guoci
 * date:  2024/5/12
 */
public class MdFreeMarkerProcessor extends AbstractFreeMarkerDocumentProcessor {
    @Override
    protected Object getModel(SourceNoteData sourceNoteData) {
        Map model = new HashMap();
        model.put("topic", sourceNoteData.getTopic());
        model.put("noteDataList", sourceNoteData.getNoteDataList());
        return model;
    }

    @Override
    protected Template getTempate() throws IOException {
        String templateContent = UrlUtil.loadText(MdFreeMarkerProcessor.class.getResource("/template/freemarker/md.ftl"));

        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("MdTemplate", templateContent);

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        configuration.setTemplateLoader(stringTemplateLoader);
        return configuration.getTemplate("MdTemplate");
    }

    @Override
    protected Writer getWriter(SourceNoteData sourceNoteData) throws Exception {
        String fileName = sourceNoteData.getFileName();
        File file = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
        return writer;
    }
}
