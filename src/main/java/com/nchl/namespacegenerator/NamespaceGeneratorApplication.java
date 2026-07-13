package com.nchl.namespacegenerator;

import com.nchl.namespacegenerator.configuration.NamespaceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NamespaceProperties.class)
public class NamespaceGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NamespaceGeneratorApplication.class, args);
    }

}
