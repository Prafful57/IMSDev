package ims.dev.entity;

import java.sql.Date;


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
public class Transctions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transctionId;
	
	private int productId;
	private String trancstionType;
	private Date transctionDate;
	
	Transctions(){}
	
}
