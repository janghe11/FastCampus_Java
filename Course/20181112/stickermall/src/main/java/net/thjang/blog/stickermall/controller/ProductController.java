package net.thjang.blog.stickermall.controller;

import net.thjang.blog.stickermall.domain.Product;
import net.thjang.blog.stickermall.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String showProducts(@RequestParam(name = "category", required = false) Long category,
                               @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                               ModelMap modelMap) {
        if (category == null) {
            List<Product> products = productService.showAllProducts();
            modelMap.addAttribute("products", products);
        } else {
            Page<Product> products = productService.searchAllProductsByCategoryId(category, page);
            modelMap.addAttribute(products);
        }

        return "product/products";
    }
}
