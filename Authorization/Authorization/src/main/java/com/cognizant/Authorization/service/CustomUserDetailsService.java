package com.cognizant.Authorization.service;

import com.cognizant.Authorization.model.user;
import com.cognizant.Authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        user uDetails =userRepository.findByUserName(username);
        List<user> users = userRepository.findAll();
//        System.out.println(username+" xyz");
//        System.out.println(users);
        user uDetails = users.stream().filter(player -> player.getUsername().contains(username))
                .findFirst().orElse(null);

//        If uDetails is null raise a exception that user not found

//        return uDetails;
        return new org.springframework.security.core.userdetails.User(uDetails.getUsername(),uDetails.getPassword(), new ArrayList<>());
    }

    public user loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
//        user uDetails =userRepository.findByUserName(username);
        List<user> users = userRepository.findAll();
//        System.out.println(username+" xyz");
//        System.out.println(users);
        user uDetails = users.stream().filter(player -> player.getUsername().contains(username))
                .findFirst().orElse(null);

//        If uDetails is null raise a exception that user not found

//        return uDetails;
//        return new org.springframework.security.core.userdetails.User(uDetails.getUsername(),uDetails.getPassword(), new ArrayList<>());
        return uDetails;
    }
}
