package com.nchl.namespacegenerator.identity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReflectionIdentityResolverTest {

    record RegisterRequest(
            String email,
            String password
    ){}

    @Test
    void shouldResolveIdentitySegments(){

        ReflectionIdentityResolver resolver =
                new ReflectionIdentityResolver();

        List<String> identities =
                resolver.resolve(
                        new RegisterRequest(
                                "smriti@gmail.com",
                                "smriti@123"
                        )
                );

        Assertions.assertEquals(
                List.of(
                        "smriti@gmail.com",
                        "smriti@123"
                ),
                identities
        );
    }
}
