package com.trip.tripjava.repository;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Long> {
//    @Query(value = "SELECT * FROM itinerary", nativeQuery = true)
//    List<ItineraryEntity> findAllWithNativeQuery();
//
//    @Modifying
//    @Query(value = "DELETE FROM itinerary WHERE itinerary_no = :id", nativeQuery = true)
//    void deleteItineraryByIdWithNativeQuery(@Param("id") Long id);
//
//    @Query(value = "SELECT * FROM itinerary WHERE today_no = :todayNo", nativeQuery = true)
//    List<ItineraryEntity> findAllByTodayNo(@Param("todayNo") int todayNo);

    @Query("select i from ItineraryEntity i where i.planner.planner_no = :planner_no")
    List<ItineraryEntity> findByPlanner_Planner_no(long planner_no);

    List<ItineraryEntity> findAllByPlanner(PlannerEntity planner);
}
