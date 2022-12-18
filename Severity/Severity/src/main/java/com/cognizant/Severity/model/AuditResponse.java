package com.cognizant.Severity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit_response")
public class AuditResponse {

    @Id
    @GeneratedValue
    private int auditId;
    private String projectName;
    private String projectManagerName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateAndTime;
    private String projectExecutionStatus;
    private String remedialActionDuration;

    public void setCreationDateTime(Date dateAndTime){
        this.creationDateAndTime=dateAndTime;
    }

}
