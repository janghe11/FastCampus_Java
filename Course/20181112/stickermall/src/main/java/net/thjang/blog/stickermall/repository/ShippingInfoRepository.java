package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.ShippingInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {
    // id를 기준으로 배송 정보 조회
     ShippingInfo findById(Long id, Pageable pageable);

    // 배송정보 등록

    // 배송정보 수정(주문 상태가 배송중 부터는 수정을 할 수 없음)

}
