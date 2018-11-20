package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Coupon;
import net.thjang.blog.stickermall.domain.Member;
import net.thjang.blog.stickermall.domain.MemberCoupon;
import net.thjang.blog.stickermall.domain.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {
    // id값 기준 쿠폰 조회(1건)
    MemberCoupon findById(Long id, Pageable pageable);

    // member id로 쿠폰 검색하여 쿠폰 만료일이 가장 얼마 안 남은 순으로 정렬
    @Query(value = "SELECT memberCoupon FROM MemberCoupon memberCoupon WHERE memberCoupon.member = :memberId ORDER BY memberCoupon.expireDate ASC")
    Page<MemberCoupon> findAllByMemberOrderByExpireDateAsc(@Param("memberId") String memberId, Pageable pageable);

    // coupon id로 쿠폰 검색하여 쿠폰 만료일이 가장 얼마 안 남은 순으로 정렬
    @Query(value = "SELECT memberCoupon FROM MemberCoupon memberCoupon WHERE memberCoupon.coupon = :couponId ORDER BY memberCoupon.expireDate ASC")
    Page<MemberCoupon> findAllByCouponOrderByExpireDateAsc(@Param("couponId") Long couponId, Pageable pageable);

    // orderInfo id로 쿠폰 검색하여 쿠폰 만료일이 가장 얼마 안 남은 순으로 정렬
    @Query(value = "SELECT memberCoupon FROM MemberCoupon memberCoupon WHERE memberCoupon.orderInfo = :orderInfoId ORDER BY memberCoupon.expireDate DESC")
    Page<MemberCoupon> findAllByOrderInfoOrderByExpireDateDesc(@Param("orderInfoId") Long orderInfoId, Pageable pageable);

    // 쿠폰 사용(orderInfo id와 usedCheck update 하기)
    // 쿠폰 삭제(멤버 id와 쿠폰 id 필요)
}
