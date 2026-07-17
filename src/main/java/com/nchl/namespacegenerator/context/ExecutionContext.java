package com.nchl.namespacegenerator.context;

import java.util.List;

public record ExecutionContext(
        List<String> contextSegments
) {
    public ExecutionContext{
        contextSegments=List.copyOf(contextSegments);
    }

    public boolean isEmpty(){
        return contextSegments().isEmpty();
    }
}
