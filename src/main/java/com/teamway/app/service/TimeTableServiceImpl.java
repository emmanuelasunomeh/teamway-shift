package com.teamway.app.service;

import com.teamway.app.DTOs.CreateTimeTableDTO;
import com.teamway.app.DTOs.CreateWorkerDTO;
import com.teamway.app.models.TimeTable;
import com.teamway.app.models.Worker;
import com.teamway.app.repository.TimeTableRepository;
import com.teamway.app.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepository timeTableRepository;

    @Autowired
    public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTable createTimeTable(CreateTimeTableDTO timeTableDTO) {
        TimeTable timeTable = TimeTable.builder()
                .desc(timeTableDTO.getDesc())
                .durationPerDay(timeTableDTO.getDurationPerDay())
                .isActive(timeTableDTO.getIsActive())
                .build();

        return timeTableRepository.save(timeTable);
    }
}
