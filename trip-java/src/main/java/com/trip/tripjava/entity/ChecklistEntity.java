package com.trip.tripjava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="checklist")
public class ChecklistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_no", nullable = false)
    private long checklist_no;

    @ManyToOne
    @JoinColumn(name = "planner_no", referencedColumnName = "planner_no")
    private PlannerEntity planner;

    @Column(name = "ingredient", nullable = false, length = 50)
    private String ingredient;

    @Column(name = "ingredient_check", nullable = false)
    private boolean ingredient_check;

}
