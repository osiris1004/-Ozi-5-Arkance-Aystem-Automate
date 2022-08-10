package com.mycompany.user.controller;

import com.mycompany.job.service.JobService;
import com.mycompany.model.Application;
import com.mycompany.UserNotFoundException;
import com.mycompany.model.Job;
import com.mycompany.user.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ApplicationService service;

    @Autowired
    private JobService _service;

    @GetMapping("/user/applicationForm/new/{id}")
    public  String showApplicationFormPage(Model model,@PathVariable("id") Integer id){
        try {
            Job job = _service.getJobById(id);
            Integer jobId = job.getId();
            String title = job.getTitle();
            String desc = job.getDescription();
            model.addAttribute("jobId", jobId );
            model.addAttribute("title", title);
            model.addAttribute("desc", desc );

            model.addAttribute("app", new Application());

            return "applicationForm";
        } catch (UserNotFoundException e) {
            return "redirect:/application";
        }

    }

    // save the new applied application
    @PostMapping("/user/processApplication")
    public  String processApplication(Application application){
        service.saveApplication(application);
        return "redirect:/user";
    }


    @GetMapping("/user/application")
    public  String showApplicationList(Model model){
        List<Application> applicationList = service.listsApplication();
        model.addAttribute("applicationList", applicationList);
        return "application";
    }

    @GetMapping("/user/application/edit/{id}")
    public  String showEditApplicationFormPage(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Application application = service.getApplicationById(id);
            Integer jobId = application.getJobId();
            String title = application.getTitle();
            String desc = application.getDescription();
            model.addAttribute("jobId", jobId );
            model.addAttribute("title", title);
            model.addAttribute("desc", desc );


            model.addAttribute("app",application);
            model.addAttribute("pageTitle", "Mettre à jour (ID: "+id+")");
            return "applicationForm";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/application";
        }

    }



}
