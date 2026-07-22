package com.nchl.namespacegenerator.configuration;

import com.nchl.namespacegenerator.aspect.NamespaceContextAspect;
import com.nchl.namespacegenerator.builder.NamespaceBuilder;
import com.nchl.namespacegenerator.builder.NamespaceValidator;
import com.nchl.namespacegenerator.context.ContextAppender;
import com.nchl.namespacegenerator.context.ContextResolver;
import com.nchl.namespacegenerator.context.DefaultContextAppender;
import com.nchl.namespacegenerator.context.DefaultContextResolver;
import com.nchl.namespacegenerator.generator.NamespaceGenerator;
import com.nchl.namespacegenerator.prefix.DefaultPrefixResolver;
import com.nchl.namespacegenerator.prefix.PrefixResolver;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@AutoConfiguration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(NamespaceProperties.class)
public class NamespaceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public NamespaceValidator namespaceValidator() {
        return new NamespaceValidator();
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceBuilder namespaceBuilder(NamespaceValidator namespaceValidator) {
        return new NamespaceBuilder(namespaceValidator);

    }

    @Bean
    @ConditionalOnMissingBean
    public ContextResolver contextResolver() {
        return new DefaultContextResolver();
    }

    @Bean
    @ConditionalOnMissingBean
    public ContextAppender contextAppender(){
        return new DefaultContextAppender();
    }

    @Bean
    @ConditionalOnMissingBean
    public PrefixResolver prefixResolver(NamespaceProperties properties) {
        return new DefaultPrefixResolver(properties);
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceGenerator namespaceGenerator(
            PrefixResolver prefixResolver,
            ContextResolver contextResolver,
            NamespaceBuilder namespaceBuilder) {

        return new NamespaceGenerator(
                prefixResolver,
                contextResolver,
                namespaceBuilder
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceContextAspect namespaceContextAspect(){
        return new NamespaceContextAspect();
    }
}
