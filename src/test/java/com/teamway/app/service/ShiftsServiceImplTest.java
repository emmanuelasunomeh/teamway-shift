package com.teamway.app.service;

import com.teamway.app.DTOs.CreateShiftsDTO;
import com.teamway.app.enums.Gender;
import com.teamway.app.models.Shifts;
import com.teamway.app.models.TimeTable;
import com.teamway.app.models.Worker;
import com.teamway.app.repository.ShiftsRepository;
import com.teamway.app.repository.TimeTableRepository;
import com.teamway.app.repository.WorkerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShiftsServiceImplTest {

    @Mock
    private ShiftsRepository mockShiftsRepository;
    @Mock
    private WorkerRepository mockWorkerRepository;
    @Mock
    private TimeTableRepository mockTimeTableRepository;

    private ShiftsServiceImpl shiftsServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        shiftsServiceImplUnderTest = new ShiftsServiceImpl(mockShiftsRepository, mockWorkerRepository,
                mockTimeTableRepository);
    }

    @Test
    void testCreateShifts() {

        // Setup
        final Calendar instance = Calendar.getInstance(Locale.US);
        final CreateShiftsDTO shiftsDTO = new CreateShiftsDTO(1L, 1L, instance);
        final Shifts expectedResult = new Shifts(null, true, instance,
                null, new Worker(1L, "firstName", "LastName", Gender.MALE),
                new TimeTable(1L, "desc", "durationPerDay", false));

        // Configure WorkerRepository.findById(...).
        final Optional<Worker> worker = Optional.of(
                new Worker(1L, "firstName", "LastName", Gender.MALE));
        when(mockWorkerRepository.findById(1L)).thenReturn(worker);

        // Configure TimeTableRepository.findById(...).
        final Optional<TimeTable> timeTable = Optional.of(new TimeTable(1l, "desc", "durationPerDay", true));
        when(mockTimeTableRepository.findById(1l)).thenReturn(timeTable);

        final List<Shifts> shifts = new ArrayList<>();
        when(mockShiftsRepository.findByWorkerIdAndStartTimeEqualsToday(1l)).thenReturn(shifts);

        // Configure ShiftsRepository.save(...).
        final Shifts shifts1 = new Shifts(null, true, instance, null,
                new Worker(1l, "firstName", "LastName", Gender.MALE),
                new TimeTable(1l, "desc", "durationPerDay", false));
        when(mockShiftsRepository.save(new Shifts(null, true, instance, null, new Worker(1l, "firstName", "LastName", Gender.MALE),
                new TimeTable(1l, "desc", "durationPerDay", true)))).thenReturn(shifts1);

        // Run the test
        final Shifts result = shiftsServiceImplUnderTest.createShifts(shiftsDTO);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
