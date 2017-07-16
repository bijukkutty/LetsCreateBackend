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
import com.letscreate.springjpa.model.LcPortfolio;
import com.letscreate.springjpa.model.LcProfile;
import com.letscreate.springjpa.model.LcProfileContibsXref;
import com.letscreate.springjpa.model.LcSocial;
import com.letscreate.springjpa.repo.LcProfileRepository;

@RestController
public class LcProfileWebController {
	@Autowired
	LcProfileRepository lcProfileRepo;

	@PostMapping("/saveprofile")
	public ResponseEntity<?> saveProfile(@RequestBody LcProfile lcProfile) {
		for (LcPortfolio lcPort : lcProfile.getLcPortfolios()) {
			lcPort.setLcProfile(lcProfile);
		}
		for (LcSocial lcSocial : lcProfile.getLcSocials()) {
			lcSocial.setLcProfile(lcProfile);
		}
		for (LcProfileContibsXref lcProfileContrib : lcProfile.getLcProfileContibsXrefs()) {
			lcProfileContrib.setLcProfile(lcProfile);
		}
		lcProfileRepo.save(lcProfile);
		return new ResponseEntity<Object>("Successfully created profile.", new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping("/findProfileById")
	public LcProfile findProfileById(@RequestParam("user_id") int id) {
		System.out.println("Entered findCountryById---------------------------------------------------------------------");
		LcProfile lcProfile = lcProfileRepo.findOne(id);
		System.out.println("Country Name is-->"+lcProfile.getLcProfileTitle());
		return lcProfile;
	}

}