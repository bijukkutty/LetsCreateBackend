package com.letscreate.springjpa.custom;

import java.util.ArrayList;
import java.util.List;

import com.letscreate.springjpa.model.LcCategory;

public class CategoriesResponse {
	List<LcCategory> CategoriesResponse = new ArrayList<LcCategory>();

	public List<LcCategory> getCategoriesResponse() {
		return CategoriesResponse;
	}

	public void setCategoriesResponse(List<LcCategory> categoriesResponse) {
		CategoriesResponse = categoriesResponse;
	}
	
	
}
