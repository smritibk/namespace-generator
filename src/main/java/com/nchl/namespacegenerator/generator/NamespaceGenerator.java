package com.nchl.namespacegenerator.generator;

import com.nchl.namespacegenerator.builder.NamespaceBuilder;
import com.nchl.namespacegenerator.context.ContextResolver;
import com.nchl.namespacegenerator.context.ExecutionContext;
import com.nchl.namespacegenerator.domain.NamespaceContext;
import com.nchl.namespacegenerator.prefix.PrefixResolver;

import java.util.Arrays;
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
 * <p>
 * and
 * <p>
 * implementations.</p>
 *
 * <p>This class is the primary entry point of the library</p>
 *
 * @author smritibk
 * @since 1.0.0
 */


public class NamespaceGenerator {
    private final PrefixResolver prefixResolver;
    private final ContextResolver contextResolver;
    private final NamespaceBuilder builder;

    public NamespaceGenerator(
            PrefixResolver prefixResolver,
            ContextResolver contextResolver,
            NamespaceBuilder builder) {

        this.prefixResolver=prefixResolver;
        this.contextResolver = contextResolver;

        this.builder = builder;
    }

    /**
     * Generated a namespace for the supplied identifier
     * used to generate the namespace
     *
     * @return a validated namespace string
     * @throws com.nchl.namespacegenerator.exception.InvalidNamespaceException if the generated namespace
     *                                                                         is invalid or no identity can be resolved
     */

    public String generate(
//            String... identifier
    ) {
        ExecutionContext executionContext = contextResolver.resolve();

//        List<String> identifierSegments =
//                identifier == null
//                        ? List.of()
//                        : Arrays.asList(identifier);

//        System.out.println("Generator called");

        NamespaceContext context =
                new NamespaceContext(
                        prefixResolver.resolve(),
                        executionContext
//                        identifierSegments
                );

        return builder.build(context);
    }
}
