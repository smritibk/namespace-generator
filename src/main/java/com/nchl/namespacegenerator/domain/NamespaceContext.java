package com.nchl.namespacegenerator.domain;

import com.nchl.namespacegenerator.context.ExecutionContext;

import java.util.List;

public record NamespaceContext(
        Namespace namespace,
        ExecutionContext executionContext,
        List<String> resourceSegments,
        List<String> identitySegments
) {
    public NamespaceContext {
        resourceSegments = List.copyOf(resourceSegments);
        identitySegments = List.copyOf(identitySegments);
    }

}
