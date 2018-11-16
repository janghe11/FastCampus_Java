package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.CartProduct;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CartProductRepositoryTests {
    @Autowired
    private CartProductRepository cartProductRepository;

    @Test
	public void CartProduct목록All가져오기() {
        List<CartProduct> cartProducts = cartProductRepository.findAll();

        Assert.assertNotNull(cartProducts);
        for (CartProduct cartProduct : cartProducts) {
            System.out.println(cartProduct.getId() + " " + cartProduct.getMember().getId());
        }
	}

}
