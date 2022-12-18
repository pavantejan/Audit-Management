package com.cognizant.Severity.repository;

import com.cognizant.Severity.model.AuditResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeverityRepository extends JpaRepository<AuditResponse, Integer> {
}
