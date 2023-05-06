package org.example.fourth;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCompiler {
    private Class b_class;

    public TestCompiler(String classname) {
        try {
            b_class = Class.forName(classname);

            List<Method> testMethods = Arrays.stream(b_class.getMethods()).filter(item -> {return item.getAnnotation(Test.class) != null;}).toList();

            List<Method> beforeMethods = Arrays.stream(b_class.getMethods()).filter(item -> {return item.getAnnotation(Before.class) != null;}).toList();
            List<Method> afterMethods = Arrays.stream(b_class.getMethods()).filter(item -> {return item.getAnnotation(After.class) != null;}).toList();



            for(Method m : testMethods) {
                Class test = Class.forName(classname);

                Object object = test.getConstructor(null).newInstance(null);

                Method neededMethod = object.getClass().getMethod(m.getName());
                beforeMethods.stream().forEach(item -> {
                    try {
                        item.invoke(object, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        if (e.getCause().getClass().isInstance(neededMethod.getAnnotation(Test.class).expected().getClass())) {
                            try {
                                throw (Throwable) Class.forName(neededMethod.getAnnotation(Test.class).expected().getClass().getName()).newInstance();
                            } catch (Throwable ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        throw new RuntimeException(e);
                    }
                });

                try {
                    neededMethod.invoke(object, null);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

                afterMethods.stream().forEach(item -> {
                    try {
                        item.invoke(object, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }
}
