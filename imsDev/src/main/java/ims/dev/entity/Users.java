package ims.dev.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table
public class Users {

	@Id
	int user_id;
	
	private String user_name;
	private String user_pass;
	private String user_role;
	
}
