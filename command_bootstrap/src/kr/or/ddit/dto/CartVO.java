package kr.or.ddit.dto;

public class CartVO {
	private int cart_no;
	private String user_id; 
	private int prod_id; // 상품 ID
	private int prod_qty; // 고객이 고른 수량
	private String prod_img;
	private String prod_name;
	private int prod_cost;
	 
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public int getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	@Override
	public String toString() {
		return "CartVO [cart_no=" + cart_no + ", user_id=" + user_id + ", prod_id=" + prod_id + ", prod_qty=" + prod_qty
				+ ", prod_img=" + prod_img + ", prod_name=" + prod_name + ", prod_cost=" + prod_cost + "]";
	}
	
	

}
