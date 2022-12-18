package com.cognizant.Benchmark.repository;

import com.cognizant.Benchmark.model.AuditBenchmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchmarkRepository extends JpaRepository<AuditBenchmark,Integer> {

}
