package com.example.SpiderWidth.service;

import com.example.SpiderWidth.globalexception.exception.TargetNotFoundException;
import com.example.SpiderWidth.module.TargetPlayer;
import com.example.SpiderWidth.repository.TargetsDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestrictedTargetService {
    private final TargetsDeviceRepository repository;

    public void setDelayTime(String device_id, int delay) {
        TargetPlayer player = repository.findByDevice_id(device_id).orElseThrow(() -> new TargetNotFoundException(device_id));
        player.setDelay(delay);
        repository.save(player);
        log.info("Delay Time Set to "+delay+" For Device Id: "+device_id);
    }

    public void setTargetDeviceName(String device_id, String update_name) {
        TargetPlayer player = repository.findByDevice_id(device_id).orElseThrow(() -> new TargetNotFoundException(device_id));
        player.setUsername(update_name);

        repository.save(player);
        log.info("New Name: "+update_name+" Updated For Device Id: "+device_id);
    }

    public void eliminateTargetDevice(String device_id) {
        TargetPlayer player = repository.findByDevice_id(device_id).orElseThrow(() -> new TargetNotFoundException(device_id));
        repository.delete(player);
        log.info(device_id+" Target Eliminated");
    }
}
