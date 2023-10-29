package ims.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
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
}
