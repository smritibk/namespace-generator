//package com.nchl.namespacegenerator.metadata;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class DefaultMetadataNamingStrategy implements MetadataNamingStrategy {
//
//    @Override
//    public List<String> resolve(Class<?> type) {
//        String simpleName = type.getSimpleName();
//
//        return Arrays.stream(
//                        simpleName.split("(?=[A-Z])")
//                )
//                .map(String::toLowerCase)
//                .toList();
//    }
//}
