package com.trip.tripjava.service;

import com.trip.tripjava.dto.PlannerDTO;
import com.trip.tripjava.entity.ChecklistEntity;
import com.trip.tripjava.entity.PlannerEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.repository.*;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Builder
@Service
public class PlannerService {
    @Autowired
    PlannerRepository plannerRepository;
    TodayPlanRepository todayPlanRepository;
    ChecklistRepository checklistRepository;
    ItineraryRepository itineraryRepository;

//    Planner 페이지에서 여행 시작일, 종료일 저장
    public void selectDate(PlannerDTO plannerDTO) {
        PlannerEntity plannerEntity = PlannerEntity.builder()
                .planner_startday(plannerDTO.getPlanner_startday())
                .planner_endday(plannerDTO.getPlanner_endday())
                .build();
        plannerRepository.save(plannerEntity);
    }

    public String updateDate(PlannerDTO plannerDTO) {
        PlannerEntity planner = plannerRepository.findById(plannerDTO.getPlanner_no())
            .orElseThrow(()->new NoSuchElementException("저장된 정보가 없습니다."));

        PlannerEntity updatePlanner = PlannerEntity.builder()
            .planner_no(planner.getPlanner_no())
            .planner_startday(plannerDTO.getPlanner_startday())
            .planner_endday(plannerDTO.getPlanner_endday())
            .build();

    plannerRepository.save(updatePlanner);
        return "Update success";

    }

//    저장된 여행 날짜 조회
    public List<Object[]> searchDate(long planner_no) {
        List<Object[]> result = plannerRepository.searchByPlanner_no(planner_no);
        return result;
    }

//    저장된 여행 날짜 삭제
public void deleteDate(long planner_no) {
    PlannerEntity plannerEntity = plannerRepository.findById(planner_no)
            .orElseThrow(()->new NoSuchElementException("삭제되지 않았습니다."));

//     plannerEntity에 연결된 itinerary 레코드들을 모두 삭제
//        List<ItineraryEntity> itineraries = itineraryRepository.findAllByToday_Plan()
//        itineraryRepository.deleteAll(itineraries);

//        // plannerEntity에 연결된 today_plan 레코드들을 모두 조회
//        List<TodayPlanEntity> todayPlans = todayPlanRepository.findByPlannerNo(planner_no);
//
//        // 각 TodayPlanEntity에 연결된 itinerary 레코드들을 모두 삭제
//        for (TodayPlanEntity todayPlan : todayPlans) {
//            List<ItineraryEntity> itineraries = itineraryRepository.findAllByToday(todayPlan);
//            itineraryRepository.deleteAll(itineraries);
//        }

    // plannerEntity에 연결된 today_plan 레코드들을 모두 삭제
    List<TodayPlanEntity> todayPlanEntities = todayPlanRepository.findByPlannerNo(planner_no);
    todayPlanRepository.deleteAll(todayPlanEntities);

    // plannerEntity에 연결된 checklist 레코드들을 모두 삭제
    List<ChecklistEntity> checklists = checklistRepository.findAllByPlanner(plannerEntity);
    checklistRepository.deleteAll(checklists);

    plannerRepository.delete(plannerEntity);
}

    // 플래너 조회 (마이페이지)
    public List<PlannerDTO> getPlanners(String id) {
        List<PlannerEntity> planners = plannerRepository.findByUser_Id(id);
        List<PlannerDTO> plannerDTOS = new ArrayList<>();

        for (PlannerEntity planner : planners) {
            PlannerDTO plannerDTO = PlannerDTO.builder()
                    .planner_no(planner.getPlanner_no())
                    .planner_startday(planner.getPlanner_startday())
                    .planner_endday(planner.getPlanner_endday())
                    .planner_title(planner.getPlanner_title())
                    .build();
            plannerDTOS.add(plannerDTO);
        }

        return plannerDTOS;
    }
}
