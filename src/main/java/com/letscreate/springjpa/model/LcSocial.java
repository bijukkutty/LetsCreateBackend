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
 * The persistent class for the lc_social database table.
 * 
 */
@Entity
@Table(name="lc_social")
@NamedQuery(name="LcSocial.findAll", query="SELECT l FROM LcSocial l")
public class LcSocial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_social_id")
	private Integer lcSocialId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_social_key")
	private String lcSocialKey;

	@Column(name="lc_social_value")
	private String lcSocialValue;

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

	public LcSocial() {
	}

	public Integer getLcSocialId() {
		return this.lcSocialId;
	}

	public void setLcSocialId(Integer lcSocialId) {
		this.lcSocialId = lcSocialId;
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

	public String getLcSocialKey() {
		return this.lcSocialKey;
	}

	public void setLcSocialKey(String lcSocialKey) {
		this.lcSocialKey = lcSocialKey;
	}

	public String getLcSocialValue() {
		return this.lcSocialValue;
	}

	public void setLcSocialValue(String lcSocialValue) {
		this.lcSocialValue = lcSocialValue;
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