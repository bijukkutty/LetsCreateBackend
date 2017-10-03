package com.letscreate.springjpa.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letscreate.springjpa.custom.CategoriesResponse;
import com.letscreate.springjpa.custom.ProfileResponse;
import com.letscreate.springjpa.model.LcCategory;
import com.letscreate.springjpa.model.LcPortfolio;
import com.letscreate.springjpa.model.LcProfile;
import com.letscreate.springjpa.model.LcProfileContibsXref;
import com.letscreate.springjpa.model.LcSocial;
import com.letscreate.springjpa.repo.LcCategoryRepository;
import com.letscreate.springjpa.repo.LcProfileRepository;

@RestController
public class LcProfileWebController {
	@Autowired
	LcProfileRepository lcProfileRepo;
	@Autowired
	LcCategoryRepository lcCatRepo;

	@PersistenceContext
	private EntityManager em;

	@PostMapping("/saveprofile")
	public ResponseEntity<?> saveProfile(@RequestBody LcProfile lcProfile) {
		String respString = "";
		if (lcProfile.getLcPortfolios() != null && !lcProfile.getLcPortfolios().isEmpty()) {
			for (LcPortfolio lcPort : lcProfile.getLcPortfolios()) {
				if (lcPort != null)
					lcPort.setLcProfile(lcProfile);
			}
		}
		if (lcProfile.getLcSocials() != null && !lcProfile.getLcSocials().isEmpty()) {

			for (LcSocial lcSocial : lcProfile.getLcSocials()) {
				if (lcSocial != null)
					lcSocial.setLcProfile(lcProfile);

			}
		}
		if (lcProfile.getLcProfileContibsXrefs() != null && !lcProfile.getLcProfileContibsXrefs().isEmpty()) {

			for (LcProfileContibsXref lcProfileContrib : lcProfile.getLcProfileContibsXrefs()) {
				if (lcProfileContrib != null)
					lcProfileContrib.setLcProfile(lcProfile);
			}

		}
		if (lcProfile.getLcProfileId() == null) {
			lcProfileRepo.save(lcProfile);
			respString = "Successfully created profile with profileId:";
		} else {
			lcProfileRepo.save(lcProfile);
			respString = "Successfully updated profile with profileId:";
		}
		return new ResponseEntity<Object>(respString + lcProfile.getLcProfileId(), new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping("/findProfileById")
	public ProfileResponse findProfileById(@RequestParam("user_id") int id) {
		System.out.println(
				"Entered findCountryById---------------------------------------------------------------------");
		LcProfile lcProfile = lcProfileRepo.findOne(id);
		ProfileResponse profileResp = new ProfileResponse();
		profileResp.setProfileRootObject(lcProfile);
		profileResp.getProfileLocationDtls().setProfileCountryName(lcProfile.getLcCountry().getLcCountryName());
		profileResp.getProfileLocationDtls().setProfileStateName(lcProfile.getLcState().getLcStateName());
		profileResp.getProfileLocationDtls().setProfileCityName(lcProfile.getLcCity().getLcCityName());
		return profileResp;
	}

	@RequestMapping("/findCatAndSubCat")
	public CategoriesResponse findCategories() {
		System.out.println(
				"Entered findCatAndSubCat---------------------------------------------------------------------");
		List<LcCategory> lcCatList = lcCatRepo.findAll();
		CategoriesResponse catResp = new CategoriesResponse();
		catResp.setCategoriesResponse(lcCatList);
		return catResp;
	}

	@RequestMapping("/searchprofile")
	public ProfileResponse searchprofile(@RequestParam("username") String name) {
		ProfileResponse response = new ProfileResponse();
		LcProfile lcProfile = em
				.createQuery("SELECT e FROM LcProfile e WHERE e.lcUserName = :username", LcProfile.class)
				.setParameter("username", name).getSingleResult();

		response.setProfileRootObject(lcProfile);
		response.getProfileLocationDtls().setProfileCountryName(lcProfile.getLcCountry().getLcCountryName());
		response.getProfileLocationDtls().setProfileStateName(lcProfile.getLcState().getLcStateName());
		response.getProfileLocationDtls().setProfileCityName(lcProfile.getLcCity().getLcCityName());
		return response;
	}

}