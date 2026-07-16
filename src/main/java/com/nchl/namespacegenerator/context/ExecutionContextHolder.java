package com.nchl.namespacegenerator.context;

import java.util.*;

public final class ExecutionContextHolder {

    private static final ThreadLocal<Deque<String>> CONTEXT =
            ThreadLocal.withInitial(ArrayDeque::new);

    private ExecutionContextHolder(){}

    private static void push(String segment){
        CONTEXT.get().push(segment);
    }

    public static Scope enter(String segment){
        push(segment);
        return new Scope();
    }

    private static void pop(){
        Deque<String> stack = CONTEXT.get();

        if(!stack.isEmpty()){
            stack.pop();
        }

        if (stack.isEmpty()){
            CONTEXT.remove();
        }
    }

    public static final class Scope implements AutoCloseable{

        @Override
        public void close() throws Exception {
            pop();
        }
    }

    public static ExecutionContext getContext(){
        Deque<String> stack= CONTEXT.get();

        List<String> segments = new ArrayList<>(stack);

        // reversing the execution order as the stack is LIFO
        Collections.reverse(segments);

        return new ExecutionContext(segments);
    }

    public static void clear(){
        CONTEXT.remove();
    }

}
