package com.teamway.app.controller;

import com.teamway.app.DTOs.CreateShiftsDTO;
import com.teamway.app.aop.annotation.LogExecutionTime;
import com.teamway.app.models.Shifts;
import com.teamway.app.service.ShiftsService;
import com.teamway.app.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shifts")
public class ShiftsController {

    private final ShiftsService shiftsService;

    @Autowired
    public ShiftsController(ShiftsService shiftsService) {
        this.shiftsService = shiftsService;
    }


    @LogExecutionTime
    @PostMapping()
    public ResponseEntity<?> createShift(@RequestBody CreateShiftsDTO shiftsDTO){
        Shifts shifts = shiftsService.createShifts(shiftsDTO);
        return new ResponseEntity<>(new JsonResponse("See details in data",shifts), HttpStatus.CREATED);
    }
}
