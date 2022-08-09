package com.mycompany.job.controller;

import com.mycompany.job.repository.JobRepository;
import com.mycompany.job.service.JobService;
import com.mycompany.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("/user")
    // in this handler methode we need to access the spring MVC model object
    public String showJobList(Model model){
        // execute our business logic
        List<Job> allJobs = service.listAllJobs();
        // we put the <listUser> in to the model attribute, so that we can have access in the view
        model.addAttribute("allJobs", allJobs);
        // name of your html template
        return "user";
    }


}
