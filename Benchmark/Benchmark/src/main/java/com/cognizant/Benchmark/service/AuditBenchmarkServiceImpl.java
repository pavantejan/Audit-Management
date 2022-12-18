package com.cognizant.Benchmark.service;

import com.cognizant.Benchmark.model.AuditBenchmark;
import com.cognizant.Benchmark.repository.BenchmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditBenchmarkServiceImpl implements AuditBenchmarkService{

    @Autowired
    private BenchmarkRepository benchmarkRepository;
    @Override
    public List<AuditBenchmark> getAuditBenchmarkList() {

        return benchmarkRepository.findAll();
    }
}
