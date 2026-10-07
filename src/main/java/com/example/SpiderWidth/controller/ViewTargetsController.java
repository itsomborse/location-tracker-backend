package com.example.SpiderWidth.controller;

import com.example.SpiderWidth.module.TargetPlayer;
import com.example.SpiderWidth.service.ViewTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/view")
@CrossOrigin(origins = "*")
public class ViewTargetsController {
    private final ViewTargetService viewTargetService;

    @GetMapping()
    public ResponseEntity<List<TargetPlayer>> availableTargetsDeviceLocation() {
        return new ResponseEntity<>(viewTargetService.showAllDeviceLocation(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TargetPlayer>> searchedTargetDeviceLocation(@RequestParam String username) {
        return new ResponseEntity<>(viewTargetService.targetedDeviceIdLocation(username),HttpStatus.OK);
    }

    @GetMapping("/device_id/{id}")
    public ResponseEntity<TargetPlayer> oneTargetDeviceLocation(@PathVariable String id) {
        return new ResponseEntity<>(viewTargetService.onePlayerTargetLocation(id),HttpStatus.OK);
    }

}
