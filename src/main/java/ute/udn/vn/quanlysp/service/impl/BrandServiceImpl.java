package ute.udn.vn.quanlysp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ute.udn.vn.quanlysp.entity.Brand;
import ute.udn.vn.quanlysp.entity.Product;
import ute.udn.vn.quanlysp.repository.BrandRepository;
import ute.udn.vn.quanlysp.service.BrandService;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        brandRepository.save(brand);
        return brand;
    }

    @Override
    public Optional<Brand> findBrandById(Integer id) {
        return brandRepository.findById(id);
    }


}