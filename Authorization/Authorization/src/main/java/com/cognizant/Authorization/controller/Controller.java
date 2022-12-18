package com.cognizant.Authorization.controller;

import com.cognizant.Authorization.model.AuthRequest;
import com.cognizant.Authorization.model.AuthResponse;
import com.cognizant.Authorization.model.user;
import com.cognizant.Authorization.service.CustomUserDetailsService;
import com.cognizant.Authorization.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtService jwtService;


    @GetMapping(value = "/authorization")
    public String welcomeCheck(){
        return "Welcome, This is Authorization request";
    }

    @PostMapping(value = "/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("In authenticate post mapping");
        try{
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        }
        catch (Exception e){
//            System.out.println(authRequest.getUsername()+"xyz");
            throw new Exception("Invalid username/password");
        }
//        System.out.println(authRequest.getPassword());
    return jwtService.generateToken(authRequest.getUsername());
    }


    @PostMapping(value = "/validate")
    public AuthResponse validate(@RequestHeader("Authorization") String jwt) throws Exception {
        System.out.println("In validate");
        AuthResponse authenticationResponse = new AuthResponse("Invalid", "Invalid", false);
        jwt = jwt.substring(7);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtService.extractUsername(jwt));
        user User = customUserDetailsService.loadUserDetailsByUsername(jwtService.extractUsername(jwt));

        try{
            if( jwtService.validateToken(jwt,userDetails) ){
                authenticationResponse.setName(User.getName());
                authenticationResponse.setProjectName(User.getProjectName());
                authenticationResponse.setValid(true);
            }
        }catch (Exception e){
            throw new Exception("Exception Occured by validating JWT"+e.getMessage());
        }
        return authenticationResponse;
    }

}
