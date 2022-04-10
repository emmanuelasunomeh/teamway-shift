package com.teamway.app.repository;

import com.teamway.app.models.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Long> {

    @Query("SELECT s " +
            " FROM Shifts s WHERE s.worker.id=?1 and s.startTime=CURRENT_DATE")
    List<Shifts> findByWorkerIdAndStartTimeEqualsToday(@NonNull Long id);


}
