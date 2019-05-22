package com.yd.web.annotations;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@RequestMapping
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface YDRequest {
    String path();

    RequestMethod[] method() default {RequestMethod.POST,RequestMethod.GET};
}
