package ute.udn.vn.quanlysp.service;

import ute.udn.vn.quanlysp.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> getAllBrand();

    Brand saveBrand(Brand brand);

    Optional<Brand> findBrandById(Integer id);
}
