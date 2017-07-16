package com.letscreate.springjpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the lc_states database table.
 * 
 */
@Entity
@Table(name="lc_states")
@NamedQuery(name="LcState.findAll", query="SELECT l FROM LcState l")
public class LcState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_state_id")
	private Integer lcStateId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_state_name")
	private String lcStateName;

	@Column(name="update_date")
	private String updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to LcCity
	@JsonManagedReference
	@OneToMany(mappedBy="lcState")
	private List<LcCity> lcCities;

	//bi-directional many-to-one association to LcProfile
	@JsonManagedReference
	@OneToMany(mappedBy="lcState")
	private List<LcProfile> lcProfiles;

	//bi-directional many-to-one association to LcCountry
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="lc_country_id")
	private LcCountry lcCountry;

	public LcState() {
	}

	public Integer getLcStateId() {
		return this.lcStateId;
	}

	public void setLcStateId(Integer lcStateId) {
		this.lcStateId = lcStateId;
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

	public String getLcStateName() {
		return this.lcStateName;
	}

	public void setLcStateName(String lcStateName) {
		this.lcStateName = lcStateName;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<LcCity> getLcCities() {
		return this.lcCities;
	}

	public void setLcCities(List<LcCity> lcCities) {
		this.lcCities = lcCities;
	}

	public LcCity addLcCity(LcCity lcCity) {
		getLcCities().add(lcCity);
		lcCity.setLcState(this);

		return lcCity;
	}

	public LcCity removeLcCity(LcCity lcCity) {
		getLcCities().remove(lcCity);
		lcCity.setLcState(null);

		return lcCity;
	}

	public List<LcProfile> getLcProfiles() {
		return this.lcProfiles;
	}

	public void setLcProfiles(List<LcProfile> lcProfiles) {
		this.lcProfiles = lcProfiles;
	}

	public LcProfile addLcProfile(LcProfile lcProfile) {
		getLcProfiles().add(lcProfile);
		lcProfile.setLcState(this);

		return lcProfile;
	}

	public LcProfile removeLcProfile(LcProfile lcProfile) {
		getLcProfiles().remove(lcProfile);
		lcProfile.setLcState(null);

		return lcProfile;
	}

	public LcCountry getLcCountry() {
		return this.lcCountry;
	}

	public void setLcCountry(LcCountry lcCountry) {
		this.lcCountry = lcCountry;
	}

}