package com.letscreate.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.LcUser;

public interface LcUserRepository extends JpaRepository<LcUser, Integer >{

}
