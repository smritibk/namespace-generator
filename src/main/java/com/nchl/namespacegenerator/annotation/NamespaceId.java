package com.nchl.namespacegenerator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks the field as part of the namespace identity.
 *
 * <p>Multiple fields may be annotated. The {@code order}
 * attribute determines the order in which identity segments
 * appear in the generated namespace</p>
 *
 * <pre>
 *     {@code
 *     @NamespaceId(order = 1)
 *     private UUID publicId;
 *
 *     @NamespaceId(order = 2)
 *     private String email;
 *     }
 * </pre>
 *
 * @since 1.0.0
 */

@Documented
@Target(FIELD)
@Retention(RUNTIME)
public @interface NamespaceId {

    /**
     * Specifies the position of this identity segment within the
     * generated namespace.
     *
     * <p>Identity segments are ordered in the ascending order</p>
     *
     * @return the position of this identity segment
     */
    int order() default 0;
}
