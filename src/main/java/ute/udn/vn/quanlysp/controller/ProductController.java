package ute.udn.vn.quanlysp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ute.udn.vn.quanlysp.entity.Category;
import ute.udn.vn.quanlysp.entity.Product;
import ute.udn.vn.quanlysp.repository.CategoryRepository;
import ute.udn.vn.quanlysp.repository.ProductRepository;
import ute.udn.vn.quanlysp.service.CategoryService;
import ute.udn.vn.quanlysp.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {
//    @Value("${upload.path}")
//    private String fileUpload;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        List<Category> listCategories = categoryService.getAllCategory();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);
        return "product_form";
    }
    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute("product")Product product,
                              @RequestParam("imageProduct")MultipartFile imageProduct,
                              RedirectAttributes attributes, HttpServletRequest request){
        String[] detailIDs = request.getParameterValues("detailID");
        String[] detailNames = request.getParameterValues("detailName");
        String[] detailValues = request.getParameterValues("detailValue");
        for (int i = 0; i< detailNames.length;i++){
            if(detailIDs != null && detailIDs.length > 0 ){
                product.setDetail(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
            }else {
                product.addDetails(detailNames[i], detailValues[i]);
            }
        }
        try {
            productService.saveProduct(imageProduct, product);
            attributes.addFlashAttribute("success", "Add successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Failed to add");
        }
        return "redirect:/products";
    }
    @GetMapping("/products")
    public String listProduct(Model model){
        List<Product> listProducts = productService.getAllProduct();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }
    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model){
        Product product = productService.findProductById(id).get();
        model.addAttribute("product", product);

        List<Category> listCategories = categoryService.getAllCategory();
        model.addAttribute("listCategories", listCategories);
        return "product_form";
    }
    @GetMapping("/products/delete/{id}")
    public String DeleteProduct(@PathVariable("id") Integer id, Model model){
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
