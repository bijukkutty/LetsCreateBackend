package com.letscreate.springjpa.custom;

import com.letscreate.springjpa.model.LcProfile;

public class ProfileResponse {
	LcProfile lcProfile;
	String LcCountryName;
	String LcStateName;
	String LcCityName;
	public LcProfile getLcProfile() {
		return lcProfile;
	}
	public void setLcProfile(LcProfile lcProfile) {
		this.lcProfile = lcProfile;
	}
	public String getLcCountryName() {
		return LcCountryName;
	}
	public void setLcCountryName(String lcCountryName) {
		LcCountryName = lcCountryName;
	}
	public String getLcStateName() {
		return LcStateName;
	}
	public void setLcStateName(String lcStateName) {
		LcStateName = lcStateName;
	}
	public String getLcCityName() {
		return LcCityName;
	}
	public void setLcCityName(String lcCityName) {
		LcCityName = lcCityName;
	}

}
