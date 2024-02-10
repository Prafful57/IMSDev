package ims.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplierId;
	private String supplierName;
	private String contact;
	
	public Supplier() {}
		
}
