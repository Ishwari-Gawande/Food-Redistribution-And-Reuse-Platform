package com.food.service;

import java.util.List;

import com.food.DTO.AssignDeliveryDTO;
import com.food.entities.Matches;

public interface MatchService {
public Matches findById(Long id);
public List<Matches> findAllMatches();
public List<Matches> findPendingMatches();
public String approveMatch(Long id);
public String rejectMatch(Long id);
public String assignDeliveryPartner(Long matchId,
        AssignDeliveryDTO request);
}
