package com.teamway.app.DTOs;

import com.teamway.app.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateWorkerDTO {

    private String firstName;
    private String LastName;
    private Gender gender;


}
