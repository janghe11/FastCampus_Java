package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    // coupon 목록 이름별 검색해서 최근 등록일 순으로 정렬하기
    Page<Coupon> findAllByNameAndOrderByRegDateDesc(String name, Pageable pageable);

    // coupon 목록 할인값(절대값)별 조회하기
    Page<Coupon> findAllBySaleMoney(int saleMoney, Pageable pageable);

    // coupon 목록 할인율(상대값)별 조회하기
    Page<Coupon> findAllBySaleRatio(double saleRatio, Pageable pageable);

    // coupon 생성(등록)하기

    // coupon 정보 수정하기

    // coupon 삭제하기(Name의 중복 등록을 허용했기 때문에 id별로 삭제)
    void deleteCouponById(Coupon coupon);
}
