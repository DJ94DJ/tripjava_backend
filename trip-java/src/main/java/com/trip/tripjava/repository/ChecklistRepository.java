package com.trip.tripjava.repository;

import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.entity.PlannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long> {
    List<ChecklistEntity> findAllByPlanner(PlannerEntity planner);
}
