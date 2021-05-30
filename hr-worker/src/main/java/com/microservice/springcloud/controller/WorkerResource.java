package com.microservice.springcloud.controller;

import com.microservice.springcloud.entity.Worker;
import com.microservice.springcloud.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private WorkerRepository repository;
    @Autowired
    private Environment env; //tem várias informações de contexto da aplicação

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT = "+ env.getProperty("local.server.port"));
        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
