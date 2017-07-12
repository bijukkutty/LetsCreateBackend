package com.letscreate.springjpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lc_sub_categories database table.
 * 
 */
@Entity
@Table(name="lc_sub_categories")
@NamedQuery(name="LcSubCategory.findAll", query="SELECT l FROM LcSubCategory l")
public class LcSubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lc_sub_category_id")
	private Integer lcSubCategoryId;

	@Column(name="lc_sub_category_name")
	private String lcSubCategoryName;

	//bi-directional many-to-one association to LcProfileContibsXref
	@OneToMany(mappedBy="lcSubCategory")
	private List<LcProfileContibsXref> lcProfileContibsXrefs;

	//bi-directional many-to-one association to LcProfileInterestsXref
	@OneToMany(mappedBy="lcSubCategory")
	private List<LcProfileInterestsXref> lcProfileInterestsXrefs;

	//bi-directional many-to-one association to LcCategory
	@ManyToOne
	@JoinColumn(name="lc_categories_lc_category_id")
	private LcCategory lcCategory;

	public LcSubCategory() {
	}

	public Integer getLcSubCategoryId() {
		return this.lcSubCategoryId;
	}

	public void setLcSubCategoryId(Integer lcSubCategoryId) {
		this.lcSubCategoryId = lcSubCategoryId;
	}

	public String getLcSubCategoryName() {
		return this.lcSubCategoryName;
	}

	public void setLcSubCategoryName(String lcSubCategoryName) {
		this.lcSubCategoryName = lcSubCategoryName;
	}

	public List<LcProfileContibsXref> getLcProfileContibsXrefs() {
		return this.lcProfileContibsXrefs;
	}

	public void setLcProfileContibsXrefs(List<LcProfileContibsXref> lcProfileContibsXrefs) {
		this.lcProfileContibsXrefs = lcProfileContibsXrefs;
	}

	public LcProfileContibsXref addLcProfileContibsXref(LcProfileContibsXref lcProfileContibsXref) {
		getLcProfileContibsXrefs().add(lcProfileContibsXref);
		lcProfileContibsXref.setLcSubCategory(this);

		return lcProfileContibsXref;
	}

	public LcProfileContibsXref removeLcProfileContibsXref(LcProfileContibsXref lcProfileContibsXref) {
		getLcProfileContibsXrefs().remove(lcProfileContibsXref);
		lcProfileContibsXref.setLcSubCategory(null);

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
		lcProfileInterestsXref.setLcSubCategory(this);

		return lcProfileInterestsXref;
	}

	public LcProfileInterestsXref removeLcProfileInterestsXref(LcProfileInterestsXref lcProfileInterestsXref) {
		getLcProfileInterestsXrefs().remove(lcProfileInterestsXref);
		lcProfileInterestsXref.setLcSubCategory(null);

		return lcProfileInterestsXref;
	}

	public LcCategory getLcCategory() {
		return this.lcCategory;
	}

	public void setLcCategory(LcCategory lcCategory) {
		this.lcCategory = lcCategory;
	}

}