package net.thjang.blog.stickermall.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CouponRepositoryTests {
    @Autowired
    private CouponRepository couponRepository;

    @Test
	public void Coupon목록All가져오기() {

    }
}
