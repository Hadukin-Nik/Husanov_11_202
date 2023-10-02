package com.example._20230923;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

public class TemplatesLoader {
    private static Configuration configuration;
    static {
        configuration = new Configuration(Configuration.VERSION_2_3_27);
        ClassTemplateLoader loader = new ClassTemplateLoader(TemplatesLoader.class, "/templates");
        configuration.setTemplateLoader(loader);
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}
