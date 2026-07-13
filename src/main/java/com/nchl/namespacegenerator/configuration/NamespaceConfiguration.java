package com.nchl.namespacegenerator.configuration;

import com.nchl.namespacegenerator.domain.Namespace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NamespaceConfiguration {

    @Bean
    public Namespace namespaceKeyModel(NamespaceProperties properties){
        return new Namespace(
                properties.getEnvironment(),
                properties.getApplication()
        );
    }
}
