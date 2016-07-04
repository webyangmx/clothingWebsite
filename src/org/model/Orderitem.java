package org.model;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer orderitemId;
	private Integer orderId;
	private Integer goodsId;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */
	public Orderitem(Integer orderId, Integer goodsId) {
		this.orderId = orderId;
		this.goodsId = goodsId;
	}

	// Property accessors

	public Integer getOrderitemId() {
		return this.orderitemId;
	}

	public void setOrderitemId(Integer orderitemId) {
		this.orderitemId = orderitemId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

}