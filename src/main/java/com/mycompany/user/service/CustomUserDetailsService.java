package com.mycompany.user.service;

import com.mycompany.model.CustomUserDetails;
import com.mycompany.model.User;
import com.mycompany.user.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*
the custom detail services is the class use to implement
loadmethode byuser that is use by string security to perform authentication
* */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryJpa repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        // check if spring security found the email or not
        if(user == null){
            throw new UsernameNotFoundException("user not found");
        }
        // the given user is found with the given email a new CustomUserDetails object
        return new CustomUserDetails(user);
    }


}
