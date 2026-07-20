//package com.nchl.namespacegenerator.metadata;
//
//import com.nchl.namespacegenerator.annotation.NamespaceResource;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class ReflectionMetadataResolver implements MetadataResolver {
//
//    private final MetadataNamingStrategy strategy;
//
//    public ReflectionMetadataResolver(MetadataNamingStrategy strategy) {
//        this.strategy = strategy;
//    }
//
//    @Override
//    public List<String> resolve(Object payload) {
////        String className =
////                payload.getClass().getSimpleName();
//
//        Class<?> type = payload.getClass();
//
//        NamespaceResource annotation = type.getAnnotation(NamespaceResource.class);
//
//        if (annotation != null) {
//            return Arrays.asList(annotation.value());
//        }
//
//        return strategy.resolve(type);
//    }
//}
