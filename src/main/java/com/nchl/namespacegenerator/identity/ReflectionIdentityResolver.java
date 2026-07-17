package com.nchl.namespacegenerator.identity;

import com.nchl.namespacegenerator.annotation.NamespaceId;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ReflectionIdentityResolver implements IdentityResolver {

    private final IdentityNamingStrategy strategy;

    public ReflectionIdentityResolver(IdentityNamingStrategy strategy){
        this.strategy=strategy;
    }

    @Override
    public List<String> resolve(Object payload) {

//        List<String> identities = new ArrayList<>();
        List<IdentitySegment> segments = new ArrayList<>();

        Class<?> type = payload.getClass();

        Field[] fields = type.getDeclaredFields();

        for (Field field : fields) {

//            if (!field.getType().equals(String.class)) {
//                continue;
//            }

            NamespaceId annotation = field.getAnnotation(NamespaceId.class);

            if (annotation == null) {
                continue;
            }

            field.setAccessible(true);

            try {

                Object value = field.get(payload);

                if (value != null) {
//                    identities.add(value.toString());
                    segments.add(
                            new IdentitySegment(
                                    annotation.order(),
                                    String.valueOf(value)
                            )
                    );

                }
            } catch (IllegalAccessException ex) {
                throw new IllegalStateException(
                        "Unable to access identity fields: " + field.getName(),
                        ex
                );
            }
        }

        if (segments.isEmpty()){
            return resolveUsingReflection(payload);
        }

        segments.sort(
                Comparator.comparingInt(IdentitySegment::order)
        );

        return segments.stream()
                .map(IdentitySegment::value)
                .toList();

//        return List.copyOf(identities);
    }

    private List<String> resolveUsingReflection(Object payload){

        List<String> identities = new ArrayList<>();

        for (Field field:payload.getClass().getDeclaredFields()){

//            if (!field.getType().equals(String.class)){
//                continue;
//            }

            if (!strategy.isIdentity(field)){
                continue;
            }

            field.setAccessible(true);

            try {
                Object value= field.get(payload);

                if (value!=null){
                    identities.add(value.toString());
                }
            }catch (IllegalAccessException ex){
                throw new IllegalStateException(
                        "Unable to access identity field: "+field.getName()
                );
            }
        }
        return identities;
    }
}
