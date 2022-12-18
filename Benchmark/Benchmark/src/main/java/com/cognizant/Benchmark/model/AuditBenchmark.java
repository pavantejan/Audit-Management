package com.cognizant.Benchmark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="audit_benchmark")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditBenchmark {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int benchmark_id;
    private String audit_type;
    private int benchmark_no_answers;
}
