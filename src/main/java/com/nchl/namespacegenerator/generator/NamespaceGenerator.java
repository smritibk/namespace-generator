package com.nchl.namespacegenerator.generator;

import com.nchl.namespacegenerator.key.NamespaceBuilder;


public class NamespaceGenerator {
    private final NamespaceBuilder builder;

    public NamespaceGenerator(NamespaceBuilder builder){
        this.builder=builder;
    }

    public String generate(String... segments){
        return builder.build(segments);
    }
}
