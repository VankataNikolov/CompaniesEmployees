package softuni.linkedout_validationlab.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.linkedout_validationlab.model.binding.EmployeeAddBindingModel;
import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;
import softuni.linkedout_validationlab.model.service.EmployeeServiceModel;
import softuni.linkedout_validationlab.service.CompaniesService;
import softuni.linkedout_validationlab.service.EmployeesService;

import javax.validation.Valid;
import java.util.List;

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
    public String employeeAll(){
        return "employee-all";
    }
}
