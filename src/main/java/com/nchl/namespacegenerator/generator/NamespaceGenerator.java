package com.nchl.namespacegenerator.generator;

import com.nchl.namespacegenerator.builder.NamespaceBuilder;
import com.nchl.namespacegenerator.context.ContextResolver;
import com.nchl.namespacegenerator.context.ExecutionContext;
import com.nchl.namespacegenerator.domain.Namespace;
import com.nchl.namespacegenerator.domain.NamespaceContext;
import com.nchl.namespacegenerator.identity.IdentityResolver;
import com.nchl.namespacegenerator.metadata.MetadataResolver;

import java.util.List;

/**
 * Generates a namespace from the current execution context,
 * payload metadata, and identity information.
 *
 * <p> The generated namespace follows the structure:<p/>
 *
 * <pre>
 *     environment:application:context...:resource..:identity...
 * </pre>
 *
 * <p>Metadata and identity are resolved through the configured
 * {@link com.nchl.namespacegenerator.metadata.MetadataResolver}
 * and
 * {@link com.nchl.namespacegenerator.identity.IdentityResolver}
 * implementations.</p>
 *
 * <p>This class is the primary entry point of the library</p>
 *
 * @author smritibk
 * @since 1.0.0
 */


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
        this.namespace = namespace;
        this.contextResolver = contextResolver;
        this.metadataResolver = metadataResolver;
        this.identityResolver = identityResolver;
        this.builder = builder;
    }

    /**
     * Generated a namespace for the supplied payload
     *
     * @param payload the object whose metadata and identity will be
     *                used to generate the namespace
     * @return a validated namespace string
     * @throws com.nchl.namespacegenerator.exception.InvalidNamespaceException if the generated namespace
     *                                                                         is invalid or no identity can be resolved
     */

    public String generate(Object payload) {
        ExecutionContext executionContext = contextResolver.resolve();

        List<String> resourceSegments =
                metadataResolver.resolve(payload);

        List<String> identitySegments =
                identityResolver.resolve(payload);

        NamespaceContext context =
                new NamespaceContext(
                        namespace,
                        executionContext,
                        resourceSegments,
                        identitySegments
                );

        return builder.build(context);
    }
}
