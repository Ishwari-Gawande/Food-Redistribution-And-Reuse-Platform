package com.food.service;

import java.util.List;

import com.food.entities.Matches;

public interface MatchService {
public Matches findById(Long id);
public List<Matches> findAllMatches();
public List<Matches> findPendingMatches();
public String approveMatch(Long id);
}
