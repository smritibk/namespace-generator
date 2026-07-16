package com.nchl.namespacegenerator.context;

import java.util.List;

public record ExecutionContext(
        List<String> segments
) {
    public ExecutionContext{
        segments=List.copyOf(segments);
    }
}
