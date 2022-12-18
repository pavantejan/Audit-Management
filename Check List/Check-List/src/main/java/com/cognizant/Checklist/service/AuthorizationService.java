package com.cognizant.Checklist.service;

public interface AuthorizationService {

    public boolean validateJwt(String jwt);
}
