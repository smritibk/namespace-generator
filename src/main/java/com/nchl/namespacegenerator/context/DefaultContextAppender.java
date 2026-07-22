package com.nchl.namespacegenerator.context;

public class DefaultContextAppender implements ContextAppender{

    @Override
    public void append(String... segments) {
        ExecutionContextHolder.append(segments);
    }
}
