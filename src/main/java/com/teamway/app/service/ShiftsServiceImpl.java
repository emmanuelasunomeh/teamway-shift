package com.teamway.app.service;

import com.teamway.app.DTOs.CreateShiftsDTO;
import com.teamway.app.exceptions.CheckSameDayShiftException;
import com.teamway.app.exceptions.TimeTableNotFoundException;
import com.teamway.app.exceptions.WorkerNotFoundException;
import com.teamway.app.models.Shifts;
import com.teamway.app.models.TimeTable;
import com.teamway.app.models.Worker;
import com.teamway.app.repository.ShiftsRepository;
import com.teamway.app.repository.TimeTableRepository;
import com.teamway.app.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftsServiceImpl implements ShiftsService{
    private final ShiftsRepository shiftsRepository;
    private final WorkerRepository workerRepository;
    private final TimeTableRepository timeTableRepository;

    @Autowired
    public ShiftsServiceImpl(ShiftsRepository shiftsRepository,
                             WorkerRepository workerRepository,
                             TimeTableRepository timeTableRepository) {
        this.shiftsRepository = shiftsRepository;
        this.workerRepository = workerRepository;
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public Shifts createShifts(CreateShiftsDTO shiftsDTO) {
        return this.saveShifts(shiftsDTO);
    }

    //METHODS
    private Shifts saveShifts(CreateShiftsDTO shiftsDTO) {
        Worker worker = workerRepository.findById(shiftsDTO.getWorkerId())
                .orElseThrow(() -> new WorkerNotFoundException("UNABLE TO IDENTIFY THIS WORKER'S ID : "+ shiftsDTO.getWorkerId()));
        TimeTable timeTable = timeTableRepository.findById(shiftsDTO.getTimeTableId())
                .orElseThrow(() -> new TimeTableNotFoundException("NO TIME TABLE FOUND WITH ID: "+ shiftsDTO.getTimeTableId()));
        List<Shifts> shiftsDTOList =  shiftsRepository.findByWorkerIdAndStartTimeEqualsToday(shiftsDTO.getWorkerId());

        if(shiftsDTOList.size()>0){
            throw new CheckSameDayShiftException("YOU HAVE WORKED FOR TODAY, PLS TRY TOMORROW!!");
        }
        Shifts shifts = Shifts.builder()
                .startTime(shiftsDTO.getStartTime())
                .isActive(Boolean.TRUE)
                .worker(worker)
                .timeTable(timeTable)
                .build();
        return shiftsRepository.save(shifts);
    }
}
