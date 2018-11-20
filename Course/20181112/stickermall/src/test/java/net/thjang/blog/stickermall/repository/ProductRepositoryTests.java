package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Category;
import net.thjang.blog.stickermall.domain.OrderInfo;
import net.thjang.blog.stickermall.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
	public void Product를CategoryId로검색하기() {
        Pageable pageable = PageRequest.of(0, 5);
        Category category = new Category();
        category.setId(1L);
        Page<Product> products = productRepository.findAllByCategoryIdOrderByIdDesc(category, pageable);

        Assert.assertNotNull(products);
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
    }
}
