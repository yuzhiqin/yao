package com.shu.yao.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface YaoRequestMapping {

	public String value() default "";
	
}
