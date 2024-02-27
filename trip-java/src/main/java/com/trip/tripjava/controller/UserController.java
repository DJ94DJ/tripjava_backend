package com.trip.tripjava.controller;

import com.trip.tripjava.dto.UserDTO;
import com.trip.tripjava.entity.UserEntity;
import com.trip.tripjava.security.TokenProvider;
import com.trip.tripjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    TokenProvider tokenProvider;

    // 회원가입
    @PostMapping("")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = UserEntity.builder()
                    .id(userDTO.getId())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .email(userDTO.getEmail())
                    .nickname(userDTO.getNickname())
                    .status("activated") // 회원가입 시 활성 상태로 설정
                    .build();

            UserEntity responseUser = userService.signup(user);

            return ResponseEntity.ok().body("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = userService.login(userDTO.getId(), userDTO.getPassword());

            if(user == null) {
                throw new RuntimeException("login failed");
            }

            String token = tokenProvider.create(user);

            UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 아이디 중복체크
    @PostMapping("/check-id")
    public ResponseEntity<?> duplicateCheckId(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(userService.checkId(userDTO.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 닉네임 중복체크
    @PostMapping("/check-nickname")
    public ResponseEntity<?> duplicateCheckNickname(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(userService.checkNickname(userDTO.getNickname()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 사용자 정보 조회 (마이페이지)
    @GetMapping("")
    public ResponseEntity<?> getUserProfile(@RequestParam String id) {
        try {
            UserEntity user = userService.getUserInfo(id);

            UserDTO responseUser = UserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .build();
            return ResponseEntity.ok().body(responseUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 회원정보 수정 (비밀번호, 닉네임, 이메일)
    @PatchMapping("")
    public ResponseEntity<?> updateUserProfile(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = UserEntity.builder()
                    .id(userDTO.getId())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .email(userDTO.getEmail())
                    .nickname(userDTO.getNickname())
                    .build();
            userService.editUserInfo(user);

            String token = tokenProvider.create(user);

            UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 회원정보 수정 (닉네임, 이메일)
    @PatchMapping("/nickname-email")
    public ResponseEntity<?> updateNicknameAndEmail(@RequestBody UserDTO userDTO) {
        try {
            UserEntity updateUser = userService.editNicknameAndEmail(userDTO);
            if (updateUser == null) {
                return ResponseEntity.ok().body("존재하지 않는 유저입니다.");
            }
            String token = tokenProvider.create(updateUser);

            UserDTO responseUserDTO = UserDTO.builder()
                    .email(updateUser.getEmail())
                    .nickname(updateUser.getNickname())
                    .id(updateUser.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 회원 탈퇴
    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestBody UserDTO userDTO) {
        try {
            String msg = userService.deleteUser(userDTO.getId(), userDTO.getEmail());
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}