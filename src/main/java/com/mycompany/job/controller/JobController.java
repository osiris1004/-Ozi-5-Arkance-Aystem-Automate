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
    public String showJobList(Model model){
        List<Job> allJobs = service.listAllJobs();
        model.addAttribute("allJobs", allJobs);
        return "user";
    }


}
