package com.letscreate.springjpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the lc_categories database table.
 * 
 */
@Entity
@Table(name="lc_categories")
@NamedQuery(name="LcCategory.findAll", query="SELECT l FROM LcCategory l")
public class LcCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lc_category_id")
	private Integer lcCategoryId;

	@Column(name="lc_category_name")
	private String lcCategoryName;

	//bi-directional many-to-one association to LcSubCategory
	@JsonManagedReference(value="SubCategories")
	@OneToMany(mappedBy="lcCategory")
	private List<LcSubCategory> lcSubCategories;

	public LcCategory() {
	}

	public Integer getLcCategoryId() {
		return this.lcCategoryId;
	}

	public void setLcCategoryId(Integer lcCategoryId) {
		this.lcCategoryId = lcCategoryId;
	}

	public String getLcCategoryName() {
		return this.lcCategoryName;
	}

	public void setLcCategoryName(String lcCategoryName) {
		this.lcCategoryName = lcCategoryName;
	}

	public List<LcSubCategory> getLcSubCategories() {
		return this.lcSubCategories;
	}

	public void setLcSubCategories(List<LcSubCategory> lcSubCategories) {
		this.lcSubCategories = lcSubCategories;
	}

	public LcSubCategory addLcSubCategory(LcSubCategory lcSubCategory) {
		getLcSubCategories().add(lcSubCategory);
		lcSubCategory.setLcCategory(this);

		return lcSubCategory;
	}

	public LcSubCategory removeLcSubCategory(LcSubCategory lcSubCategory) {
		getLcSubCategories().remove(lcSubCategory);
		lcSubCategory.setLcCategory(null);

		return lcSubCategory;
	}

}