package softuni.linkedout_validationlab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.entity.CompanyEntity;
import softuni.linkedout_validationlab.model.entity.EmployeeEntity;
import softuni.linkedout_validationlab.model.service.CompanyServiceModel;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;
import softuni.linkedout_validationlab.repository.EmployeesRepository;
import softuni.linkedout_validationlab.service.CompaniesService;
import softuni.linkedout_validationlab.service.EmployeesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        CompanyEntity employeeCompany = this.companiesService.findCompanyByName(employeeAddBindingModel.getCompany());
        employeeServiceModel.setCompany(this.modelMapper.map(employeeCompany, CompanyServiceModel.class));
        this.employeesRepository.save(this.modelMapper.map(employeeServiceModel, EmployeeEntity.class));
    }

    @Override
    public List<EmployeeServiceModel> getAllEmployees() {

        return this.employeesRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"))
                .stream()
                .map(entity -> this.modelMapper.map(entity, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeServiceModel getEmployeeById(String id) {
        Optional<EmployeeEntity> employeeBiId = this.employeesRepository.findById(id);
        return this.modelMapper.map(employeeBiId.get(), EmployeeServiceModel.class);
    }

    @Transactional
    @Override
    public void deleteEmployee(String id) {
        this.employeesRepository.deleteEmployee(id);
    }
}
