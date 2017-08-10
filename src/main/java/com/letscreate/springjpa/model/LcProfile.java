package com.letscreate.springjpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the lc_profile database table.
 * 
 */
@Entity
@Table(name="lc_profile")
//@NamedQuery(name="LcProfile.findAll", query="SELECT l FROM LcProfile l")
public class LcProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_profile_id")
	private Integer lcProfileId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Lob
	@Column(name="lc_profile_photo")
	private byte[] lcProfilePhoto;

	@Column(name="lc_profile_statement")
	private String lcProfileStatement;

	@Column(name="lc_profile_tell_abt_yrself")
	private String lcProfileTellAbtYrself;

	@Column(name="lc_profile_title")
	private String lcProfileTitle;

	@Lob
	@Column(name="lc_profile_video")
	private byte[] lcProfileVideo;

	@Column(name="lc_profile_video_url")
	private String lcProfileVideoUrl;

	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//creating new fields in profile table begin
	@Column(name="lc_name",length=500)
	private String lcName;
	
	@Column(name="lc_primary_email",length=500)
	private String  lcPrimaryEmail;
	
	@Column(name="lc_seconadry_email",length=500)
	private String lcSecondryEmail;
	
	@Column(name="lc_username",length=500)
	private String lcUserName;
	
	@Column(name="lc_password",length=1000)
	private String lcPassWord;
	
	@Column(name="lc_gender",length=25)
	private String lcGender;
	
	@Column(name="lc_age")
	private Integer lcAge;
	
	@Column(name="lc_street",length=2500)
	private String lcStreet;
	
	@Column(name="lc_building",length=500)
	private String lcBuilding;
	
	@Column(name="lc_phone",length=25)
	private String lcPhone;
	
	
	
	//creating new fields in profile table end
	
	
	public String getLcName() {
		return lcName;
	}

	public void setLcName(String lcName) {
		this.lcName = lcName;
	}

	public String getLcPrimaryEmail() {
		return lcPrimaryEmail;
	}

	public void setLcPrimaryEmail(String lcPrimaryEmail) {
		this.lcPrimaryEmail = lcPrimaryEmail;
	}

	public String getLcSecondryEmail() {
		return lcSecondryEmail;
	}

	public void setLcSecondryEmail(String lcSecondryEmail) {
		this.lcSecondryEmail = lcSecondryEmail;
	}

	public String getLcUserName() {
		return lcUserName;
	}

	public void setLcUserName(String lcUserName) {
		this.lcUserName = lcUserName;
	}

	public String getLcPassWord() {
		return lcPassWord;
	}

	public void setLcPassWord(String lcPassWord) {
		this.lcPassWord = lcPassWord;
	}

	public String getLcGender() {
		return lcGender;
	}

	public void setLcGender(String lcGender) {
		this.lcGender = lcGender;
	}

	public Integer getLcAge() {
		return lcAge;
	}

	public void setLcAge(Integer lcAge) {
		this.lcAge = lcAge;
	}

	public String getLcStreet() {
		return lcStreet;
	}

	public void setLcStreet(String lcStreet) {
		this.lcStreet = lcStreet;
	}

	public String getLcBuilding() {
		return lcBuilding;
	}

	public void setLcBuilding(String lcBuilding) {
		this.lcBuilding = lcBuilding;
	}

	public String getLcPhone() {
		return lcPhone;
	}

	public void setLcPhone(String lcPhone) {
		this.lcPhone = lcPhone;
	}

	//bi-directional many-to-one association to LcContribution
	@JsonManagedReference(value = "contribution")
	@OneToMany(mappedBy="lcProfile", cascade = CascadeType.ALL)
	private List<LcContribution> lcContributions;

	//bi-directional many-to-one association to LcPortfolio
	@JsonManagedReference(value ="Portfolios")
	@OneToMany(mappedBy="lcProfile", cascade = CascadeType.ALL)
	
	private List<LcPortfolio> lcPortfolios;

	//bi-directional many-to-one association to LcCity
	@JsonBackReference(value = "profilecity")
	@ManyToOne
	@JoinColumn(name="lc_cities_lc_city_id")
	private LcCity lcCity;

	//bi-directional many-to-one association to LcCountry
	@JsonBackReference(value="profilecountry")
	@ManyToOne
	@JoinColumn(name="lc_countries_lc_country_id")
	private LcCountry lcCountry;

	//bi-directional many-to-one association to LcState
	@JsonBackReference(value ="profilestate")
	@ManyToOne
	@JoinColumn(name="lc_states_lc_state_id")
	private LcState lcState;

	//bi-directional many-to-one association to LcProfileContibsXref
	@JsonManagedReference(value = "profilecontributionXref")
	@OneToMany(mappedBy="lcProfile", cascade=CascadeType.ALL)
	private List<LcProfileContibsXref> lcProfileContibsXrefs;

	//bi-directional many-to-one association to LcProfileInterestsXref
	@JsonManagedReference(value = "ProfileInterests")
	@OneToMany(mappedBy="lcProfile", cascade=CascadeType.ALL)
	private List<LcProfileInterestsXref> lcProfileInterestsXrefs;

	//bi-directional many-to-one association to LcRecommendation
	@JsonManagedReference(value = "Recommendations")
	@OneToMany(mappedBy="lcProfile")
	private List<LcRecommendation> lcRecommendations;

	//bi-directional many-to-one association to LcSocial
	@JsonManagedReference(value = "social")
	@OneToMany(mappedBy="lcProfile", cascade=CascadeType.ALL)
	private List<LcSocial> lcSocials;

	public LcProfile() {
		
	}

	public Integer getLcProfileId() {
		return this.lcProfileId;
	}

	public void setLcProfileId(Integer lcProfileId) {
		this.lcProfileId = lcProfileId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Object getLcProfilePhoto() {
		return this.lcProfilePhoto;
	}

	public void setLcProfilePhoto(byte[] lcProfilePhoto) {
		this.lcProfilePhoto = lcProfilePhoto;
	}

	public String getLcProfileStatement() {
		return this.lcProfileStatement;
	}

	public void setLcProfileStatement(String lcProfileStatement) {
		this.lcProfileStatement = lcProfileStatement;
	}

	public String getLcProfileTellAbtYrself() {
		return this.lcProfileTellAbtYrself;
	}

	public void setLcProfileTellAbtYrself(String lcProfileTellAbtYrself) {
		this.lcProfileTellAbtYrself = lcProfileTellAbtYrself;
	}

	public String getLcProfileTitle() {
		return this.lcProfileTitle;
	}

	public void setLcProfileTitle(String lcProfileTitle) {
		this.lcProfileTitle = lcProfileTitle;
	}

	public Object getLcProfileVideo() {
		return this.lcProfileVideo;
	}

	public void setLcProfileVideo(byte[] lcProfileVideo) {
		this.lcProfileVideo = lcProfileVideo;
	}

	public String getLcProfileVideoUrl() {
		return this.lcProfileVideoUrl;
	}

	public void setLcProfileVideoUrl(String lcProfileVideoUrl) {
		this.lcProfileVideoUrl = lcProfileVideoUrl;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<LcContribution> getLcContributions() {
		return this.lcContributions;
	}

	public void setLcContributions(List<LcContribution> lcContributions) {
		this.lcContributions = lcContributions;
	}

	public LcContribution addLcContribution(LcContribution lcContribution) {
		getLcContributions().add(lcContribution);
		lcContribution.setLcProfile(this);

		return lcContribution;
	}

	public LcContribution removeLcContribution(LcContribution lcContribution) {
		getLcContributions().remove(lcContribution);
		lcContribution.setLcProfile(null);

		return lcContribution;
	}

	public List<LcPortfolio> getLcPortfolios() {
		return this.lcPortfolios;
	}

	public void setLcPortfolios(List<LcPortfolio> lcPortfolios) {
		this.lcPortfolios = lcPortfolios;
	}

	public LcPortfolio addLcPortfolio(LcPortfolio lcPortfolio) {
		getLcPortfolios().add(lcPortfolio);
		lcPortfolio.setLcProfile(this);

		return lcPortfolio;
	}

	public LcPortfolio removeLcPortfolio(LcPortfolio lcPortfolio) {
		getLcPortfolios().remove(lcPortfolio);
		lcPortfolio.setLcProfile(null);

		return lcPortfolio;
	}

	public LcCity getLcCity() {
		return this.lcCity;
	}

	public void setLcCity(LcCity lcCity) {
		this.lcCity = lcCity;
	}

	public LcCountry getLcCountry() {
		return this.lcCountry;
	}

	public void setLcCountry(LcCountry lcCountry) {
		this.lcCountry = lcCountry;
	}

	public LcState getLcState() {
		return this.lcState;
	}

	public void setLcState(LcState lcState) {
		this.lcState = lcState;
	}

	public List<LcProfileContibsXref> getLcProfileContibsXrefs() {
		return this.lcProfileContibsXrefs;
	}

	public void setLcProfileContibsXrefs(List<LcProfileContibsXref> lcProfileContibsXrefs) {
		this.lcProfileContibsXrefs = lcProfileContibsXrefs;
	}

	public LcProfileContibsXref addLcProfileContibsXref(LcProfileContibsXref lcProfileContibsXref) {
		getLcProfileContibsXrefs().add(lcProfileContibsXref);
		lcProfileContibsXref.setLcProfile(this);

		return lcProfileContibsXref;
	}

	public LcProfileContibsXref removeLcProfileContibsXref(LcProfileContibsXref lcProfileContibsXref) {
		getLcProfileContibsXrefs().remove(lcProfileContibsXref);
		lcProfileContibsXref.setLcProfile(null);

		return lcProfileContibsXref;
	}

	public List<LcProfileInterestsXref> getLcProfileInterestsXrefs() {
		return this.lcProfileInterestsXrefs;
	}

	public void setLcProfileInterestsXrefs(List<LcProfileInterestsXref> lcProfileInterestsXrefs) {
		this.lcProfileInterestsXrefs = lcProfileInterestsXrefs;
	}

	public LcProfileInterestsXref addLcProfileInterestsXref(LcProfileInterestsXref lcProfileInterestsXref) {
		getLcProfileInterestsXrefs().add(lcProfileInterestsXref);
		lcProfileInterestsXref.setLcProfile(this);

		return lcProfileInterestsXref;
	}

	public LcProfileInterestsXref removeLcProfileInterestsXref(LcProfileInterestsXref lcProfileInterestsXref) {
		getLcProfileInterestsXrefs().remove(lcProfileInterestsXref);
		lcProfileInterestsXref.setLcProfile(null);

		return lcProfileInterestsXref;
	}

	public List<LcRecommendation> getLcRecommendations() {
		return this.lcRecommendations;
	}

	public void setLcRecommendations(List<LcRecommendation> lcRecommendations) {
		this.lcRecommendations = lcRecommendations;
	}

	public LcRecommendation addLcRecommendation(LcRecommendation lcRecommendation) {
		getLcRecommendations().add(lcRecommendation);
		lcRecommendation.setLcProfile(this);

		return lcRecommendation;
	}

	public LcRecommendation removeLcRecommendation(LcRecommendation lcRecommendation) {
		getLcRecommendations().remove(lcRecommendation);
		lcRecommendation.setLcProfile(null);

		return lcRecommendation;
	}

	public List<LcSocial> getLcSocials() {
		return this.lcSocials;
	}

	public void setLcSocials(List<LcSocial> lcSocials) {
		this.lcSocials = lcSocials;
	}

	public LcSocial addLcSocial(LcSocial lcSocial) {
		getLcSocials().add(lcSocial);
		lcSocial.setLcProfile(this);

		return lcSocial;
	}

	public LcSocial removeLcSocial(LcSocial lcSocial) {
		getLcSocials().remove(lcSocial);
		lcSocial.setLcProfile(null);

		return lcSocial;
	}
 
}