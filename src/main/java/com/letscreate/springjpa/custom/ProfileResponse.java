package com.letscreate.springjpa.custom;

import com.letscreate.springjpa.model.LcProfile;

public class ProfileResponse {
	LcProfile ProfileRootObject;
	ProfileLocationDtls profileLocationDtls = new ProfileLocationDtls();
	public LcProfile getProfileRootObject() {
		return ProfileRootObject;
	}
	public void setProfileRootObject(LcProfile ProfileRootObject) {
		this.ProfileRootObject = ProfileRootObject;
	}
	public ProfileLocationDtls getProfileLocationDtls() {
		return profileLocationDtls;
	}
	public void setProfileLocationDtls(ProfileLocationDtls profileLocationDtls) {
		this.profileLocationDtls = profileLocationDtls;
	}
	

}
