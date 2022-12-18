package com.cognizant.Severity.feign;

import com.cognizant.Severity.model.AuditBenchmark;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "Benchmark-MS",url = "http://localhost:8082")
public interface BenchmarkFeign {

    @GetMapping(value = "/AuditBenchmark")
    public List<AuditBenchmark> getAuditBenchmark(@RequestHeader("Authorization") String jwt);
}
