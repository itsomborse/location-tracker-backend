package com.example.SpiderWidth.service;

import com.example.SpiderWidth.globalexception.exception.TargetNotFoundException;
import com.example.SpiderWidth.module.TargetPlayer;
import com.example.SpiderWidth.repository.TargetsDeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TargetService {
    private final TargetsDeviceRepository repository;

    public void targetAddService(TargetPlayer targetPlayer) {
        TargetPlayer player = repository.findByDevice_id(targetPlayer.getDevice_id()).orElse(null);
        if (player!=null) {
            player.setLatitude(targetPlayer.getLatitude());
            player.setLongitude(targetPlayer.getLongitude());
            player.setUpdated_time(LocalDateTime.now());
            repository.save(player);
            log.info("User: {} Is Added With Device Id: {}At {} Time", player.getUsername(), player.getDevice_id(), player.getLogged_time());
        }
        else {
            repository.save(targetPlayer);
            log.info("User: {} Is Added With Device Id: {}At {} Time", targetPlayer.getUsername(), targetPlayer.getDevice_id(), targetPlayer.getLogged_time());
        }
    }
}
