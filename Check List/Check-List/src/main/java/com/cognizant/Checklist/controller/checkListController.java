package com.cognizant.Checklist.controller;

import com.cognizant.Checklist.model.question;
import com.cognizant.Checklist.service.AuthorizationService;
import com.cognizant.Checklist.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class checkListController {

    @Autowired
    public AuthorizationService authorizationService;

    @Autowired
    public QuestionService questionService;



    @GetMapping(value = "/checklist")
    public String welcomeCheck(){
        return "Welcome, This is check list request";
    }

    @GetMapping(value = "/AuditCheckListQuestions/{auditType}")
    public List<question> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @PathVariable String auditType) throws Exception {

        System.out.println(jwt + auditType);
        List<question> qList = new ArrayList<>();
//        System.out.println(StringUtils.isEmpty(jwt));
//        jwt = jwt.substring(7);

        try{
            if( !StringUtils.isEmpty(jwt) &&  authorizationService.validateJwt(jwt)){
                System.out.println(jwt + auditType + " Hello India");
                qList = questionService.getQuestionsByAuditType(auditType);
            }
        }catch (Exception e){
            throw new Exception("The JWT token is not valid");
        }
        return qList;
        //
//        if( qList.isEmpty() ){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(qList, HttpStatus.OK);
    }
//(List<question>) ResponseEntity.ok().body(
//    raise a exception if specified path is not handled by controller


}
