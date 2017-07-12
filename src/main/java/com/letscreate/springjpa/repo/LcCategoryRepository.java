package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcCategory;

public interface LcCategoryRepository extends JpaRepository<LcCategory, Integer> {

}
