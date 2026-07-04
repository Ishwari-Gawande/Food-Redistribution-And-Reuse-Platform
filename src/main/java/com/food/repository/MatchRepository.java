package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entities.Matches;

public interface MatchRepository extends JpaRepository<Matches, Long>{

}
