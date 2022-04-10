package com.teamway.app.service;

import com.teamway.app.DTOs.CreateWorkerDTO;
import com.teamway.app.models.Worker;

public interface WorkerService {

    Worker createWorker(CreateWorkerDTO workerDTO);



}
