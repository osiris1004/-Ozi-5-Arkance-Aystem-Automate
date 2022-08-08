package com.mycompany.job.service;

import com.mycompany.job.repository.JobRepository;
import com.mycompany.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public List<Job> listAllJobs(){
        // cast the return type to list
        return (List<Job>) repo.findAll();
    }
}
