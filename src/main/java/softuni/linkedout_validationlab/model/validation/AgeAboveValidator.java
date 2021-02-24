package softuni.linkedout_validationlab.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeAboveValidator implements ConstraintValidator<AgeAbove, LocalDate> {

    private int age;

    @Override
    public void initialize(AgeAbove constraintAnnotation) {
        age = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {

        try{
            int currentYears = Period.between(birthDate, LocalDate.now()).getYears();
            return currentYears - age >= 0;
        }catch (Exception e){
            return false;
        }

    }
}
