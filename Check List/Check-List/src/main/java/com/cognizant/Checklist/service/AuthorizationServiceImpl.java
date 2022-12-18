package com.cognizant.Checklist.service;

import com.cognizant.Checklist.feign.AuthFeign;
import com.cognizant.Checklist.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthFeign authFeign;

    @Override
    public boolean validateJwt(String jwt) {

        ResponseEntity<AuthResponse> responseEntity = authFeign.validate(jwt);
        return responseEntity.getBody().isValid();
    }


}
