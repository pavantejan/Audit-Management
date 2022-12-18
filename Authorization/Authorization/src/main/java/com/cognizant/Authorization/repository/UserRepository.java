package com.cognizant.Authorization.repository;

import com.cognizant.Authorization.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user,Integer> {

//    @Query(value = "select u from users u where u.username= ?1")
//    public user findByUserName(String username);


}
