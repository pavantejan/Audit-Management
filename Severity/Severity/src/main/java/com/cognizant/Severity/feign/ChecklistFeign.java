package com.cognizant.Severity.feign;

import com.cognizant.Severity.model.AuditQuestion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "Checklist-MS",url = "http://localhost:8081")
public interface ChecklistFeign {

    @GetMapping(value = "/AuditCheckListQuestions/{auditType}")
    public List<AuditQuestion> auditCheckListQuestions(@RequestHeader("Authorization") String jwt, @PathVariable String auditType);
}
