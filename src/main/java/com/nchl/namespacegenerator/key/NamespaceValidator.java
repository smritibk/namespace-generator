package com.nchl.namespacegenerator.key;

import com.nchl.namespacegenerator.constant.NamespaceConstants;
import com.nchl.namespacegenerator.exception.InvalidNamespaceException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NamespaceValidator {

    private static final String DELIMITER = ":";

    public List<String> validate(String... segments){

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
                    "Namespace key must contain at least one valid segment."
            );
        }
        return cleanedSegments;
    }

    private void validateSegment(String segment){
        if(segment.contains(NamespaceConstants.SEPARATOR)){
            throw new InvalidNamespaceException(
                    "Namespace key segments must not contain ':' ."
            );
        }
    }
}
