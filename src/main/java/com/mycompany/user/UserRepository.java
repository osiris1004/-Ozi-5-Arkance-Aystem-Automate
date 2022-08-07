package com.mycompany.user;

import com.mycompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/// UserRepository is the repository that exten the CrudRepository APIs
public interface UserRepository extends JpaRepository<User, Long> {
    // repository are interface which has implementation that come out of the box with JPA
    //all you need to do is provide the definition of your methode and then jpa provide the implementation automatically

    //// you say hey jpa i need a methode which find by user name
    //Optional<User> findByUserName(String userName);

    //custom query for findByEmail() method
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);


}
