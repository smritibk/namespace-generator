package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.*;

/**
 * Declares execution context segments for the annotated method.
 *
 * <p>This annotation is intended for automatic context propagation
 * through Spring AOP. When supported, the declared context
 * segments are added to the current execution context before the
 * method executes and removed afterward</p>
 *
 * @since 1.0.0
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NamespaceContext {
    String[] value();
}
