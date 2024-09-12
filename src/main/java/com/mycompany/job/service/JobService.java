package com.mycompany.job.service;

import com.mycompany.UserNotFoundException;
import com.mycompany.job.repository.JobRepository;
import com.mycompany.model.Application;
import com.mycompany.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public List<Job> listAllJobs(){
        // cast the return type to list
        return (List<Job>) repo.findAll();
    }

    // get user by id passed from your view
    public Job getJobById(Integer id) throws UserNotFoundException {
        // return an optional
        Optional<Job> result = repo.findById(id);
        //check if user exit or not
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any Application with ID");

    }


}
