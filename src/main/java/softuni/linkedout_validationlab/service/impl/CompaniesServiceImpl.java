package softuni.linkedout_validationlab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.linkedout_validationlab.model.entity.CompanyEntity;
import softuni.linkedout_validationlab.model.service.CompanyServiceModel;
import softuni.linkedout_validationlab.model.view.CompanySecondaryViewModel;
import softuni.linkedout_validationlab.repository.CompaniesRepository;
import softuni.linkedout_validationlab.service.CompaniesService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompaniesServiceImpl implements CompaniesService {

    private final CompaniesRepository companiesRepository;
    private final ModelMapper modelMapper;

    public CompaniesServiceImpl(CompaniesRepository companiesRepository, ModelMapper modelMapper) {
        this.companiesRepository = companiesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanySecondaryViewModel> getAllCompanies() {
        return this.companiesRepository.findAll(Sort.by(Sort.Direction.ASC, "name"))
                .stream()
                .map(c -> this.modelMapper.map(c, CompanySecondaryViewModel.class)).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public CompanyServiceModel saveNewCompany(CompanyServiceModel companyServiceModel) {
        CompanyEntity savedCompany = this.companiesRepository.save(this.modelMapper.map(companyServiceModel, CompanyEntity.class));
        return this.modelMapper.map(savedCompany, CompanyServiceModel.class);
    }

    @Override
    public CompanyEntity findCompanyByName(String companyName) {

        return this.companiesRepository.findByName(companyName);
    }

    @Override
    public List<String> getAllCompanyNames() {

        return this.companiesRepository.getAllCompanyNames();
    }

    @Override
    public CompanyServiceModel getCompanyById(String id) {

        return this.modelMapper.map(this.companiesRepository.findById(id).get(), CompanyServiceModel.class);
    }

    @Override
    public void deleteCompany(String id) {
        this.companiesRepository.deleteById(id);
    }
}
