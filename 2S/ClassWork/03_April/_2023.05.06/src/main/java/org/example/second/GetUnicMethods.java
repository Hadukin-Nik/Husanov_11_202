package org.example.second;

import org.example.Author;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GetUnicMethods {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        try {
            Class a = Class.forName("org.example.EmptyClass");

            if(a.getAnnotation(Author.class) != null) {
                Method[] f = a.getMethods();
                for(var i : f) {
                    names.add(i.getName());
                }
            }

            for(var i : names) {
                System.out.println(i);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
