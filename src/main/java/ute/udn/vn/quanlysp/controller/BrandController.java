package ute.udn.vn.quanlysp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ute.udn.vn.quanlysp.entity.Brand;
import ute.udn.vn.quanlysp.entity.Category;
import ute.udn.vn.quanlysp.repository.BrandRepository;
import ute.udn.vn.quanlysp.repository.CategoryRepository;
import ute.udn.vn.quanlysp.service.BrandService;
import ute.udn.vn.quanlysp.service.CategoryService;

import java.util.List;


@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model){
        List<Category> listCategories = categoryService.getAllCategory();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());

        return "brand_form";
    }
    @PostMapping("/brands/save")
    public String saveBrand(Brand brand){
        brandService.saveBrand(brand);
        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String listBrands(Model model){
        List<Brand> listBrands = brandService.getAllBrand();
        model.addAttribute("listBrands", listBrands);
        return "brands";
    }
    @GetMapping("/brands/edit/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model){
        List<Category> listCategories = categoryService.getAllCategory();
        Brand brand = brandService.findBrandById(id).get();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);

        return "brand_form";
    }
//    @GetMapping("/brands/delete/{id}")
//    public String DeleteBrand(@PathVariable("id") Integer id, Model model){
//        brandRepository.deleteById(id);
//        return "redirect:/brands";
//    }
}
