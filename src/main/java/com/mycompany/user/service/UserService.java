package com.mycompany.user.service;

import com.mycompany.model.Application;
import com.mycompany.user.UserRepository;
import com.mycompany.user.UserRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
