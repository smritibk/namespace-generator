package com.nchl.namespacegenerator.domain;

import java.util.List;

public record Namespace(
        String environment,
        String application
) {
    public List<String> segments(){
        return List.of(environment, application);
    }
}
