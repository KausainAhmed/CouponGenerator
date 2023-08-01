package com.ahmed.cnp.model;

import java.math.BigDecimal;

public class Product {

	private String name;
	private String discription;
	private BigDecimal price;
	private String couponcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", discription=" + discription + ", price=" + price + ", couponcode="
				+ couponcode + "]";
	}

}
