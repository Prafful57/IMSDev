package ims.dev.brands.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Brands {

	@Id
	int brand_id;
	String brand_name;
	
	
	public Brands(int brand_id, String brand_name) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
	}
	
	
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}


	@Override
	public String toString() {
		return "Brands [brand_id=" + brand_id + ", brand_name=" + brand_name + "]";
	}
	
	
	
}
