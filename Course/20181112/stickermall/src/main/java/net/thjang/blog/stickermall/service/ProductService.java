package net.thjang.blog.stickermall.service;

import net.thjang.blog.stickermall.domain.Category;
import net.thjang.blog.stickermall.domain.Product;
import net.thjang.blog.stickermall.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<Product> searchAllProductsByCategoryId(Long id, Integer currentPage) {
        if (currentPage == null) {
            currentPage = 0;
        }
        Pageable pageable = PageRequest.of(currentPage, 10);
        Category category = new Category();
        category.setId(id);
        return productRepository.findAllByCategoryIdOrderByIdDesc(category, pageable);
    }

}
