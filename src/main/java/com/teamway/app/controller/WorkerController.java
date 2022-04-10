package com.teamway.app.controller;

import com.teamway.app.DTOs.CreateWorkerDTO;
import com.teamway.app.aop.annotation.LogExecutionTime;
import com.teamway.app.models.Worker;
import com.teamway.app.service.WorkerService;
import com.teamway.app.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @LogExecutionTime
    @PostMapping()
    public ResponseEntity<?> createShift(@RequestBody CreateWorkerDTO workerDTO){
        Worker worker = workerService.createWorker(workerDTO);
        return new ResponseEntity<>(new JsonResponse("See details in data",worker), HttpStatus.CREATED);
    }
}
