package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.*;

/**
 * Declares execution context segments for a method
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NamespaceContext {
    String[] value();
}
