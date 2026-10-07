package com.example.SpiderWidth.service;

import com.example.SpiderWidth.globalexception.exception.TargetNotFoundException;
import com.example.SpiderWidth.module.TargetPlayer;
import com.example.SpiderWidth.repository.TargetsDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ViewTargetService {
    private final TargetsDeviceRepository repository;

    public TargetPlayer onePlayerTargetLocation(String device_id) {
        return repository.findByDevice_id(device_id).orElseThrow(() -> new TargetNotFoundException(device_id));
    }

    public List<TargetPlayer> showAllDeviceLocation() {
        return repository.findAll();
    }

    public List<TargetPlayer> targetedDeviceIdLocation(String username) {
        return repository.findByUsername(username);
    }
}
