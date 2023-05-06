package org.example.fourth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface Test {
    Class <? extends Throwable> expected() default NullException.class;

}
