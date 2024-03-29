package com.trip.tripjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PlannerDTO {
    private long planner_no;
    private String planner_startday;
    private String planner_endday;
    private String planner_title;
    private TouristDTO tourist;
}
