package softuni.linkedout_validationlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.linkedout_validationlab.model.binding.CompanyAddBindingModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping("add")
    public String companyAdd(Model model){
        if(!model.containsAttribute("companyAddBindingModel")){
            model.addAttribute("companyAddBindingModel", new CompanyAddBindingModel());
        }

        return "company-add";
    }

    @PostMapping("/add")
    public String companyAddConfirm(@Valid CompanyAddBindingModel companyAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("companyAddBindingModel", companyAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyAddBindingModel", bindingResult);
            return "redirect:add";
        }

        return "redirect:all";
    }

    @GetMapping("all")
    public String companyAll(Model model){
        return "company-all";
    }
}

