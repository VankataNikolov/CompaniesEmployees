package softuni.linkedout_validationlab.service;

import softuni.linkedout_validationlab.model.entity.CompanyEntity;
import softuni.linkedout_validationlab.model.service.CompanyServiceModel;
import softuni.linkedout_validationlab.model.view.CompanySecondaryViewModel;

import java.util.List;

public interface CompaniesService {

    List<CompanySecondaryViewModel> getAllCompanies();

    CompanyServiceModel saveNewCompany(CompanyServiceModel companyServiceModel);

    CompanyEntity findCompanyByName(String companyName);
}
