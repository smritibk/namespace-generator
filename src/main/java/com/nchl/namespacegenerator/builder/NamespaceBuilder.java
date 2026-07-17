package com.nchl.namespacegenerator.builder;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.domain.Namespace;
import com.nchl.namespacegenerator.domain.NamespaceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class NamespaceBuilder {

//    private final Namespace namespace;
    private final NamespaceValidator validator;

    public NamespaceBuilder( NamespaceValidator validator) {
//        this.namespace = namespace;
        this.validator = validator;
    }

    public String build(NamespaceContext context) {

//        List<String> segments = new ArrayList<>();
//
//        segments.add(context.namespace().environment());
//        segments.add(context.namespace().application());
//
//        segments.addAll(context.executionContext().segments());
//        segments.addAll(context.resourceSegments());
//        segments.addAll(context.identitySegments());

        List<String> validateSegments = validator.validate(context.namespaceSegments());

        return String.join(
                NamespaceConstants.SEPARATOR,
                validateSegments
        );
    }

}
