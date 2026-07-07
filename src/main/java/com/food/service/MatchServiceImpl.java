package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.DTO.AssignDeliveryDTO;
import com.food.Exception.ResourceNotFoundException;
import com.food.entities.Matches;
import com.food.entities.User;
import com.food.repository.MatchesRepository;
import com.food.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
@Autowired
private MatchesRepository matchRepo;
@Autowired
private UserRepository userRepo;
	
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

	@Override
	public List<Matches> findPendingMatches() {
		 return matchRepo.findByMatchStatus("PENDING");	}

	@Override
	public String approveMatch(Long id) {

	    Matches match = matchRepo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Match not found"));

	    match.setMatchStatus("APPROVED");

	    matchRepo.save(match);

	    return "Match Approved Successfully";
	}

	@Override
	public String rejectMatch(Long id) {
		Matches match = matchRepo.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Match not found"));

	    match.setMatchStatus("REJECTED");

	    matchRepo.save(match);

	    return "Match Rejected Successfully";
	}

	@Override
	public String assignDeliveryPartner(Long matchId, AssignDeliveryDTO request) {
		  Matches match = matchRepo.findById(matchId)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Match not found"));

		    User deliveryPartner = userRepo.findById(request.getDeliveryPartnerId())
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Delivery Partner not found"));

		    match.setDeliveryPartner(deliveryPartner);

		    match.setMatchStatus("ASSIGNED");

		    matchRepo.save(match);

		    return "Delivery Partner Assigned Successfully";
	}

}
