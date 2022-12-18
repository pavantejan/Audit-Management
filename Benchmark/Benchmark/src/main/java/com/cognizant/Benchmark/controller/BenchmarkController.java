package com.cognizant.Benchmark.controller;

import com.cognizant.Benchmark.model.AuditBenchmark;
import com.cognizant.Benchmark.service.AuditBenchmarkService;
import com.cognizant.Benchmark.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BenchmarkController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuditBenchmarkService auditBenchmarkService;


    @GetMapping(value = "/benchmark")
    public String welcomeCheck(){
        return "Welcome, This Benchmark request";
    }

    @GetMapping(value = "/AuditBenchmark")
    public List<AuditBenchmark> getAuditBenchmark(@RequestHeader("Authorization") String jwt) throws Exception {

        List<AuditBenchmark> qList = new ArrayList<>();

//        jwt=jwt.substring(7);

        try{
            if( !StringUtils.isEmpty(jwt) &&  authorizationService.validateJwt(jwt)){
//                logic ??
                qList = auditBenchmarkService.getAuditBenchmarkList();

//                qList = questionService.getQuestionsByAuditType(auditType);
            }
        }catch (Exception e){
            throw new Exception("The JWT token is not valid");
        }


        return qList;
    }
}
