package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entities.Matches;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface MatchRepository extends JpaRepository<Matches, Long>{

}
