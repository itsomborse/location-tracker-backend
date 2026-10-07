package com.example.SpiderWidth.repository;

import com.example.SpiderWidth.module.TargetPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TargetsDeviceRepository extends JpaRepository<TargetPlayer,Integer>{
    @Query("SELECT t FROM TargetPlayer t WHERE t.device_id = :deviceId")
    Optional<TargetPlayer> findByDevice_id(@Param("deviceId") String deviceId);
    List<TargetPlayer> findByUsername(String username);
}
