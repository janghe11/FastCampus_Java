package net.thjang.blog.stickermall.service;

import net.thjang.blog.stickermall.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductServiceTests {
    @Autowired
    private ProductService productService;

    @Test
    public void product전부다가져오기() {
        List<Product> products = productService.showAllProducts();

        Assert.assertNotNull(products);
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
    }

    @Test
    public void product를CategoryId로검색() {
        Page<Product> products = productService.searchAllProductsByCategoryId(1L, 0);

        Assert.assertNotNull(products);
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
    }
}
