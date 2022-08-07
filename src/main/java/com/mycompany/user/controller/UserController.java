package com.mycompany.user.controller;

import com.mycompany.model.Application;
import com.mycompany.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/user/applicationForm")
    public  String showApplicationFormPage(){
        // direct to the page index
        return "applicationForm";
    }

    /// Display application list
    @GetMapping("/user/application")
    public  String showApplicationList(Model model){
        // execute our business logic
        List<Application> listUsers = service.listAll();
        // we put the <listUser> in to the model attribute, so that we can have access in the view
        model.addAttribute("listUsers", listUsers);
        // name of your html template
        return "application";
    }
}
