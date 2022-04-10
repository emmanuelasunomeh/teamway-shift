package com.teamway.app.service;

import com.teamway.app.DTOs.CreateTimeTableDTO;
import com.teamway.app.models.TimeTable;

public interface TimeTableService {

    TimeTable createTimeTable(CreateTimeTableDTO timeTableDTO);

}
