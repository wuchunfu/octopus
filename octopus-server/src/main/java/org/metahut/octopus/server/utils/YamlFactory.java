/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.metahut.octopus.server.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySources;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class YamlFactory {

    private YamlFactory() {

    }

    public static Properties loadYamlToProperties(String application) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(application));
        return yaml.getObject();
    }

    public static <T> T parseObject(String prefix, String application, T instance) {
        Bindable<?> target = Bindable.ofInstance(instance);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertySourcesPlaceholderConfigurer configurer = generateSinglePlaceholderConfigurer(beanFactory, application);
        PropertySources propertySources = configurer.getAppliedPropertySources();
        BindResult result = new Binder(ConfigurationPropertySources.from(propertySources)).bind(prefix, target);
        return (T) result.get();
    }

    private static PropertySourcesPlaceholderConfigurer generateSinglePlaceholderConfigurer(DefaultListableBeanFactory beanFactory, String application) {
        Properties properties = loadYamlToProperties(application);
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(properties);
        configurer.postProcessBeanFactory(beanFactory);
        return configurer;
    }

}
