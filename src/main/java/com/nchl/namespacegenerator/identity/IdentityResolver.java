package com.nchl.namespacegenerator.identity;

import java.util.List;

public interface IdentityResolver {
    List<String> resolve(Object payload);
}
