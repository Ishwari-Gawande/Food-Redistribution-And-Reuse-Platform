package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.MatchServiceImpl;
@RestController
@RequestMapping("/match")
public class MatchesController {
@Autowired
private MatchServiceImpl matchService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
	    return ResponseEntity.ok(matchService.findById(id));
	}
}
