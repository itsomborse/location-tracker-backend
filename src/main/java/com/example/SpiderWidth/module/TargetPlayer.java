package com.example.SpiderWidth.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "targeted_devices")
public class TargetPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String device_id;
    private String username;
    private float latitude;
    private float longitude;
    private int delay = 30;
    private LocalDateTime updated_time;
    private LocalDateTime logged_time = LocalDateTime.now();

    public TargetPlayer(String device_id,int delay) {
        this.device_id = device_id;
        this.delay = delay;
    }

    public TargetPlayer(String device_id,float latitude, float longitude, LocalDateTime updated_time) {
        this.device_id = device_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.updated_time = updated_time;
    }
}
