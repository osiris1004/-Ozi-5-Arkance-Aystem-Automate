package com.mycompany.user.repository;

import com.mycompany.model.Application;
import com.mycompany.model.Job;
import com.mycompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepositoryCrud extends CrudRepository<Application, Integer> {



}
