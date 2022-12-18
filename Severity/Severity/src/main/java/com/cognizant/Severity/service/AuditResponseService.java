package com.cognizant.Severity.service;

import com.cognizant.Severity.model.*;

import java.util.List;

public interface AuditResponseService {

    public AuditResponse getAuditResponse(List<AuditBenchmark> auditBenchmark, String auditType, List<AuditQuestion> auditQuestions);

    public AuditResponse saveAuditResponse(AuditResponse auditResponse, AuditRequest auditRequest);
}
