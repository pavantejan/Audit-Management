package com.cognizant.Benchmark.feign;


import com.cognizant.Benchmark.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Benchmark-MS",url="http://localhost:8080")
public interface AuthFeign {
    @PostMapping(value = "/validate")
    public ResponseEntity<AuthResponse> validate(@RequestHeader("Authorization") String jwt);
}
