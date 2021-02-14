package softuni.linkedout_validationlab.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Constraint(validatedBy = UniqueCompanyNameValidator.class)
public @interface UniqueCompanyName {

    String message() default "Company with this name already registered";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
