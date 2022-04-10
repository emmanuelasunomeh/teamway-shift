package com.teamway.app;

import com.teamway.app.DTOs.CreateShiftsDTO;
import com.teamway.app.enums.Gender;
import com.teamway.app.models.Shifts;
import com.teamway.app.models.TimeTable;
import com.teamway.app.models.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class WorkPlanningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkPlanningServiceApplication.class, args);
	}



}
