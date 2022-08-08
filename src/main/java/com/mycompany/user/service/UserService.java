package com.mycompany.user.service;

import com.mycompany.UserNotFoundException;
import com.mycompany.model.Application;
import com.mycompany.user.repository.UserRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositoryCrud repo;

    // get all item from db
    public List<Application> listsApplication(){
        return (List<Application>) repo.findAll();
    }

    // the passed parameter(application) will be saved in db
    public void saveApplication(Application application) {
        repo.save(application);
    }





    // get user by id passed from your view
    public Application get(Integer id) throws UserNotFoundException {
        // return an optional
        Optional<Application> result = repo.findById(id);
        //check if user exit or not
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any Application with ID");

    }
}
