package com.letscreate.springjpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lc_cities database table.
 * 
 */
@Entity
@Table(name="lc_cities")
@NamedQuery(name="LcCity.findAll", query="SELECT l FROM LcCity l")
public class LcCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_city_id")
	private Integer lcCityId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_city_name")
	private String lcCityName;

	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to LcState
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="lc_state_id")
	private LcState lcState;

	//bi-directional many-to-one association to LcProfile
	@OneToMany(mappedBy="lcCity")
	private List<LcProfile> lcProfiles;

	public LcCity() {
	}

	public Integer getLcCityId() {
		return this.lcCityId;
	}

	public void setLcCityId(Integer lcCityId) {
		this.lcCityId = lcCityId;
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

	public String getLcCityName() {
		return this.lcCityName;
	}

	public void setLcCityName(String lcCityName) {
		this.lcCityName = lcCityName;
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

	public LcState getLcState() {
		return this.lcState;
	}

	public void setLcState(LcState lcState) {
		this.lcState = lcState;
	}

	public List<LcProfile> getLcProfiles() {
		return this.lcProfiles;
	}

	public void setLcProfiles(List<LcProfile> lcProfiles) {
		this.lcProfiles = lcProfiles;
	}

	public LcProfile addLcProfile(LcProfile lcProfile) {
		getLcProfiles().add(lcProfile);
		lcProfile.setLcCity(this);

		return lcProfile;
	}

	public LcProfile removeLcProfile(LcProfile lcProfile) {
		getLcProfiles().remove(lcProfile);
		lcProfile.setLcCity(null);

		return lcProfile;
	}

}