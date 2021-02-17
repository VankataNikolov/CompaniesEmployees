package softuni.linkedout_validationlab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.entity.EmployeeEntity;
import softuni.linkedout_validationlab.model.service.CompanyServiceModel;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;
import softuni.linkedout_validationlab.repository.EmployeesRepository;
import softuni.linkedout_validationlab.service.CompaniesService;
import softuni.linkedout_validationlab.service.EmployeesService;

import java.time.LocalDate;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final CompaniesService companiesService;
    private final ModelMapper modelMapper;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository, CompaniesService companiesService, ModelMapper modelMapper) {
        this.employeesRepository = employeesRepository;
        this.companiesService = companiesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveNewEmployee(EmployeeServiceModel employeeServiceModel, EmployeeAddBindingModel employeeAddBindingModel) {
        employeeServiceModel.setCompany(this.modelMapper.map(this.companiesService.findCompanyByName(employeeAddBindingModel.getCompany()), CompanyServiceModel.class));
        employeeServiceModel.setBirthDate(LocalDate.of(
                Integer.parseInt(employeeAddBindingModel.getBirthDate().substring(1, 4)),
                Integer.parseInt(employeeAddBindingModel.getBirthDate().substring(6, 7)),
                Integer.parseInt(employeeAddBindingModel.getBirthDate().substring(9, 10))));
        this.employeesRepository.save(this.modelMapper.map(employeeServiceModel, EmployeeEntity.class));
    }
}
