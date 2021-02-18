package softuni.linkedout_validationlab.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;
import softuni.linkedout_validationlab.model.view.EmployeeSecondaryViewModel;
import softuni.linkedout_validationlab.service.CompaniesService;
import softuni.linkedout_validationlab.service.EmployeesService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final CompaniesService companiesService;
    private final EmployeesService employeesService;
    private final ModelMapper modelMapper;

    public EmployeeController(CompaniesService companiesService,
                              EmployeesService employeesService,
                              ModelMapper modelMapper) {
        this.companiesService = companiesService;
        this.employeesService = employeesService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String employeeAdd(Model model){
        if(!model.containsAttribute("employeeAddBindingModel")){
            model.addAttribute("employeeAddBindingModel", new EmployeeAddBindingModel());
        }
        List<String> allCompanyNames = this.companiesService.getAllCompanyNames();
        EducationLevelsEnum[] educationLevelsEnums = EducationLevelsEnum.values();

        model.addAttribute("allCompanyNames", allCompanyNames);
        model.addAttribute("educationLevelsEnums", educationLevelsEnums);

        return "employee-add";
    }

    @PostMapping("/add")
    public String employeeAddConfirm(@Valid EmployeeAddBindingModel employeeAddBindingModel,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("employeeAddBindingModel",employeeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeAddBindingModel", bindingResult);
            return "redirect:add";
        }

        EmployeeServiceModel newEmployeeServiceModel = this.modelMapper.map(employeeAddBindingModel, EmployeeServiceModel.class);

        this.employeesService.saveNewEmployee(newEmployeeServiceModel, employeeAddBindingModel);

        return "redirect:all";

    }

    @GetMapping("/all")
    public String employeeAll(Model model){

        List<EmployeeSecondaryViewModel> employeeSecondaryViewModels = this.employeesService.getAllEmployees()
                .stream()
                .map(employeeService -> this.modelMapper.map(employeeService, EmployeeSecondaryViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allEmployeesFirstNameAsc", employeeSecondaryViewModels);

        return "employee-all";
    }

    @GetMapping("/details/{id}")
    public String employeeDetails(@PathVariable String id, Model model){

        EmployeeServiceModel employeeById = this.employeesService.getEmployeeById(id);
        model.addAttribute("employee", employeeById);

        return "employee-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        this.employeesService.deleteEmployee(id);

        return "redirect:/employees/all";
    }
}
