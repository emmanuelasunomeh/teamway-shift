package com.teamway.app.service;

import com.teamway.app.DTOs.CreateShiftsDTO;
import com.teamway.app.models.Shifts;

public interface ShiftsService {

    Shifts createShifts(CreateShiftsDTO shiftsDTO);
}
