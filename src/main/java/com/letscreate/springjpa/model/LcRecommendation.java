package com.letscreate.springjpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the lc_recommendations database table.
 * 
 */
@Entity
@Table(name="lc_recommendations")
@NamedQuery(name="LcRecommendation.findAll", query="SELECT l FROM LcRecommendation l")
public class LcRecommendation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lc_recommendation_id")
	private Integer lcRecommendationId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	@Column(name="lc_recommendation_text")
	private String lcRecommendationText;

	@Temporal(TemporalType.DATE)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to LcProfile
	@ManyToOne
	@JoinColumn(name="lc_profile_lc_profile_id")
	private LcProfile lcProfile;

	public LcRecommendation() {
	}

	public Integer getLcRecommendationId() {
		return this.lcRecommendationId;
	}

	public void setLcRecommendationId(Integer lcRecommendationId) {
		this.lcRecommendationId = lcRecommendationId;
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

	public String getLcRecommendationText() {
		return this.lcRecommendationText;
	}

	public void setLcRecommendationText(String lcRecommendationText) {
		this.lcRecommendationText = lcRecommendationText;
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