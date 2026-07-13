package com.nchl.namespacegenerator.key;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.domain.Namespace;
import static org.junit.jupiter.api.Assertions.*;

import com.nchl.namespacegenerator.exception.InvalidNamespaceException;
import org.junit.jupiter.api.Test;

public class NamespaceBuilderTest {

    private final Namespace namespace =
            new Namespace("prod", "auth-service");

    private final NamespaceValidator validator =
            new NamespaceValidator();

    private final NamespaceBuilder builder =
            new NamespaceBuilder(namespace, validator);

    String expected=String.join(
            NamespaceConstants.SEPARATOR,
            "prod",
            "auth-service",
            "otp",
            "1001"
    );

    @Test
    void shouldBuildNamespace(){
        String key = builder.build("otp", "1001");

        assertEquals(
                expected,
                key
        );
    }

    @Test
    void shouldIgnoreBlankSegments(){
        String key = builder.build("otp", "", "1001");

        assertEquals(
                expected,
                key
        );
    }

    @Test
    void shouldThrowExceptionForDelimiterInjection(){

        assertThrows(
                InvalidNamespaceException.class,
                ()->builder.build("otp", "user:1001")
        );
    }

    @Test
    void shouldThrowExceptionWhenAllSegmentAreInvalid(){

        assertThrows(
                InvalidNamespaceException.class,
                ()->builder.build("", null, " ")
        );
    }
}
