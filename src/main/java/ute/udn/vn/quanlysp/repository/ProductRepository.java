package ute.udn.vn.quanlysp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ute.udn.vn.quanlysp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
