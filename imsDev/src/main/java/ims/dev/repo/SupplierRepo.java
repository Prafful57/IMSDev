package ims.dev.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import ims.dev.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}
