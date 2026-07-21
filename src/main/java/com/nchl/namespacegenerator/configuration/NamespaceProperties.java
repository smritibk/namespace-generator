package com.nchl.namespacegenerator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

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

 *
 * @since 1.0.0
 */

@ConfigurationProperties(prefix = "namespace")
public class NamespaceProperties {

    private String environment;
    private String application;

    public String getEnvironment() {
        return environment;
    }

    public String getApplication() {
        return application;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public List<String> segments() {

        List<String> segments = new ArrayList<>();

        if (environment != null && !environment.isBlank()) {
            segments.add(environment);
        }

        if (application != null && !application.isBlank()) {
            segments.add(application);
        }

        return List.copyOf(segments);
    }
}