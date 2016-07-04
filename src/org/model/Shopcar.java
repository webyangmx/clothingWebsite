package org.model;

/**
 * Shopcar entity. @author MyEclipse Persistence Tools
 */

public class Shopcar implements java.io.Serializable {

	// Fields

	private Integer shopcarId;
	private User user;
	private Goods goods;

	// Constructors

	/** default constructor */
	public Shopcar() {
	}

	/** minimal constructor */
	public Shopcar(User user) {
		this.user = user;
	}

	/** full constructor */
	public Shopcar(User user, Goods goods) {
		this.user = user;
		this.goods = goods;
	}

	// Property accessors

	public Integer getShopcarId() {
		return this.shopcarId;
	}

	public void setShopcarId(Integer shopcarId) {
		this.shopcarId = shopcarId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}