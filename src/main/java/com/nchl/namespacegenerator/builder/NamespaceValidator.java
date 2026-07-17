package com.nchl.namespacegenerator.builder;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.exception.InvalidNamespaceException;

import java.util.ArrayList;
import java.util.List;

public class NamespaceValidator {

    public List<String> validate(List<String> segments){

        List<String> cleanedSegments = new ArrayList<>();

        for (String segment:segments){

            if(segment==null){
                continue;
            }

            segment=segment.trim();

            if(segment.isEmpty()){
                continue;
            }

            validateSegment(segment);

            cleanedSegments.add(segment);
        }

        if (cleanedSegments.isEmpty()){
            throw new InvalidNamespaceException(
                    "No namespace identity could be resolved. Annotate one or more fields with @NamespaceId or provide matching IdentityNamingStrategy."
            );
        }
        return List.copyOf(cleanedSegments);
    }

    private void validateSegment(String segment){
        if(segment.contains(NamespaceConstants.SEPARATOR)){
            throw new InvalidNamespaceException(
                    "Namespace key segments must not contain ':' ."
            );
        }
    }
}
