package com.nchl.namespacegenerator.configuration;

import com.nchl.namespacegenerator.aspect.NamespaceContextAspect;
import com.nchl.namespacegenerator.context.ContextResolver;
import com.nchl.namespacegenerator.context.DefaultContextResolver;
import com.nchl.namespacegenerator.domain.Namespace;
import com.nchl.namespacegenerator.generator.NamespaceGenerator;
import com.nchl.namespacegenerator.builder.NamespaceBuilder;
import com.nchl.namespacegenerator.builder.NamespaceValidator;
import com.nchl.namespacegenerator.identity.DefaultIdentityNamingStrategy;
import com.nchl.namespacegenerator.identity.IdentityNamingStrategy;
import com.nchl.namespacegenerator.identity.IdentityResolver;
import com.nchl.namespacegenerator.identity.ReflectionIdentityResolver;
import com.nchl.namespacegenerator.metadata.DefaultMetadataNamingStrategy;
import com.nchl.namespacegenerator.metadata.MetadataNamingStrategy;
import com.nchl.namespacegenerator.metadata.MetadataResolver;
import com.nchl.namespacegenerator.metadata.ReflectionMetadataResolver;
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
    public Namespace namespace(NamespaceProperties properties) {
        return new Namespace(
                properties.environment(),
                properties.application()
        );
    }

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
    public MetadataNamingStrategy metadataNamingStrategy() {
        return new DefaultMetadataNamingStrategy();
    }

    @Bean
    @ConditionalOnMissingBean
    public MetadataResolver metadataResolver(
            MetadataNamingStrategy strategy
    ) {
        return new ReflectionMetadataResolver(strategy);
    }

    @Bean
    @ConditionalOnMissingBean
    public IdentityNamingStrategy identityNamingStrategy() {
        return new DefaultIdentityNamingStrategy();
    }

    @Bean
    @ConditionalOnMissingBean
    public IdentityResolver identityResolver(
            IdentityNamingStrategy strategy
    ) {
        return new ReflectionIdentityResolver(strategy);
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceGenerator namespaceGenerator(
            Namespace namespace,
            ContextResolver contextResolver,
            MetadataResolver metadataResolver,
            IdentityResolver identityResolver,
            NamespaceBuilder namespaceBuilder) {

        return new NamespaceGenerator(
                namespace,
                contextResolver,
                metadataResolver,
                identityResolver,
                namespaceBuilder
        );
    }

    @Bean
    @ConditionalOnMissingBean
    public NamespaceContextAspect namespaceContextAspect(){
        return new NamespaceContextAspect();
    }
}
