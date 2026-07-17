package com.nchl.namespacegenerator.identity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReflectionIdentityResolverTest {

    IdentityNamingStrategy strategy;

    record RegisterRequest(
            String email,
            String password
    ){}

    @BeforeEach
    void setup(){
        strategy=new DefaultIdentityNamingStrategy();
    }

    @Test
    void shouldResolveIdentitySegments(){

        ReflectionIdentityResolver resolver =
                new ReflectionIdentityResolver(strategy);

        List<String> identities =
                resolver.resolve(
                        new RegisterRequest(
                                "smriti@gmail.com",
                                "smriti@123"
                        )
                );

        Assertions.assertEquals(
                List.of(
                        "smriti@gmail.com"
                ),
                identities
        );
    }
}
