package com.cognizant.Severity.controller;

import com.cognizant.Severity.model.AuditRequest;
import com.cognizant.Severity.model.AuditResponse;
import com.cognizant.Severity.service.AuditRequestResponseService;
import com.cognizant.Severity.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class SeverityController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuditRequestResponseService auditRequestResponseService;

    @GetMapping(value = "/severity")
    public String welcomeCheck(){
        return "Welcome, This is severity request";
    }

    @PostMapping(value = "/ProjectExecutionStatus")
    public AuditResponse getProjectExecutionStatus(@RequestHeader("Authorization") String jwt,@RequestBody AuditRequest auditRequest) throws Exception {

        System.out.println("Heloooo");
        AuditResponse auditResponse = new AuditResponse();
        System.out.println(auditRequest);
        try{
            if( !StringUtils.isEmpty(jwt) &&  authorizationService.validateJwt(jwt)){
                System.out.println("in controller");
                auditResponse = auditRequestResponseService.getAuditRequestResponse(auditRequest,jwt);
                System.out.println("in controller 1");
            }
        }catch (Exception e){
            throw new Exception("The JWT token is not valid");
        }

        return auditResponse;
    }
}
