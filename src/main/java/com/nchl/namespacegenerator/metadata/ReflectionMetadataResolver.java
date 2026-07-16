package com.nchl.namespacegenerator.metadata;

import java.util.List;

public class ReflectionMetadataResolver implements MetadataResolver {

    @Override
    public List<String> resolve(Object payload) {
        String className =
                payload.getClass().getSimpleName();

        return List.of(className);
    }
}
