package com.cognizant.Severity.service;

import com.cognizant.Severity.model.AuditRequest;
import com.cognizant.Severity.model.AuditResponse;

public interface AuditRequestResponseService {

    public AuditResponse getAuditRequestResponse(AuditRequest auditRequest,String jwt);
}
