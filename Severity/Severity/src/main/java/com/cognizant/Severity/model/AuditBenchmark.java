package com.cognizant.Severity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditBenchmark {
    private int benchmark_id;
    private String audit_type;
    private int benchmark_no_answers;
}
