package com.nchl.namespacegenerator.context;

public class DefaultContextResolver implements ContextResolver{

    @Override
    public ExecutionContext resolve() {
        return ExecutionContextHolder.getContext();
    }
}
