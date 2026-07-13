package com.nchl.namespacegenerator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

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

}
