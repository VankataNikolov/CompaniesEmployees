package softuni.linkedout_validationlab.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Constraint(validatedBy = AgeAboveValidator.class)
public @interface AgeAbove {

    String message() default "Invalid BirthDate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}
