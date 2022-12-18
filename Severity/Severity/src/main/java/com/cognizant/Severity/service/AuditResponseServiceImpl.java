package com.cognizant.Severity.service;

import com.cognizant.Severity.model.AuditBenchmark;
import com.cognizant.Severity.model.AuditQuestion;
import com.cognizant.Severity.model.AuditRequest;
import com.cognizant.Severity.model.AuditResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuditResponseServiceImpl implements AuditResponseService{

//    Acceptable no - Benchmark no's for a audit type
//    actual no - questions response no's for a audit type
    public AuditResponse createAuditResponse(int acceptableNo,int actualNo,String auditType){

        AuditResponse auditResponse = new AuditResponse();



        if(auditType.equalsIgnoreCase("Internal") && actualNo <= acceptableNo){
            auditResponse.setProjectExecutionStatus("GREEN");
            auditResponse.setRemedialActionDuration("No action needed");
        } else if (auditType.equalsIgnoreCase("Internal") && actualNo > acceptableNo) {
            auditResponse.setProjectExecutionStatus("RED");
            auditResponse.setRemedialActionDuration("Action to be taken in 2 weeks");
        } else if (auditType.equalsIgnoreCase("SOX") && actualNo <= acceptableNo) {
            auditResponse.setProjectExecutionStatus("GREEN");
            auditResponse.setRemedialActionDuration("No action needed");
        }else {
            auditResponse.setProjectExecutionStatus("RED");
            auditResponse.setRemedialActionDuration("Action to be taken in 1 week");
        }
//        System.out.println(auditResponse.getAuditId());

        return auditResponse;
    }

    public int countNo(List<AuditQuestion> auditQuestions){
        int count=0;
        for(AuditQuestion aq: auditQuestions){
            if ( aq.getResponse().equals("NO") ){
                count+=1;
            }
        }
        return count;
    }

    @Override
    public AuditResponse getAuditResponse(List<AuditBenchmark> auditBenchmark, String auditType, List<AuditQuestion> auditQuestions) {

        int acceptableNo=0;
        for(AuditBenchmark ab : auditBenchmark){
            if (ab.getAudit_type().equals(auditType) ){
                acceptableNo = ab.getBenchmark_no_answers();
            }
        }

        return createAuditResponse(acceptableNo,countNo(auditQuestions),auditType);
    }

    @Override
    public AuditResponse saveAuditResponse(AuditResponse auditResponse, AuditRequest auditRequest) {
        int id = (int)(Math.random() * (50 - 1 + 1) + 1);
        auditResponse.setAuditId(id);
        auditResponse.setProjectName(auditRequest.getProjectName());
        auditResponse.setProjectManagerName(auditRequest.getProjectManagerName());
        auditResponse.setCreationDateTime(new Date());

        return auditResponse;
    }
}
