package softuni.linkedout_validationlab.service;

import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;

import java.util.List;

public interface EmployeesService {

    void saveNewEmployee(EmployeeServiceModel employeeServiceModel, EmployeeAddBindingModel employeeAddBindingModel);

    List<EmployeeServiceModel> getAllEmployees();

    EmployeeServiceModel getEmployeeById(String id);

    void deleteEmployee(String id);
}
