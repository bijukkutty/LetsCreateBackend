package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcCountry;



public interface LcCountryRepository extends JpaRepository<LcCountry, Integer> {

}
