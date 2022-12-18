package com.cognizant.Checklist.service;

import com.cognizant.Checklist.model.question;
import com.cognizant.Checklist.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<question> getQuestionsByAuditType(String auditType){

        List<question> qlist = questionRepository.getQuestionsByAuditType(auditType);
        System.out.println("getquestionsBy audit type funcrtion");
        return qlist;
    }
}
