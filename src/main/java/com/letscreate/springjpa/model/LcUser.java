package com.letscreate.springjpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lc_user database table.
 * 
 */
@Entity
@Table(name="lc_user")
@NamedQuery(name="LcUser.findAll", query="SELECT l FROM LcUser l")
public class LcUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lc_user_id")
	private Integer lcUserId;

	@Column(name="lc_cities_lc_city_id")
	private Integer lcCitiesLcCityId;

	@Column(name="lc_countries_lc_country_id")
	private Integer lcCountriesLcCountryId;

	@Column(name="lc_profile_lc_profile_id")
	private Integer lcProfileLcProfileId;

	@Column(name="lc_states_lc_state_id")
	private Integer lcStatesLcStateId;

	public LcUser() {
	}

	public Integer getLcUserId() {
		return this.lcUserId;
	}

	public void setLcUserId(Integer lcUserId) {
		this.lcUserId = lcUserId;
	}

	public Integer getLcCitiesLcCityId() {
		return this.lcCitiesLcCityId;
	}

	public void setLcCitiesLcCityId(Integer lcCitiesLcCityId) {
		this.lcCitiesLcCityId = lcCitiesLcCityId;
	}

	public Integer getLcCountriesLcCountryId() {
		return this.lcCountriesLcCountryId;
	}

	public void setLcCountriesLcCountryId(Integer lcCountriesLcCountryId) {
		this.lcCountriesLcCountryId = lcCountriesLcCountryId;
	}

	public Integer getLcProfileLcProfileId() {
		return this.lcProfileLcProfileId;
	}

	public void setLcProfileLcProfileId(Integer lcProfileLcProfileId) {
		this.lcProfileLcProfileId = lcProfileLcProfileId;
	}

	public Integer getLcStatesLcStateId() {
		return this.lcStatesLcStateId;
	}

	public void setLcStatesLcStateId(Integer lcStatesLcStateId) {
		this.lcStatesLcStateId = lcStatesLcStateId;
	}

}