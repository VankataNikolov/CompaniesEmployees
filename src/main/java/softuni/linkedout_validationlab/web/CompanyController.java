package softuni.linkedout_validationlab.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.linkedout_validationlab.model.binding.CompanyAddBindingModel;
import softuni.linkedout_validationlab.model.service.CompanyServiceModel;
import softuni.linkedout_validationlab.service.CompaniesService;

import javax.validation.Valid;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompaniesService companiesService;
    private final ModelMapper modelMapper;

    public CompanyController(CompaniesService companiesService, ModelMapper modelMapper) {
        this.companiesService = companiesService;
        this.modelMapper = modelMapper;
    }

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

        CompanyServiceModel newCompany = this.companiesService.saveNewCompany(this.modelMapper.map(companyAddBindingModel, CompanyServiceModel.class));
        redirectAttributes.addFlashAttribute("addSuccess", true);
        redirectAttributes.addFlashAttribute("newCompanyName", newCompany.getName());

        return "redirect:all";
    }

    @GetMapping("all")
    public String companyAll(Model model){
        if(!model.containsAttribute("addSuccess")){
            model.addAttribute("addSuccess", false);
        }
        if(!model.containsAttribute("newCompanyName")){
            model.addAttribute("newCompanyName", "name");
        }
        model.addAttribute("companies", this.companiesService.getAllCompanies());

        return "company-all";
    }

    @GetMapping("/details/{id}")
    public String companyDetails(@PathVariable String id, Model model){

        model.addAttribute("company", this.companiesService.getCompanyById(id));

        return "company-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable String id){
        this.companiesService.deleteCompany(id);

        return "redirect:/companies/all";
    }
}

