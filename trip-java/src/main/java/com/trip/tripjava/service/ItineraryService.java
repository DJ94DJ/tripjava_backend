package com.trip.tripjava.service;

import com.trip.tripjava.dto.ItineraryDTO;
import com.trip.tripjava.entity.ItineraryEntity;
import com.trip.tripjava.entity.TodayPlanEntity;
import com.trip.tripjava.repository.ItineraryRepository;
import com.trip.tripjava.repository.TodayPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    @Autowired
    private TodayPlanRepository todayPlanRepository;

    @Autowired
    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public ItineraryEntity saveItinerary(ItineraryEntity itinerary) {
        return itineraryRepository.save(itinerary);
    }

    // 전체 itinerary 불러오기
    public List<ItineraryEntity> getAllItinerariesWithNativeQuery() {
        return itineraryRepository.findAllWithNativeQuery();
    }

    public ItineraryEntity getItineraryById(Long id) {
        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
        if (optionalItinerary.isPresent()) {
            return optionalItinerary.get();
        } else {
            throw new RuntimeException("Itinerary not found for id :: " + id);
        }
    }


//    public void deleteItineraryById(Long id) {
//        Optional<ItineraryEntity> optionalItinerary = itineraryRepository.findById(id);
//        if (optionalItinerary.isPresent()) {
//            ItineraryEntity itinerary = optionalItinerary.get();
//
//            // itinerary에 연결된 today_plan 레코드를 모두 삭제
//            TodayPlanEntity todayPlan = itinerary.getToday_no();
//            if (todayPlan != null) {
//                todayPlanRepository.delete(todayPlan);
//            }
//
//            // itinerary 레코드 삭제
//            itineraryRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("Itinerary not found for id :: " + id);
//        }
//    }

    @Transactional
    public void deleteItineraryById(Long id) {
        itineraryRepository.deleteItineraryByIdWithNativeQuery(id);
    }

}
