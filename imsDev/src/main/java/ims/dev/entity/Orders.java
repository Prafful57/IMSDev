package ims.dev.entity;
import java.sql.Date;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import ims.dev.entity.Products;


@Data
@AllArgsConstructor
@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int OrderId;
	
//	private int product_id;
	private int supplierId;
	
	@CreationTimestamp
	@Column(nullable=false,updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	private int orderQuantity;
	private String orderStatus;
	
	@CreatedBy
	private String createdBy="System user 1";
	
	@LastModifiedBy
	private String updatedBy="System user 3";
	Orders(){}
	
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Products> products;
	

		
}
