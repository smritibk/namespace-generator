package com.nchl.namespacegenerator.builder;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.domain.NamespaceContext;

import java.util.List;



public class NamespaceBuilder {

    private final NamespaceValidator validator;

    public NamespaceBuilder( NamespaceValidator validator) {
        this.validator = validator;
    }

    public String build(NamespaceContext context) {

        List<String> validateSegments = validator.validate(context.namespaceSegments());

        return String.join(
                NamespaceConstants.SEPARATOR,
                validateSegments
        );
    }

}
