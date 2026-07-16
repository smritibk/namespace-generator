package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks the field as part of the namespace identity.
 */

@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface NamespaceId {
    int order() default 0;
}
