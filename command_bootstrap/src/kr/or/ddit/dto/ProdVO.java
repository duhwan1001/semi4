package kr.or.ddit.dto;

import java.util.Date;

public class ProdVO {
	
	private int prodId 			;//ID
	private String prodImg 		;//이미지
	private String prodName 	;//이름
	private int    prodCost 	;//가격
	private String prodDesc 	;//설명
	private String prodSize 	;//사이즈
	private String prodClass 	;//제품 카테고리 구분(상,하의,신발)
	private String prodWho 		;//제품 착용자 구분(남,녀,유아)
	private int    prodQty 		;//수량
	private Date   prodRegdate 	;//게시날짜
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdImg() {
		return prodImg;
	}
	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdCost() {
		return prodCost;
	}
	public void setProdCost(int prodCost) {
		this.prodCost = prodCost;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getProdSize() {
		return prodSize;
	}
	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}
	public String getProdClass() {
		return prodClass;
	}
	public void setProdClass(String prodClass) {
		this.prodClass = prodClass;
	}
	public String getProdWho() {
		return prodWho;
	}
	public void setProdWho(String prodWho) {
		this.prodWho = prodWho;
	}
	public int getProdQty() {
		return prodQty;
	}
	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}
	public Date getProdRegdate() {
		return prodRegdate;
	}
	public void setProdRegdate(Date prodRegdate) {
		this.prodRegdate = prodRegdate;
	}
	
	

	
}
