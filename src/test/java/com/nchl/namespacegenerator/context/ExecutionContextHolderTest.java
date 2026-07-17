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
}
