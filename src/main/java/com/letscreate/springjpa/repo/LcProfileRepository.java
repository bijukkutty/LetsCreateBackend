package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcProfile;

public interface LcProfileRepository extends JpaRepository<LcProfile, Integer>{
	
}