package com.trip.tripjava.service;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.repository.ItineraryRepository;
import com.trip.tripjava.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    @Autowired
    ItineraryRepository itineraryRepository;

    @Autowired
    PlannerRepository plannerRepository;

    // 일정 항목 추가
    public ItineraryEntity addItineraryItem(long planner_no, ItineraryEntity itinerary) {
        PlannerEntity planner = plannerRepository.findById(planner_no).orElseThrow(() -> new RuntimeException("Checklist not found"));
        itinerary.setPlanner(planner);
        return itineraryRepository.save(itinerary);
    }

    // 일정 항목 수정
    public ItineraryEntity updateItineraryItem(ItineraryEntity itinerary) {
        return itineraryRepository.save(itinerary);
    }

    // 일정 항목 삭제
    public void deleteItineraryItem(long itineraryId) {
        itineraryRepository.deleteById(itineraryId);
    }

    // 모든 일정 항목 가져오기
    public List<ItineraryEntity> getAllItineraryItems(long planner_no) {
        return itineraryRepository.findByPlanner_Planner_no(planner_no);
    }
}