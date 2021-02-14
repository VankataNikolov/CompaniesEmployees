package softuni.linkedout_validationlab.model.validation;

import softuni.linkedout_validationlab.model.entity.CompanyEntity;
import softuni.linkedout_validationlab.service.CompaniesService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCompanyNameValidator implements ConstraintValidator<UniqueCompanyName, String>  {

    private final CompaniesService companiesService;

    public UniqueCompanyNameValidator(CompaniesService companiesService) {
        this.companiesService = companiesService;
    }

    @Override
    public void initialize(UniqueCompanyName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext constraintValidatorContext) {
        CompanyEntity companyByName = this.companiesService.findCompanyByName(companyName);
        return companyByName == null;
}
}
