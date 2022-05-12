package org.metahut.octopus.server.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfiguration {

    private final MessageSource messageSource;

    public ValidatorConfiguration(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource);
        // 设置使用 HibernateValidator 校验器
        //factoryBean.setProviderClass(HibernateValidator.class);
        //Properties properties = new Properties();
        // 设置 快速异常返回
        //properties.setProperty("hibernate.validator.fail_fast", "true");
        //factoryBean.setValidationProperties(properties);
        // 加载配置
        //factoryBean.afterPropertiesSet();
        return factoryBean;
    }

}
