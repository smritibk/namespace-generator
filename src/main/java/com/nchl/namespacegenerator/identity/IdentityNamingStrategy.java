package com.nchl.namespacegenerator.identity;

import java.lang.reflect.Field;

public interface IdentityNamingStrategy {

    boolean isIdentity(Field field);
}
