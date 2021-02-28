package softuni.linkedout_validationlab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UserController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-failure")
    public String loginFailure(){
        return "login-failure";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }


}
