package com.nchl.namespacegenerator.generator;

import com.nchl.namespacegenerator.builder.NamespaceBuilder;
import com.nchl.namespacegenerator.context.ContextResolver;
import com.nchl.namespacegenerator.context.ExecutionContext;
import com.nchl.namespacegenerator.domain.Namespace;
import com.nchl.namespacegenerator.domain.NamespaceContext;
import com.nchl.namespacegenerator.identity.IdentityResolver;
import com.nchl.namespacegenerator.metadata.MetadataResolver;

import java.util.List;


public class NamespaceGenerator {
    private final ContextResolver contextResolver;
    private final MetadataResolver metadataResolver;
    private final IdentityResolver identityResolver;
    private final NamespaceBuilder builder;
    private final Namespace namespace;

    public NamespaceGenerator(
            Namespace namespace,
            ContextResolver contextResolver,
            MetadataResolver metadataResolver,
            IdentityResolver identityResolver,
            NamespaceBuilder builder) {
        this.namespace=namespace;
        this.contextResolver = contextResolver;
        this.metadataResolver = metadataResolver;
        this.identityResolver = identityResolver;
        this.builder = builder;
    }

    public String generate(Object payload) {
        ExecutionContext executionContext = contextResolver.resolve();

        List<String> resourceSegments =
                metadataResolver.resolve(payload);

        List<String> identitySegments =
                identityResolver.resolve(payload);

        NamespaceContext context=
                new NamespaceContext(
                        namespace,
                        executionContext,
                        resourceSegments,
                        identitySegments
                );

        return builder.build(context);
    }
}
