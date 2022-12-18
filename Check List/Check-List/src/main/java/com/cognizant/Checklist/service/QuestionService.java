package com.cognizant.Checklist.service;

import com.cognizant.Checklist.model.question;

import java.util.List;

public interface QuestionService {
    public List<question> getQuestionsByAuditType(String auditType);
}
