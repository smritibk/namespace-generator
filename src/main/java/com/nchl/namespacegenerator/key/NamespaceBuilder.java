package com.nchl.namespacegenerator.key;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.domain.Namespace;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class NamespaceBuilder {

    private final Namespace namespace;
    private final NamespaceValidator validator;

    public NamespaceBuilder(Namespace namespace, NamespaceValidator validator) {
        this.namespace = namespace;
        this.validator = validator;
    }

    public String build(String... segments) {

        List<String> validateSegments = validator.validate(segments);

        List<String> keySegments = new ArrayList<>(namespace.segments());

        keySegments.addAll(validateSegments);

        StringJoiner joiner = new StringJoiner(NamespaceConstants.SEPARATOR);

        keySegments.forEach(joiner::add);

        return joiner.toString();
    }

}
