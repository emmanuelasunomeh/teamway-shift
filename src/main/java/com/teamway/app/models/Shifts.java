package com.teamway.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Shifts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="IS_ACTIVE")
    private Boolean isActive;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name="START_TIME")
    @Temporal(TemporalType.DATE)
    private Calendar startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name="END_TIME")
    @Temporal(TemporalType.DATE)
    private Calendar endTime;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "WORKER_ID", nullable = false)
    private Worker worker;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIME_TABLE_ID")
    private TimeTable timeTable;

}
