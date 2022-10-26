package ute.udn.vn.quanlysp.service;

import org.springframework.web.multipart.MultipartFile;
import ute.udn.vn.quanlysp.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    Product saveProduct(MultipartFile imageProduct, Product product);

    void deleteProduct(Integer id);

    Optional<Product> findProductById(Integer id);
}
