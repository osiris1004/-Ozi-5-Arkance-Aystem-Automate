package com.mycompany;

import com.mycompany.model.User;
import com.mycompany.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

    // reference to your userRepository
    @Autowired private UserRepository repo;


    @GetMapping("/")
    public  String showHomePage(){
        // direct to the page index
        return "index";
    }

    @GetMapping("/register")
    public  String showSignUpForm(Model model){
        model.addAttribute("user", new User());
        // direct to the page index
        return "signUpForm";
    }


//post hander
    @PostMapping("/processRegister")
    public  String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //User user user gotten from registration

        repo.save(user);
        return "registerSuccess";
    }

    @GetMapping("/user")
    public  String showUserPage(){
        // direct to the page index
        return "user";
    }


    @GetMapping("/login")
    public  String showLoginPage(){
        // direct to the page index
        return "login";
    }


}