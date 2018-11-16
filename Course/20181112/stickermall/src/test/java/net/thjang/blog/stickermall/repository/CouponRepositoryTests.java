package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Coupon;
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

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CouponRepositoryTests {
    @Autowired
    private CouponRepository couponRepository;

    @Test
	public void Coupon목록All가져오기() {
        List<Coupon> coupons = couponRepository.findAll();

        Assert.assertNotNull(coupons);
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getId() + " " + coupon.getName());
        }
    }

    @Test
    public void Coupon목록Name으로검색해서최근Date순으로정렬() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Coupon> coupons = couponRepository.findAllByNameOrderByRegDateDesc("신규", pageable);

        Assert.assertNotNull(coupons);
        for (Coupon coupon : coupons) {
            System.out.println(coupon.getId() + " " + coupon.getName());
        }
    }
}
