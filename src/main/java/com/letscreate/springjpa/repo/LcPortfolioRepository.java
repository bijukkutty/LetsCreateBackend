package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcPortfolio;

public interface LcPortfolioRepository extends JpaRepository<LcPortfolio, Integer > {

}
