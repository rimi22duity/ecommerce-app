package net.ecommerce.backend.ecommerce.repository;

import net.ecommerce.backend.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author duity
 * @since 4/28/24
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Page<Product> findByTitleIgnoringCase(String title, Pageable pageable);
}
