package com.letscreate.springjpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the lc_contribution database table.
 * 
 */
@Entity
@Table(name="lc_contribution")
@NamedQuery(name="LcContribution.findAll", query="SELECT l FROM LcContribution l")
public class LcContribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_contribution_id")
	private Integer lcContributionId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to LcProfile
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="lc_profile_id")
	private LcProfile lcProfile;

	public LcContribution() {
	}

	public Integer getLcContributionId() {
		return this.lcContributionId;
	}

	public void setLcContributionId(Integer lcContributionId) {
		this.lcContributionId = lcContributionId;
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

	public LcProfile getLcProfile() {
		return this.lcProfile;
	}

	public void setLcProfile(LcProfile lcProfile) {
		this.lcProfile = lcProfile;
	}

}