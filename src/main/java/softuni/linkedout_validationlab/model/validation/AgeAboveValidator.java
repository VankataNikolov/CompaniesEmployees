package softuni.linkedout_validationlab.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeAboveValidator implements ConstraintValidator<AgeAbove, String> {

    private int age;

    @Override
    public void initialize(AgeAbove constraintAnnotation) {
        age = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String birthDate, ConstraintValidatorContext constraintValidatorContext) {
        if(birthDate == null || birthDate.isEmpty()){
            return false;
        }
        try{
            LocalDate dateBirth = LocalDate.of(
                    Integer.parseInt(birthDate.substring(0, 4)),
                    Integer.parseInt(birthDate.substring(6, 7)),
                    Integer.parseInt(birthDate.substring(9, 10)));
            int currentYears = Period.between(dateBirth, LocalDate.now()).getYears();
            return currentYears - age >= 0;
        }catch (NumberFormatException e){
            return false;
        }

    }
}
