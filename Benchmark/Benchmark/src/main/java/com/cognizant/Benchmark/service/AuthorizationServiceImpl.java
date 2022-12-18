package com.cognizant.Benchmark.service;

import com.cognizant.Benchmark.feign.AuthFeign;
import com.cognizant.Benchmark.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService{


    @Autowired
    private AuthFeign authFeign;

    @Override
    public boolean validateJwt(String jwt) {

//        authFeign.validate(jwt).getBody().isValid();
//        authFeign.getValidity(token)
        ResponseEntity<AuthResponse> responseEntity = authFeign.validate(jwt);
        return responseEntity.getBody().isValid();
    }

}
