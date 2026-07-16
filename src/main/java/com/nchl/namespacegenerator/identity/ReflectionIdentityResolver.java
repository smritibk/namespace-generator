package com.nchl.namespacegenerator.identity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionIdentityResolver implements IdentityResolver {

    @Override
    public List<String> resolve(Object payload) {

        List<String> identities = new ArrayList<>();

        Field[] fields = payload.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (!field.getType().equals(String.class)) {
                continue;
            }

            field.setAccessible(true);

            try {

                Object value = field.get(payload);

                if (value != null) {
                    identities.add(value.toString());
                }
            } catch (IllegalAccessException ex) {
                throw new IllegalStateException(
                        "Unable to access identity fields: " + field.getName(),
                        ex
                );
            }
        }
        return List.copyOf(identities);
    }
}
