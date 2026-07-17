package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Declares the resources segments that should appear
 * in the generated namespace.
 *
 * <p>When present, the framework uses the supplied values instead of
 * deriving resource names from the class name.</p>
 *
 * <pre>
 *     {@code
 *     @NamespaceResource({"user","registration"})
 *     public record RegisterRequest(...){}
 *     }
 * </pre>
 *
 * @since 1.0.0
 */

@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface NamespaceResource {
    String[] value();
}
