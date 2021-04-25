package com.sample.agent.advices;

import net.bytebuddy.asm.Advice;

public class MethodAdvice {

    @Advice.OnMethodEnter
    static long enterMethods() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("Enter Method: " + start);
        return start;
    }


    //@Advice.Origin("#t.#m") String detailedOrigin
    @Advice.OnMethodExit
    static void exitMethods(@Advice.Enter long start, @Advice.Origin("#t") String className, @Advice.Origin("#m") String methodName) throws Exception {
        // Calculate execution time of each method
        long end = System.currentTimeMillis();

        // Method name like Class.method
        String lastName = className.substring(className.lastIndexOf(".") + 1);
        String coverName = lastName + "." + methodName;

        System.out.println("This is Method : " + coverName + " took " + (end - start) + " milliseconds");

//        if ("Caching".equalsIgnoreCase(DataCache.getInstance().getStatus())) {
//            DataCache.getInstance().addMethod(coverName);
//        }
    }
}
