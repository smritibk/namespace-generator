package com.nchl.namespacegenerator.context;

import java.util.*;

public final class ExecutionContextHolder {

    private static final ThreadLocal<Deque<String>> CONTEXT =
            ThreadLocal.withInitial(ArrayDeque::new);

    private static final ThreadLocal<Deque<Scope>> SCOPES =
            ThreadLocal.withInitial(ArrayDeque::new);

    private ExecutionContextHolder() {
    }

    private static void push(String segment) {
        CONTEXT.get().push(segment);
    }

    public static Scope enter(String... segments) {

        int depth = 0;

        for (String segment : segments) {

            if (segment == null || segment.isBlank()) {
                continue;
            }

            push(segment);
            depth++;
        }

        Scope scope = new Scope(depth);

        SCOPES.get().push(scope);

        return scope;
    }

    private static void pop() {
        Deque<String> stack = CONTEXT.get();

        if (!stack.isEmpty()) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            CONTEXT.remove();
        }
    }

    public static void append(String... segments) {

        Scope currentScope = SCOPES.get().peek();

        if (currentScope==null){
            throw new IllegalArgumentException("No active namespace context.");
        }

        for (String segment : segments) {
            if (segment == null || segment.isBlank()) {
                continue;
            }
            push(segment);

            currentScope.increment();
        }
    }

    public static final class Scope implements AutoCloseable {

        private int depth;

        Scope(int depth) {
            this.depth = depth;
        }

        void increment() {
            depth++;
        }

        @Override
        public void close() throws Exception {

            for (int i = 0; i < depth; i++) {
                pop();
            }

            SCOPES.get().pop();

            if (SCOPES.get().isEmpty()) {
                SCOPES.remove();
            }
        }
    }

    public static ExecutionContext current() {
        Deque<String> stack = CONTEXT.get();

        List<String> segments = new ArrayList<>(stack);

        // reversing the execution order as the stack is LIFO
        Collections.reverse(segments);

        return new ExecutionContext(segments);
    }

    public static void clear() {
        CONTEXT.remove();
    }

}
