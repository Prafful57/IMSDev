package ims.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Supplier {

	@Id
	int supplier_id;
	private String supplier_name;
	private int contact;
	
	public Supplier(int supplier_id, String supplier_name, int contact) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
		this.contact = contact;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", contact=" + contact
				+ "]";
	}
	
	
	
}
