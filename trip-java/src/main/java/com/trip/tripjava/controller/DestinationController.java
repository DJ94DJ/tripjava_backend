package com.trip.tripjava.controller;

import com.trip.tripjava.dto.TouristDTO;
import com.trip.tripjava.entity.TouristEntity;
import com.trip.tripjava.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private TouristRepository touristRepository;

    // 위경도 받아서 근처 숙소 검색하기
    @GetMapping("/accommodation")
    public ResponseEntity<Map<String, List<TouristDTO>>> getAccommodationInfoByCoordinates(@RequestParam String mapx, @RequestParam String mapy) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 위경도를 기준으로 주변 숙소 검색
            List<TouristEntity> accommodationEntities = touristRepository.findAccommodationsNearby(mapx, mapy);

            // 엔티티를 DTO로 변환
            List<TouristDTO> accommodations = convertToDTO(accommodationEntities);
            response.put("accommodations", accommodations);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 숙소 주변의 식당과 관광지 가져오기
    @GetMapping("/nearby")
    public ResponseEntity<Map<String, List<TouristDTO>>> getNearbyInfo(@RequestParam String mapx, @RequestParam String mapy) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 숙소 주변의 식당 가져오기
            List<TouristEntity> restaurantEntities = touristRepository.findRestaurantsNearby(mapx, mapy);
            List<TouristDTO> restaurants = convertToDTO(restaurantEntities);
            response.put("restaurants", restaurants);

            // 숙소 주변의 관광지 가져오기
            List<TouristEntity> touristEntities = touristRepository.findTouristSpotsNearby(mapx, mapy);
            List<TouristDTO> touristSpots = convertToDTO(touristEntities);
            response.put("touristSpots", touristSpots);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    // 주소 근처 식당, 관광지, 숙소 가져오기
    @GetMapping("")
    public ResponseEntity<Map<String, List<TouristDTO>>> getDestinationInfoByAddress(@RequestParam String addr1) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 관광지 엔티티 가져오기
            List<TouristEntity> touristEntities = touristRepository.findByAddr1Contains(addr1);

            // 엔티티를 DTO로 변환
            List<TouristDTO> touristSpots = convertToDTO(touristEntities);
            response.put("touristSpots", touristSpots);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    // 삭제 예정
    @GetMapping("/{areacode}/{sigungucode}")
    public ResponseEntity<Map<String, List<TouristDTO>>> getDestinationInfo(@PathVariable String areacode, @PathVariable String sigungucode) {
        Map<String, List<TouristDTO>> response = new HashMap<>();

        try {
            // 관광지 엔티티 가져오기
            List<TouristEntity> touristEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "12");

            // 엔티티를 DTO로 변환
            List<TouristDTO> touristSpots = convertToDTO(touristEntities);
            response.put("touristSpots", touristSpots);

            // 음식점 엔티티 가져오기
            List<TouristEntity> restaurantEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "39");

            // 엔티티를 DTO로 변환
            List<TouristDTO> restaurants = convertToDTO(restaurantEntities);
            response.put("restaurants", restaurants);

            // 숙소 엔티티 가져오기
            List<TouristEntity> accommodationEntities = touristRepository.findByAreacodeAndSigungucodeAndContenttypeid(areacode, sigungucode, "32");

            // 엔티티를 DTO로 변환
            List<TouristDTO> accommodations = convertToDTO(accommodationEntities);
            response.put("accommodations", accommodations);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    // entity를 dto로 변형하기 위한 메소드
    private List<TouristDTO> convertToDTO(List<TouristEntity> entities) {
        List<TouristDTO> dtos = new ArrayList<>();
        for (TouristEntity entity : entities) {
            TouristDTO dto = new TouristDTO();
            dto.setContentid(entity.getContentid());
            dto.setContenttypeid(entity.getContenttypeid());
            dto.setTitle(entity.getTitle());
            dto.setAddr1(entity.getAddr1());
            dto.setAreacode(entity.getAreacode());
            dto.setSigungucode(entity.getSigungucode());
            dto.setFirstimage(entity.getFirstimage());
            dto.setMapx(entity.getMapx());
            dto.setMapy(entity.getMapy());
            dtos.add(dto);
        }
        return dtos;
    }
}
