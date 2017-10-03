package com.letscreate.springjpa.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.letscreate.springjpa.model.LcCountry;
import com.letscreate.springjpa.repo.LcCountryRepository;

@RestController

public class LcCountryWebController {
	@Autowired
	LcCountryRepository lcCountryRepo;

	@PostMapping("/saveCountry")
	public ResponseEntity<?> process(@RequestBody LcCountry lcCountry) {
		lcCountryRepo.save(lcCountry);
		return new ResponseEntity("Successfully login", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping("/findallCountries")
	public List<LcCountry> findallCountries() {
		System.out.println(
				"Entered FindAll Profiles---------------------------------------------------------------------");
		List<LcCountry> countryList = lcCountryRepo.findAll();
		for (LcCountry country : countryList) {
			System.out.println("Country Name is-->" + country.getLcCountryName());
		}
		return countryList;
	}

	@RequestMapping("/findCountryById")
	public LcCountry findCountryById(@RequestParam("id") int id) {
		System.out.println(
				"Entered findCountryById---------------------------------------------------------------------");
		LcCountry country = lcCountryRepo.findOne(id);
		System.out.println("Country Name is-->" + country.getLcCountryName());
		try {
			System.out.println("going to call objectmapper");
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			System.out.println("\n\n----------REQUEST-----------");
			StringWriter sw = new StringWriter();
			mapper.writeValue(sw, country);
			new ObjectMapper().writeValueAsString(country);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return country;
	}

}