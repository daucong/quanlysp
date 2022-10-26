package ute.udn.vn.quanlysp.service;


import ute.udn.vn.quanlysp.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();

    Category saveCategory(Category category);

    Optional<Category> findCategoryById(Integer id);
}
