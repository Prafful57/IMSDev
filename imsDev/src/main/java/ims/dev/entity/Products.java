package ims.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Products {

	@Id
	@GeneratedValue
	int product_id;
	private int brand_id;
	private int supplier_id;
	private String catagory;
	private String sub_catagory;
	private String product_name;
	private double price;
	private String product_details;
	private int total_stock;
	

	
	
	public Products() {}
	
	public Products(int product_id, String product_name, String catagory, String sub_catagory, int brand_id,
			double price, String product_details, int total_stock, int supplier_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.catagory = catagory;
		this.sub_catagory = sub_catagory;
		this.brand_id = brand_id;
		this.price = price;
		this.product_details = product_details;
		this.total_stock = total_stock;
		this.supplier_id = supplier_id;
	}

	
	
	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getSub_catagory() {
		return sub_catagory;
	}

	public void setSub_catagory(String sub_catagory) {
		this.sub_catagory = sub_catagory;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduct_details() {
		return product_details;
	}

	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}

	public int getTotal_stock() {
		return total_stock;
	}

	public void setTotal_stock(int total_stock) {
		this.total_stock = total_stock;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}



	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", catagory=" + catagory
				+ ", sub_catagory=" + sub_catagory + ", brand_id=" + brand_id + ", price=" + price
				+ ", product_details=" + product_details + ", total_stock=" + total_stock + ", supplier_id="
				+ supplier_id + "]";
	}
	
	
	
	
}
