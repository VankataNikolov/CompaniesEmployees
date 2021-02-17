package softuni.linkedout_validationlab.service;

import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;

public interface EmployeesService {

    void saveNewEmployee(EmployeeServiceModel employeeServiceModel, EmployeeAddBindingModel employeeAddBindingModel);
}
