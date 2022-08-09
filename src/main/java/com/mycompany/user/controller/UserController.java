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


    /*@GetMapping("/user")
    public  String showUserPage(){
        // direct to the page index
        return "user";
    }*/

    /// Display application form and pass the object to your html
    @GetMapping("/user/applicationForm/new/{id}")
    public  String showApplicationFormPage(Model model,@PathVariable("id") Integer id){
        // direct to the page index

        try {
            Job job = _service.getJobById(id);
            String title = job.getTitle();
            String desc = job.getDescription();
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
    public  String processApplication(Application application/*, @RequestParam(name="cv") MultipartFile multipartFile*/) throws IOException {

        service.saveApplication(application);



    // direct to the page index
        return "redirect:/user";
    }


    /// Display application list
    @GetMapping("/user/application")
    public  String showApplicationList(Model model){

        List<Application> applicationList = service.listsApplication();

        model.addAttribute("applicationList", applicationList);

        return "application";
    }

    @GetMapping("/user/application/edit/{id}")
    public  String showEditApplicationFormPage(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Job job = _service.getJobById(id);
            String title = job.getTitle();
            String desc = job.getDescription();
            model.addAttribute("title", title);
            model.addAttribute("desc", desc );

            Application application = service.getApplicationById(id);
            model.addAttribute("app",application);
            model.addAttribute("pageTitle", "Mettre à jour (ID: "+id+")");
            return "applicationForm";
        } catch (UserNotFoundException e) {
            //<addFlashAttribute>
            ra.addFlashAttribute("message", e.getMessage());
            // redirecting my user to users template
            return "redirect:/application";
        }

    }



}
