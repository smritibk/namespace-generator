package com.nchl.namespacegenerator.prefix;

import com.nchl.namespacegenerator.configuration.NamespaceProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultPrefixResolver implements PrefixResolver{

    private final NamespaceProperties namespaceProperties;

    public DefaultPrefixResolver(NamespaceProperties namespaceProperties){
        this.namespaceProperties=namespaceProperties;
    }

    @Override
    public List<String> resolve() {

        List<String> segments=new ArrayList<>();

        if (
                namespaceProperties.getEnvironment()!=null &&
                        !namespaceProperties.getEnvironment().isBlank()){
            segments.add(namespaceProperties.getEnvironment());
        }

        if (
                namespaceProperties.getApplication()!=null &&
                        !namespaceProperties.getApplication().isBlank()){
            segments.add(namespaceProperties.getApplication());
        }

        return List.copyOf(segments);
    }
}
