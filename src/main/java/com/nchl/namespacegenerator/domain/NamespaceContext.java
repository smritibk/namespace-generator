package com.nchl.namespacegenerator.domain;

import com.nchl.namespacegenerator.context.ExecutionContext;

import java.util.ArrayList;
import java.util.List;

public record NamespaceContext(
        List<String> namespacePrefix,
        ExecutionContext executionContext,
        List<String> identitySegments
) {
    public NamespaceContext {
        namespacePrefix=List.copyOf(namespacePrefix);
        identitySegments = List.copyOf(identitySegments);
    }

    public List<String> namespaceSegments() {
        List<String> segments = new ArrayList<>();

        segments.addAll(namespacePrefix);
        segments.addAll(executionContext.contextSegments());
        segments.addAll(identitySegments);

        return List.copyOf(segments);
    }

}
