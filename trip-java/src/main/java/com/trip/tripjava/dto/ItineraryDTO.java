package com.trip.tripjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryDTO {
    private long itinerary_no;
    private long planner_no;
    private String start_time;
    private String end_time;
    private String memo;
    private String planner_title;
    private String price;
}
