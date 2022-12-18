package com.cognizant.Checklist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int question_id;

    @Column(name = "question")
    private String questions;

    @Column(name = "audit_type")
    private String audit_type;

    @Column(name = "response")
    private String response;
}
