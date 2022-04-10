package com.teamway.app.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateTimeTableDTO {
    private String desc;
    private String durationPerDay;
    private Boolean isActive;
}
