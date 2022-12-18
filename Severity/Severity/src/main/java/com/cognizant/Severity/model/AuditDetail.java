package com.cognizant.Severity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetail {
    private String auditType;
    private Date AuditDate;
    private List<AuditQuestion> auditQuestions;
}
