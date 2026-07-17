package com.nchl.namespacegenerator.domain;

import com.nchl.namespacegenerator.context.ExecutionContext;

import java.util.ArrayList;
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

    public List<String> namespaceSegments(){
        List<String> segments = new ArrayList<>();

        segments.add(namespace.environment());
        segments.add(namespace.application());

        segments.addAll(executionContext.contextSegments());
        segments.addAll(resourceSegments);
        segments.addAll(identitySegments);

        return List.copyOf(segments);
    }

}
