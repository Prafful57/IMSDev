package ims.dev.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
@Entity
@Table
public class Transctions {

	@Id
	int transction_id;
	
	private int product_id;
	private String trancstion_type;
	private Date transction_date;
	
}
