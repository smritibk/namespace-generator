package com.nchl.namespacegenerator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "namespace")
public record NamespaceProperties(
         String environment,
         String application
) {}
