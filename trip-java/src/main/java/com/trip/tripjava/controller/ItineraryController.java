package com.trip.tripjava.controller;

import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItineraryController {
    @Autowired
    ItineraryService itineraryService;

    // 일정 항목 조회
    @GetMapping("/planner/itinerary/select/{planner_no}")
    public List<ItineraryEntity> getAllItineraryItems(@PathVariable("planner_no") long planner_no) {
        return itineraryService.getAllItineraryItems(planner_no);
    }

    // 일정 항목 추가
    @PostMapping("/planner/itinerary/add/{planner_no}")
    public ItineraryEntity createItineraryItem(@PathVariable("planner_no") long planner_no, @RequestBody ItineraryEntity itinerary) {
        return itineraryService.addItineraryItem(planner_no, itinerary);
    }

    // 일정 항목 수정
    @PutMapping("/planner/itinerary/{itineraryId}")
    public ItineraryEntity updateItineraryItem(@PathVariable("itineraryId") long itineraryId, @RequestBody ItineraryEntity itinerary) {
        itinerary.setItinerary_no(itineraryId);
        return itineraryService.updateItineraryItem(itinerary);
    }

    // 일정 항목 삭제
    @DeleteMapping("/planner/itinerary/{itineraryId}")
    public void deleteItineraryItem(@PathVariable("itineraryId") long itineraryId) {
        itineraryService.deleteItineraryItem(itineraryId);
    }
}