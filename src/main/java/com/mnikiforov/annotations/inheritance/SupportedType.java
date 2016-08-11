package com.mnikiforov.annotations.inheritance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sbt-nikiforov-mo on 11.08.16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedType {

    String type() default "";

    String[] types() default {};
}
