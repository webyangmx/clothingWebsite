package org.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private String goodsName;
	private Integer goodsPrice;
	private String goodsImage;
	private Integer categoryId;
	private Integer isNew;
	private Set shopcars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(String goodsName, Integer goodsPrice, String goodsImage,
			Integer categoryId) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsImage = goodsImage;
		this.categoryId = categoryId;
	}

	/** full constructor */
	public Goods(String goodsName, Integer goodsPrice, String goodsImage,
			Integer categoryId, Integer isNew, Set shopcars) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsImage = goodsImage;
		this.categoryId = categoryId;
		this.isNew = isNew;
		this.shopcars = shopcars;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Set getShopcars() {
		return this.shopcars;
	}

	public void setShopcars(Set shopcars) {
		this.shopcars = shopcars;
	}

}