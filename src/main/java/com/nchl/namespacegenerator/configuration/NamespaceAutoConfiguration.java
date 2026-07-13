package com.nchl.namespacegenerator.configuration;

import com.nchl.namespacegenerator.domain.Namespace;
import com.nchl.namespacegenerator.generator.NamespaceGenerator;
import com.nchl.namespacegenerator.key.NamespaceBuilder;
import com.nchl.namespacegenerator.key.NamespaceValidator;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(NamespaceProperties.class)
public class NamespaceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Namespace namespace(NamespaceProperties properties){
        return new Namespace(
                properties.environment(),
                properties.application()
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceValidator namespaceValidator(){
        return new NamespaceValidator();
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceBuilder namespaceBuilder(Namespace namespace, NamespaceValidator namespaceValidator){
        return new NamespaceBuilder(namespace, namespaceValidator);

    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceGenerator namespaceGenerator(NamespaceBuilder namespaceBuilder){
        return new NamespaceGenerator(namespaceBuilder);
    }
}
