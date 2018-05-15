package de.hska.iwi.vslab.product.productservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;

	@Column(name = "PRODUCT_NAME")
	private String name;

	@Column(name = "PRODUCT_PRICE")
	private Integer price;

	@Column(name = "PRODUCT_CATEGORYID")
	private Integer categoryId;

	@Column(name = "PRODUCT_DETAILS")
	private String details;

	public Product(){}
			
	public Product(Long id, String name, Integer price, Integer categoryId, String details) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}