package com.teamway.app.controller;

import com.teamway.app.DTOs.CreateTimeTableDTO;
import com.teamway.app.DTOs.CreateWorkerDTO;
import com.teamway.app.aop.annotation.LogExecutionTime;
import com.teamway.app.models.TimeTable;
import com.teamway.app.models.Worker;
import com.teamway.app.service.TimeTableService;
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
@RequestMapping("time-table")
public class TimeTableController {

    private final TimeTableService timeTableService;

    @Autowired
    public TimeTableController(TimeTableService timeTableService) {
        this.timeTableService = timeTableService;
    }

    @LogExecutionTime
    @PostMapping()
    public ResponseEntity<?> createShift(@RequestBody CreateTimeTableDTO timeTableDTO){
        TimeTable timeTable = timeTableService.createTimeTable(timeTableDTO);
        return new ResponseEntity<>(new JsonResponse("See details in data",timeTable), HttpStatus.CREATED);
    }
}
