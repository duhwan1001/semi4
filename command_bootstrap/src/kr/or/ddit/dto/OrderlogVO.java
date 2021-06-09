package kr.or.ddit.dto;

import java.util.Date;

public class OrderlogVO {
	private String orderId;
	private String userId;
	private String prodId;
	private String orderStatus;
	private Date buyDate;
	private int prodQty;
	private String prodImg; 
	
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public int getProdQty() {
		return prodQty;
	}
	
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	
	
}
