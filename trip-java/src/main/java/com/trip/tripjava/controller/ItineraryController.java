package com.trip.tripjava.controller;

import com.trip.tripjava.dto.ItineraryDTO;
import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.service.ItineraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itinerary")
@Slf4j
public class ItineraryController {
    @Autowired
    ItineraryService itineraryService;

    // 일정 항목 조회
    @GetMapping("/select/{planner_no}")
    public List<ItineraryEntity> getAllItineraryItems(@PathVariable("planner_no") long planner_no) {
        return itineraryService.getAllItineraryItems(planner_no);
    }

    // 일정 항목 추가
    @PostMapping("/add")
    public ItineraryEntity createItineraryItem(@RequestBody ItineraryEntity itinerary) {
        return itineraryService.addItineraryItem(itinerary);
    }

    // 일정 항목 수정
    @PutMapping("/{itineraryId}")
    public ItineraryEntity updateItineraryItem(@PathVariable("itineraryId") long itineraryId, @RequestBody ItineraryEntity itinerary) {
        itinerary.setItinerary_no(itineraryId);
        return itineraryService.updateItineraryItem(itinerary);
    }

    // 일정 항목 삭제
    @DeleteMapping("/{itineraryId}")
    public void deleteItineraryItem(@PathVariable("itineraryId") long itineraryId) {
        itineraryService.deleteItineraryItem(itineraryId);
    }

}
