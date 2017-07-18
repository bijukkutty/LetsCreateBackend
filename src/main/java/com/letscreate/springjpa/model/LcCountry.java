package com.letscreate.springjpa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the lc_countries database table.
 * 
 */
@Entity
@Table(name="lc_countries")
@NamedQuery(name="LcCountry.findAll", query="SELECT l FROM LcCountry l")
public class LcCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_country_id")
	private Integer lcCountryId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_country_name")
	private String lcCountryName;

	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to LcProfile
	@JsonManagedReference(value="Country")
	@OneToMany(mappedBy="lcCountry", fetch = FetchType.LAZY)
	private List<LcProfile> lcProfiles;

	//bi-directional many-to-one association to LcState
	@JsonManagedReference(value ="referCountry")
	@OneToMany(mappedBy="lcCountry", fetch = FetchType.LAZY)
	private List<LcState> lcStates;

	public LcCountry() {
		
	}

	public Integer getLcCountryId() {
		return this.lcCountryId;
	}

	public void setLcCountryId(Integer lcCountryId) {
		this.lcCountryId = lcCountryId;
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

	public String getLcCountryName() {
		return this.lcCountryName;
	}

	public void setLcCountryName(String lcCountryName) {
		this.lcCountryName = lcCountryName;
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

	public List<LcProfile> getLcProfiles() {
		return this.lcProfiles;
	}

	public void setLcProfiles(List<LcProfile> lcProfiles) {
		this.lcProfiles = lcProfiles;
	}

	public LcProfile addLcProfile(LcProfile lcProfile) {
		getLcProfiles().add(lcProfile);
		lcProfile.setLcCountry(this);

		return lcProfile;
	}

	public LcProfile removeLcProfile(LcProfile lcProfile) {
		getLcProfiles().remove(lcProfile);
		lcProfile.setLcCountry(null);

		return lcProfile;
	}

	public List<LcState> getLcStates() {
		return this.lcStates;
	}

	public void setLcStates(List<LcState> lcStates) {
		this.lcStates = lcStates;
	}

	public LcState addLcState(LcState lcState) {
		getLcStates().add(lcState);
		lcState.setLcCountry(this);

		return lcState;
	}

	public LcState removeLcState(LcState lcState) {
		getLcStates().remove(lcState);
		lcState.setLcCountry(null);

		return lcState;
	}

}