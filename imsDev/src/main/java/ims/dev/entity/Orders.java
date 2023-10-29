package ims.dev.entity;

import java.sql.Date;

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
public class Orders {

	@Id
	@GeneratedValue
	int order_id;
	
	private int product_id;
	private int supplier_id;
	private String order_date;
	private int order_quantity;
	private String order_status;
	
	Orders(){}
		
}
