package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcRecommendation;

public interface LcRecommendationRepository extends JpaRepository<LcRecommendation, Integer >{

}
