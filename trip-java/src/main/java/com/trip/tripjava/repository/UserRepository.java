package com.trip.tripjava.repository;

import com.trip.tripjava.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByIdAndPassword(String id, String password);
    UserEntity findByNickname(String nickname);
    UserEntity findByIdAndEmail(String id, String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE UserEntity SET status = 'deactivated' WHERE id = :userId")
    void deactivateUserById(@Param("userId") String userId);
}
