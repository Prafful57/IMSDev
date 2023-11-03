package ims.dev.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
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
	
	@CreationTimestamp
	@Column(nullable=false,updatable = false)
	private Date created_at;
	
	@UpdateTimestamp
	private Date updated_at;
	private int order_quantity;
	private String order_status;
	
	@CreatedBy
	private String created_by="System user 1";
	
	@LastModifiedBy
	private String updated_by="System user 2";
	Orders(){}
	
		
}
