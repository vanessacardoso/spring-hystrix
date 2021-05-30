package com.microservice.springcloud.repository;

import com.microservice.springcloud.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
