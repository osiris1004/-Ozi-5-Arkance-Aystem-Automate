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

    public List<Application> listAll(){
        return (List<Application>) repo.findAll();
    }
    public void save(Application application) {
        repo.save(application);
    }
}
