package ims.dev.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ims.dev.entity.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer> {

//	List<Products> findByOrderId(int orderId);

}
