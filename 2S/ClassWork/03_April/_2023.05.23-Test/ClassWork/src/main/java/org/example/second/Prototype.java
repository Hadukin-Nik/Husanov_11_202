package org.example.second;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public Object copyMachine(Object obj) {
        Class objClass = obj.getClass();
        Object ans;

        try {
            ans = objClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        List<String> parametres = new ArrayList<>();

        for(var i : objClass.getMethods()) {
            String parameter = isGet(i.getName());
            System.out.println("par" + parameter);
            if(parameter != null) {
                parametres.add(parameter);
            }
        }

        for(var i : parametres) {
            try {
                System.out.println("set" + i);
                System.out.println(1);
                Method m = objClass.getMethod("get" + i);
                System.out.println(2);
                Method m2 = objClass.getMethod("set" + i, m.getReturnType());
                System.out.println(3);
                m2.invoke(ans, m.invoke(obj));
                System.out.println(4);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                System.out.println("exception" + e.getMessage());
            }
        }

        return ans;
    }

    private String isGet(String b) {
        if(b.length() > 3) {
            if(b.charAt(0) == 's' && b.charAt(1) == 'e' && b.charAt(2) == 't') {
                StringBuilder ans = new StringBuilder();
                for(int i = 3; i < b.length(); i++) {
                    ans.append(b.charAt(i));
                }

                return ans.toString();
            } else {
                return null;
            }
        }

        return null;
    }
}
