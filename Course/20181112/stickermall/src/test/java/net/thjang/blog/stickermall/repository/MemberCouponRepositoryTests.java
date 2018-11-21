package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.ExpireType;
import net.thjang.blog.stickermall.domain.MemberCoupon;
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
public class MemberCouponRepositoryTests {
    @Autowired
    private MemberCouponRepository memberCouponRepository;

//    @Test
//	public void MemberCoupon을Id로가져오기() {
//        Pageable pageable = PageRequest.of(0, 5);
//        Page<MemberCoupon> memberCoupons = memberCouponRepository.findById(1L, pageable);
//
//        Assert.assertNotNull(memberCoupons);
//        for (MemberCoupon memberCoupon : memberCoupons) {
//            System.out.println(memberCoupon.getMember().getUserName() + " " + memberCoupon.getCoupon().getName());
//        }
//    }

    //Failed
    @Test
    public void Member검색으로만료일이얼마안남은순으로정렬() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<MemberCoupon> memberCoupons = memberCouponRepository.findAllByMemberOrderByExpireDateAsc("jang", pageable);

        Assert.assertNotNull(memberCoupons);
        for (MemberCoupon memberCoupon : memberCoupons) {
            System.out.println(memberCoupon.getMember().getUserName() + " " + memberCoupon.getCoupon().getName());
        }
    }

    //Failed
    @Test
    public void Coupon검색으로만료일이얼마안남은순으로정렬() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<MemberCoupon> memberCoupons = memberCouponRepository.findAllByCouponOrderByExpireDateAsc(1L, pageable);

        Assert.assertNotNull(memberCoupons);
        for (MemberCoupon memberCoupon : memberCoupons) {
            System.out.println(memberCoupon.getMember().getUserName() + " " + memberCoupon.getCoupon().getName());
        }
    }
}
