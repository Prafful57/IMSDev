package ims.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table
public class Supplier {

	@Id
	@GeneratedValue
	int supplier_id;
	private String supplier_name;
	private String contact;
	
	public Supplier() {}
		
}
