package com.cognizant.Checklist.repository;


import com.cognizant.Checklist.model.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<question, Integer> {

    @Query(value = "select q from question q where q.audit_type=?1")
    List<question> getQuestionsByAuditType(String auditType);
}
