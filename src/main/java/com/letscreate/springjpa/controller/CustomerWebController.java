package com.letscreate.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letscreate.springjpa.model.Customer;
import com.letscreate.springjpa.repo.CustomerRepository;

@RestController
public class CustomerWebController {
	@Autowired
	CustomerRepository repository;

	@RequestMapping("/save")
	public String process() {
		repository.save(new Customer("Jack", "Smith"));
		repository.save(new Customer("Adam", "Johnson"));
		repository.save(new Customer("Kim", "Smith"));
		repository.save(new Customer("David", "Williams"));
		repository.save(new Customer("Peter", "Davis"));
		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "<html>";

		for (Customer cust : repository.findAll()) {
			result += "<div>" + cust.toString() + "</div>";
		}

		return result + "</html>";
	}

	@RequestMapping("/findall1")
	public List<Customer> findAll1() {
		List<Customer> custList = repository.findAll();
		for (Customer cust : custList) {
			System.out.println("Customer Name is-->"+cust.getFirstName());
		}
		return custList;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping(value = "/findbyid1", method = RequestMethod.GET, produces = "application/json")
	public Customer findById1(@RequestParam("id") long id) {
		// String result = "";
		System.out.println("Input ID is-->" + id);
		Customer result = repository.findOne(id);
		System.out.println("Customer is-->" + result.toString());
		return result;
	}

	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
		String result = "<html>";

		for (Customer cust : repository.findByLastName(lastName)) {
			result += "<div>" + cust.toString() + "</div>";
		}

		return result + "</html>";
	}
}