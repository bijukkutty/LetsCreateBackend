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
 * The persistent class for the lc_portfolio database table.
 * 
 */
@Entity
@Table(name="lc_portfolio")
@NamedQuery(name="LcPortfolio.findAll", query="SELECT l FROM LcPortfolio l")
public class LcPortfolio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_portfolio_id")
	private Integer lcPortfolioId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_portfolio_key")
	private String lcPortfolioKey;

	@Column(name="lc_portfolio_value")
	private String lcPortfolioValue;

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

	public LcPortfolio() {
	}

	public Integer getLcPortfolioId() {
		return this.lcPortfolioId;
	}

	public void setLcPortfolioId(Integer lcPortfolioId) {
		this.lcPortfolioId = lcPortfolioId;
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

	public String getLcPortfolioKey() {
		return this.lcPortfolioKey;
	}

	public void setLcPortfolioKey(String lcPortfolioKey) {
		this.lcPortfolioKey = lcPortfolioKey;
	}

	public String getLcPortfolioValue() {
		return this.lcPortfolioValue;
	}

	public void setLcPortfolioValue(String lcPortfolioValue) {
		this.lcPortfolioValue = lcPortfolioValue;
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