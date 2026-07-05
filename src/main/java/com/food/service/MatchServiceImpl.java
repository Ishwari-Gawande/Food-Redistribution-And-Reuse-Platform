package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Matches;
import com.food.repository.MatchRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class MatchServiceImpl implements MatchService {
@Autowired
private MatchRepository matchRepo;
	
	@Override
	public Matches findById(Long id) {
		   return matchRepo.findById(id)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Match not found"));
	}

	@Override
	public List<Matches> findAllMatches() {
		
		return matchRepo.findAll();
	}

}
