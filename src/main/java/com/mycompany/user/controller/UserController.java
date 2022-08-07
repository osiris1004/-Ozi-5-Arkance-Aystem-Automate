package com.mycompany.user.controller;

import com.mycompany.model.Application;
import com.mycompany.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("/user")
    public  String showUserPage(){
        // direct to the page index
        return "user";
    }

    /// Display application form and pass the object to your html
    @GetMapping("/user/applicationForm")
    public  String showApplicationFormPage(Model model){
        // direct to the page index
        model.addAttribute("application", new Application());
        return "applicationForm";
    }

    // save the new applied application
    @PostMapping("/user/processApplication")
    public  String processApplication(Application application){
        service.saveApplication(application);
    // direct to the page index
        return "redirect:/user";
    }


    /// Display application list
    @GetMapping("/user/application")
    public  String showApplicationList(Model model){
        // execute our business logic
        List<Application> applicationList = service.listsApplication();
        // we put the <listUser> in to the model attribute, so that we can have access in the view
        model.addAttribute("applicationList", applicationList);
        // name of your html template
        return "application";
    }
}
