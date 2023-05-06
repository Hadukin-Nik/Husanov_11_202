package org.example.first;

import org.example.Author;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;


public class EasyCheckerAnnotation {

    public static void main(String[] args) {
        try {
            Class a = Class.forName("org.example.EmptyClass");

            if(a.getAnnotation(Author.class) != null) {
                Field[] f = a.getDeclaredFields();
                for(var i : f) {
                    System.out.println(i.getName());
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
