package com.letscreate.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letscreate.springjpa.model.LcPortfolio;
import com.letscreate.springjpa.model.LcProfile;
import com.letscreate.springjpa.model.LcSocial;
import com.letscreate.springjpa.repo.LcPortfolioRepository;
import com.letscreate.springjpa.repo.LcProfileRepository;

@RestController
public class LcProfileWebController {
	@Autowired
	LcProfileRepository lcProfileRepo;
	LcPortfolioRepository lcPortRepo;

	@PostMapping("/saveprofile")
	public ResponseEntity<?> saveProfile(@RequestBody LcProfile lcProfile) {
		for (LcPortfolio lcPort : lcProfile.getLcPortfolios()) {
			lcPort.setLcProfile(lcProfile);
		}
		for (LcSocial lcSocial : lcProfile.getLcSocials()) {
			lcSocial.setLcProfile(lcProfile);
		}
		LcProfile lop = lcProfileRepo.save(lcProfile);
		return new ResponseEntity("Successfully login", new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping("/findallProfiles")
	public List<LcProfile> findAll1() {
		System.out
				.println("Entered FindAll Profiles---------------------------------------------------------------------");
		List<LcProfile> profileList = lcProfileRepo.findAll();
		for (LcProfile profile : profileList) {
			System.out.println("Profile Title is-->"
					+ profile.getLcProfileTitle());
		}
		return profileList;
	}

}