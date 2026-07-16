package com.nchl.namespacegenerator.metadata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReflectionMetadataResolverTest {

    record RegisterRequest(
            String email,
            String password
    ) {
    }

    @Test
    void shouldResolverMetadata() {

        ReflectionMetadataResolver resolver =
                new ReflectionMetadataResolver();

        List<String> result =
                resolver.resolve(
                        new RegisterRequest(
                                "smriti@gmail.com",
                                "smriti@123"
                        )
                );

        Assertions.assertFalse(result.isEmpty());
    }
}
