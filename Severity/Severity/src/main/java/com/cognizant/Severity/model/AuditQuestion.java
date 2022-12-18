package com.cognizant.Severity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditQuestion {

    private int question_id;
    private String questions;
    private String audit_type;
    private String response;
}
