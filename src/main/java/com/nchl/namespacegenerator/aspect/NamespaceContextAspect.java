package com.nchl.namespacegenerator.aspect;

import com.nchl.namespacegenerator.annotation.NamespaceContext;
import com.nchl.namespacegenerator.context.ExecutionContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class NamespaceContextAspect {

    @Around("@annotation(namespaceContext)")
    public Object around(
            ProceedingJoinPoint joinPoint,
            NamespaceContext namespaceContext
    ) throws Throwable {
        try (ExecutionContextHolder.Scope ignored =
                     ExecutionContextHolder.enter(namespaceContext.value())
        ) {
            return joinPoint.proceed();
        }
    }
}
