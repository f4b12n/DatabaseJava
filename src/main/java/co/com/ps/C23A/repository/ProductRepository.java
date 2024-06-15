package co.com.ps.C23A.repository;

import co.com.ps.C23A.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {
    Optional<Products> findByProductName(String name);
}
