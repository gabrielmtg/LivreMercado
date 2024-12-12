package test;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Professor Cancian
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestAnnotation {

	/**
	 *
	 * @return
	 */
	String points() default "1.0";

	/**
	 *
	 * @return
	 */
	String reductions() default "0.0";
}

