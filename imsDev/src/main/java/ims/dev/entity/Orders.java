package ims.dev.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Orders {

	@Id
	int order_id;
	int product_id;
	int supplier_id;
	Date order_date;
	int order_quantity;
	String order_Status;
	
	
	
	public Orders(int order_id, int product_id, int supplier_id, Date order_date, int order_quantity,
			String order_Status) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.supplier_id = supplier_id;
		this.order_date = order_date;
		this.order_quantity = order_quantity;
		this.order_Status = order_Status;
	}
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public String getOrder_Status() {
		return order_Status;
	}
	public void setOrder_Status(String order_Status) {
		this.order_Status = order_Status;
	}
	
	
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", product_id=" + product_id + ", supplier_id=" + supplier_id
				+ ", order_date=" + order_date + ", order_quantity=" + order_quantity + ", order_Status=" + order_Status
				+ "]";
	}
	
	
	
}
