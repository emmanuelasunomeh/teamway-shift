package com.teamway.app.DTOs;

import lombok.*;

import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateShiftsDTO {

    private Long workerId;
    private Long timeTableId;
    private Calendar startTime;
}
