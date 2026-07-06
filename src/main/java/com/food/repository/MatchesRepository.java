package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Matches;

public interface MatchesRepository extends JpaRepository<Matches, Long> {
    List<Matches> findByMatchStatus(String matchStatus);
}
