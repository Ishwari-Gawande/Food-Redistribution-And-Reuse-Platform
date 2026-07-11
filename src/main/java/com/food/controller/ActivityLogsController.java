package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.entities.ActivityLogs;
import com.food.service.ActivityLogsServiceImpl;
@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogsController {
    @Autowired
    private ActivityLogsServiceImpl activityService;

    @GetMapping
    public ResponseEntity<List<ActivityLogs>> findAll() {

        return ResponseEntity.ok(activityService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ActivityLogs> findById(@PathVariable Long id) {

        return ResponseEntity.ok(activityService.findById(id));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLogs>> findByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(activityService.findByUser(userId));
    }

}
