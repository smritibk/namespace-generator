package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Declares the resources segments that should appear
 * in the generated namespace.
 */

@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface NamespaceResource {
    String[] value();
}
