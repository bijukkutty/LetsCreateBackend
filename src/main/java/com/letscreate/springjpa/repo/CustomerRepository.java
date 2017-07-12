package com.letscreate.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letscreate.springjpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}