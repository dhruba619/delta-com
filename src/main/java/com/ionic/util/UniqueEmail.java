package com.ionic.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation that check the uniqueness of username
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueEmailValidator.class })
public @interface UniqueEmail {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
