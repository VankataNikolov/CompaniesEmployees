package softuni.linkedout_validationlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("/add")
    public String employeeAdd(){
        return "employee-add";
    }

    @GetMapping("/all")
    public String employeeAll(){
        return "employee-all";
    }
}
