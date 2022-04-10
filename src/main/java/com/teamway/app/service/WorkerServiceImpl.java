package com.teamway.app.service;

import com.teamway.app.DTOs.CreateWorkerDTO;
import com.teamway.app.models.Worker;
import com.teamway.app.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(CreateWorkerDTO workerDTO) {
        Worker worker = new Worker();
        worker.setFirstName(workerDTO.getFirstName());
        worker.setLastName(workerDTO.getLastName());
        worker.setGender(workerDTO.getGender());
        return workerRepository.save(worker);
    }
}
