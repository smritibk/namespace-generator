package com.nchl.namespacegenerator.identity;

import java.lang.reflect.Field;
import java.util.Set;

public class DefaultIdentityNamingStrategy implements IdentityNamingStrategy{

    private static final Set<String> IDENTITY_FIELDS=Set.of(
            "id",
            "publicId",
            "email",
            "uuid"
    );

    @Override
    public boolean isIdentity(Field field) {
        return IDENTITY_FIELDS.contains(field.getName());
    }
}
