package com.trip.tripjava.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@Table(name = "itinerary")
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itinerary_no", nullable = false)
    private long itinerary_no;

    @ManyToOne
    @JoinColumn(name = "today_no")
    private TodayPlanEntity today_no;

    @Column(name = "start_time", nullable = true)
    private String start_time;

    @Column(name = "end_time", nullable = true)
    private String end_time;

    @Column(name = "memo", nullable = true)
    private String memo;

    @Column(name = "planner_title", nullable = true)
    private String planner_title;

    @Column(name = "price", nullable = true)
    private String price;

}
