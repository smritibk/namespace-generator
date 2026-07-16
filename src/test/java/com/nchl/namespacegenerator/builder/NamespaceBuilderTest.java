package com.nchl.namespacegenerator.builder;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.context.ExecutionContext;
import com.nchl.namespacegenerator.domain.Namespace;
import static org.junit.jupiter.api.Assertions.*;

import com.nchl.namespacegenerator.domain.NamespaceContext;
import com.nchl.namespacegenerator.exception.InvalidNamespaceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NamespaceBuilderTest {

    private final NamespaceValidator validator =
            new NamespaceValidator();

    private final NamespaceBuilder builder =
            new NamespaceBuilder(validator);

//    private final NamespaceContext context=
//            new NamespaceContext(
//                    new Namespace("prod", "bookverse"),
//                    new ExecutionContext(
//                            List.of("auth", "registration")
//                    ),
//                    List.of("user"),
//                    List.of("USR-1001")
//            );
//
//
//    String expected=String.join(
//            NamespaceConstants.SEPARATOR,
//            "prod",
//            "bookverse",
//            "auth",
//            "registration",
//            "user",
//            "USR-1001"
//    );

    @Test
    void shouldBuildNamespace(){

        NamespaceContext context =
                new NamespaceContext(
                        new Namespace(
                                "prod",
                                "bookverse"
                        ),
                        new ExecutionContext(
                                List.of(
                                        "auth",
                                        "registration"
                                )
                        ),
                        List.of("user"),
                        List.of("USR-1001")
                );

        String result = builder.build(context);

        Assertions.assertEquals(
                "prod:bookverse:auth:registration:user:USR-1001",
                result
        );
    }

//    @Test
//    void shouldBuildNamespace(){
//        String key = builder.build(context);
//
//        assertEquals(
//                expected,
//                key
//        );
//    }
//
//    @Test
//    void shouldIgnoreBlankSegments(){
//        String key = builder.build(context);
//
//        assertEquals(
//                expected,
//                key
//        );
//    }
//
//    @Test
//    void shouldThrowExceptionForDelimiterInjection(){
//
//        assertThrows(
//                InvalidNamespaceException.class,
//                ()->builder.build(context)
//        );
//    }
//
//    @Test
//    void shouldThrowExceptionWhenAllSegmentAreInvalid(){
//
//        assertThrows(
//                InvalidNamespaceException.class,
//                ()->builder.build(context)
//        );
//    }
}
