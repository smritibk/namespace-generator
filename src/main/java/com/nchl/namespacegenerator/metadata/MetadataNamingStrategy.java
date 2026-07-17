package com.nchl.namespacegenerator.metadata;

import java.util.List;

public interface MetadataNamingStrategy {

    List<String> resolve (Class<?> type);
}
