//package com.nchl.namespacegenerator.generator;
//
//import com.nchl.namespacegenerator.builder.NamespaceBuilder;
//import com.nchl.namespacegenerator.builder.NamespaceValidator;
//import com.nchl.namespacegenerator.context.DefaultContextResolver;
//import com.nchl.namespacegenerator.context.ExecutionContextHolder;
//import com.nchl.namespacegenerator.domain.Namespace;
//import com.nchl.namespacegenerator.identity.DefaultIdentityNamingStrategy;
//import com.nchl.namespacegenerator.identity.IdentityNamingStrategy;
//import com.nchl.namespacegenerator.identity.ReflectionIdentityResolver;
////import com.nchl.namespacegenerator.metadata.DefaultMetadataNamingStrategy;
////import com.nchl.namespacegenerator.metadata.MetadataNamingStrategy;
////import com.nchl.namespacegenerator.metadata.ReflectionMetadataResolver;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class NamespaceGeneratorTest {
//
//    record RegisterRequest(
//            String email,
//            String password
//    ){}
//
////    MetadataNamingStrategy metadataNamingStrategy;
//    IdentityNamingStrategy identityNamingStrategy;
//
//    @BeforeEach
//    void setup(){
////        metadataNamingStrategy=new DefaultMetadataNamingStrategy();
//        identityNamingStrategy=new DefaultIdentityNamingStrategy();
//    }
//
//    @AfterEach
//    void cleanup(){
//        ExecutionContextHolder.clear();
//    }
//
//    @Test
//    void shouldGenerateNamespace(){
//
//        NamespaceGenerator generator =
//                new NamespaceGenerator(
//                        new Namespace(
//                                "prod",
//                                "bookverse"
//                        ),
//                        new DefaultContextResolver(),
////                        new ReflectionMetadataResolver(metadataNamingStrategy),
//                        new ReflectionIdentityResolver(identityNamingStrategy),
//                        new NamespaceBuilder(
//                                new NamespaceValidator()
//                        )
//                );
//
//        ExecutionContextHolder.enter("auth");
//        ExecutionContextHolder.enter("registration");
//
//        String result = generator.generate(
//                new RegisterRequest(
//                        "smriti@gmail.com",
//                        "smrit@123"
//                )
//        );
//
//        Assertions.assertNotNull(result);
//        Assertions.assertFalse(result.isBlank());
//    }
//}
