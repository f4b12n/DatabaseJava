package co.com.ps.C23A.repository;

import co.com.ps.C23A.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByCategoryName(String name);
}
