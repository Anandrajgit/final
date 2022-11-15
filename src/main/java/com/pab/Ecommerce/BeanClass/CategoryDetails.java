package com.pab.Ecommerce.BeanClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_details")
public class CategoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cateId;
	private String cateName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateId() {
		return cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
}