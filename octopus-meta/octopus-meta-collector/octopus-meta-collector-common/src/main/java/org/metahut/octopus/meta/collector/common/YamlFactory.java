package org.metahut.octopus.meta.collector.common;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class YamlFactory {

    private YamlFactory() {
    }

    public static Properties getInstance() {
        return YamlFactory.Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private Properties singleton;

        private Singleton() {
            singleton = loadYamlToProperties("");
        }

        public Properties getInstance() {
            return singleton;
        }
    }

    public static String get(String key) {
        return getInstance().getProperty(key);
    }

    private static Properties loadYamlToProperties(String application) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(application));
        return yaml.getObject();
    }

}
