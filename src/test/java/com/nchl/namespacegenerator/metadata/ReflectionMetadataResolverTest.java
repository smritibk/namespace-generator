//package com.nchl.namespacegenerator.metadata;
//
//import com.nchl.namespacegenerator.identity.DefaultIdentityNamingStrategy;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//class ReflectionMetadataResolverTest {
//
//    MetadataNamingStrategy strategy;
//
//    record RegisterRequest(
//            String email,
//            String password
//    ) {
//    }
//
//    @BeforeEach
//    void setup(){
//        strategy=new DefaultMetadataNamingStrategy();
//    }
//
//    @Test
//    void shouldResolverMetadata() {
//
//        ReflectionMetadataResolver resolver =
//                new ReflectionMetadataResolver(strategy);
//
//        List<String> result =
//                resolver.resolve(
//                        new RegisterRequest(
//                                "smriti@gmail.com",
//                                "smriti@123"
//                        )
//                );
//
//        Assertions.assertFalse(result.isEmpty());
//    }
//}
