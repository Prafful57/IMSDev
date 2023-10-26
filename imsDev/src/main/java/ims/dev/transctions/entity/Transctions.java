package ims.dev.transctions.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Transctions {

	@Id
	int transction_id;
	int product_id;
	String trancstion_type;
	Date transction_date;
	
	
	public Transctions(int transction_id, int product_id, String trancstion_type, Date transction_date) {
		super();
		this.transction_id = transction_id;
		this.product_id = product_id;
		this.trancstion_type = trancstion_type;
		this.transction_date = transction_date;
	}
	
	
	public int getTransction_id() {
		return transction_id;
	}
	public void setTransction_id(int transction_id) {
		this.transction_id = transction_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getTrancstion_type() {
		return trancstion_type;
	}
	public void setTrancstion_type(String trancstion_type) {
		this.trancstion_type = trancstion_type;
	}
	public Date getTransction_date() {
		return transction_date;
	}
	public void setTransction_date(Date transction_date) {
		this.transction_date = transction_date;
	}
	
	
	@Override
	public String toString() {
		return "Transctions [transction_id=" + transction_id + ", product_id=" + product_id + ", trancstion_type="
				+ trancstion_type + ", transction_date=" + transction_date + "]";
	}
	
	
	
	
}
