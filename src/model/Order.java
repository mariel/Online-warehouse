package model;

import java.io.Serializable;



public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int quantity;
	private int Customer_id;
	private int Product_id;
	
	public Order(int id, int quantity,int Customer_id,int Product_id){
		super();
		this.setId(id);
		this.setQuantity(quantity);
		this.setCustomer_id(Customer_id);
		this.setProduct_id(Product_id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}

	public int getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}
	
	
	
}