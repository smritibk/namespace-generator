package com.nchl.namespacegenerator.builder;


import com.nchl.namespacegenerator.exception.InvalidNamespaceException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NamespaceValidatorTest {
    private final NamespaceValidator validator = new NamespaceValidator();

    @Test
    void shouldRemoveNullAndBlankSegments() {

        List<String> result =
                validator.validate(
                        List.of(
                                "auth",
                                "",
                                "otp"
                        )
                );

        Assertions.assertEquals(
                List.of(
                        "auth",
                        "otp"
                ),
                result
        );
    }

//    @Test
//    void shouldIgnoreBlankSegments() {
//        List<String> result =
//                validator.validate("otp", "", "user", "1001");
//
//        assertEquals(
//                List.of("otp", "user", "1001"),
//                result
//        );
//    }

//    @Test
//    void shouldIgnoreNullSegments() {
//        List<String> result =
//                validator.validate(List.of("otp", null, "user", "1001"));
//
//        assertEquals(
//                List.of("otp", "user", "1001"),
//                result
//        );
//    }

//    @Test
//    void shouldThrowExceptionWhenAllSegmentsAreInvalid(){
//         assertThrows(
//                InvalidNamespaceException.class,
//                ()->validator.validate(null, "", " ")
//        );
//    }

    @Test
    void shouldRejectSeparatorInsideSegment() {

        Assertions.assertThrows(
                InvalidNamespaceException.class,
                () -> validator.validate(
                        List.of("au:th")
                )
        );
    }

}
