package com.letscreate.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letscreate.springjpa.custom.ProfileResponse;
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
		if (!lcProfile.getLcPortfolios().isEmpty()) {
			for (LcPortfolio lcPort : lcProfile.getLcPortfolios()) {
				if (lcPort != null)
					lcPort.setLcProfile(lcProfile);
			}
		}
		if (!lcProfile.getLcSocials().isEmpty()) {
			for (LcSocial lcSocial : lcProfile.getLcSocials()) {
				if (lcSocial != null)
					lcSocial.setLcProfile(lcProfile);
			}
		}
		if (!lcProfile.getLcProfileContibsXrefs().isEmpty()) {
			if (lcProfile.getLcProfileContibsXrefs() != null) {
				for (LcProfileContibsXref lcProfileContrib : lcProfile
						.getLcProfileContibsXrefs()) {
					if (lcProfileContrib != null)
						lcProfileContrib.setLcProfile(lcProfile);
				}
			}
		}
		lcProfileRepo.save(lcProfile);
		return new ResponseEntity<Object>("Successfully created profile.",
				new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping("/findProfileById")
	public ProfileResponse findProfileById(@RequestParam("user_id") int id) {
		System.out
				.println("Entered findCountryById---------------------------------------------------------------------");
		LcProfile lcProfile = lcProfileRepo.findOne(id);
		ProfileResponse profileResp = new ProfileResponse();
		profileResp.setLcProfile(lcProfile);
		profileResp.setLcCountryName(lcProfile.getLcCountry().getLcCountryName());
		profileResp.setLcStateName(lcProfile.getLcState().getLcStateName());
		profileResp.setLcCityName(lcProfile.getLcCity().getLcCityName());
		return profileResp;
	}

}