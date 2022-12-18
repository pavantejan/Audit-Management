package com.cognizant.Checklist.feign;

import com.cognizant.Checklist.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Authorization-Ms", url = "http://localhost:8080")
public interface AuthFeign {
    @PostMapping(value = "/validate")
    public ResponseEntity<AuthResponse> validate(@RequestHeader("Authorization") String jwt);
}
