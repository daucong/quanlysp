package ute.udn.vn.quanlysp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ute.udn.vn.quanlysp.entity.Category;
import ute.udn.vn.quanlysp.entity.User;
import ute.udn.vn.quanlysp.repository.CategoryRepository;
import ute.udn.vn.quanlysp.repository.UserRepository;
import ute.udn.vn.quanlysp.service.CategoryService;
import ute.udn.vn.quanlysp.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }


    @Override
    public Optional<Category> findCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
}