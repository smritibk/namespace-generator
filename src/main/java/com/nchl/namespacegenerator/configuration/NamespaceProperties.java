package com.nchl.namespacegenerator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties used to define the namespace prefix.
 *
 * <p>Properties are bound using the {@code namespace} prefix</p>
 *
 * <pre>
 *     namespace:
 *      environment: prod
 *      application: e-commerce
 * </pre>
 *
 * @param environment the deployment environment
 * @param application the application name
 *
 * @since 1.0.0
 */

@ConfigurationProperties(prefix = "namespace")
public record NamespaceProperties(
         String environment,
         String application
) {}
