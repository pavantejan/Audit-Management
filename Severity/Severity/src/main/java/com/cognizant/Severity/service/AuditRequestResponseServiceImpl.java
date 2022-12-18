package com.cognizant.Severity.service;

import com.cognizant.Severity.feign.BenchmarkFeign;
import com.cognizant.Severity.model.AuditBenchmark;
import com.cognizant.Severity.model.AuditQuestion;
import com.cognizant.Severity.model.AuditRequest;
import com.cognizant.Severity.model.AuditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditRequestResponseServiceImpl implements AuditRequestResponseService{

    @Autowired
    private AuditResponseService auditResponseService;

    @Autowired
    private BenchmarkFeign benchmarkFeign;

    @Override
    public AuditResponse getAuditRequestResponse(AuditRequest auditRequest, String jwt) {

        String auditType;


        System.out.println(jwt);
        List<AuditBenchmark> auditBenchmarkList = benchmarkFeign.getAuditBenchmark(jwt);
        System.out.println("in audit request response 1");
        auditType = auditRequest.getAuditDetail().getAuditType();
        System.out.println("in audit request response 2");
        List<AuditQuestion> auditQuestionList = auditRequest.getAuditDetail().getAuditQuestions();
        System.out.println("in audit request response 3");

        AuditResponse auditResponse = auditResponseService.getAuditResponse(auditBenchmarkList,auditType,auditQuestionList);

        return auditResponseService.saveAuditResponse(auditResponse,auditRequest);
    }
}
