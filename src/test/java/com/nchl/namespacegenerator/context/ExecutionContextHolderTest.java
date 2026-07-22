package com.nchl.namespacegenerator.context;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExecutionContextHolderTest {

    @AfterEach
    void cleanup() {
        ExecutionContextHolder.clear();
    }

    @Test
    void shouldStoreExecutionSegments() {

        ExecutionContextHolder.enter("auth");
        ExecutionContextHolder.enter("registration");

        ExecutionContext context = ExecutionContextHolder.current();

        Assertions.assertEquals(
                List.of("auth", "registration"),
                context.contextSegments()
        );
    }

    @Test
    void shouldClearExecutionContext() {
        ExecutionContextHolder.enter("auth");

        ExecutionContextHolder.clear();

        Assertions.assertTrue(
                ExecutionContextHolder.current().contextSegments().isEmpty()
        );
    }

    @Test
    void shouldAppendSegmentWithinScope() throws Exception {
        try (ExecutionContextHolder.Scope ignored = ExecutionContextHolder.enter("user")
        ){
            ExecutionContextHolder.append("1001");

            ExecutionContext context=ExecutionContextHolder.current();

            System.out.println(context.contextSegments());

            Assertions.assertEquals(
                    List.of("user", "1001"),
                    context.contextSegments()
            );
        }

        Assertions.assertTrue(
                ExecutionContextHolder.current().isEmpty()
        );
    }

    @Test
    void shouldHandleNestedScopes() throws Exception{
        try (ExecutionContextHolder.Scope ignored =
                     ExecutionContextHolder.enter("user")) {

            ExecutionContextHolder.append("1001");

            try (ExecutionContextHolder.Scope ignored2 =
                         ExecutionContextHolder.enter("verify", "otp")) {

                Assertions.assertEquals(
                        List.of("user","1001","verify","otp"),
                        ExecutionContextHolder.current().contextSegments()
                );
            }

            Assertions.assertEquals(
                    List.of("user","1001"),
                    ExecutionContextHolder.current().contextSegments()
            );
        }

        Assertions.assertTrue(
                ExecutionContextHolder.current().isEmpty()
        );
    }
}
