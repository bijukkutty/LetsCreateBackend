package com.letscreate.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the lc_profile_interests_xref database table.
 * 
 */
@Entity
@Table(name="lc_profile_interests_xref")
@NamedQuery(name="LcProfileInterestsXref.findAll", query="SELECT l FROM LcProfileInterestsXref l")
public class LcProfileInterestsXref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_profile_interest_id")
	private Integer lcProfileInterestId;

	//bi-directional many-to-one association to LcProfile
	@JsonBackReference(value = "ProfileInterests")
	@ManyToOne
	@JoinColumn(name="lc_profile_lc_profile_id")
	private LcProfile lcProfile;

	//bi-directional many-to-one association to LcSubCategory
	@JsonBackReference(value = "Category")
	@ManyToOne
	@JoinColumn(name="lc_sub_categories_lc_sub_category_id")
	private LcSubCategory lcSubCategory;

	public LcProfileInterestsXref() {
	}

	public Integer getLcProfileInterestId() {
		return this.lcProfileInterestId;
	}

	public void setLcProfileInterestId(Integer lcProfileInterestId) {
		this.lcProfileInterestId = lcProfileInterestId;
	}

	public LcProfile getLcProfile() {
		return this.lcProfile;
	}

	public void setLcProfile(LcProfile lcProfile) {
		this.lcProfile = lcProfile;
	}

	public LcSubCategory getLcSubCategory() {
		return this.lcSubCategory;
	}

	public void setLcSubCategory(LcSubCategory lcSubCategory) {
		this.lcSubCategory = lcSubCategory;
	}

}