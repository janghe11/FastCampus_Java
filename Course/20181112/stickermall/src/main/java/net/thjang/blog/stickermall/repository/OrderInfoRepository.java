package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Member;
import net.thjang.blog.stickermall.domain.OrderInfo;
import net.thjang.blog.stickermall.domain.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
    // Member id && 주문 일자별 최근 순으로 정렬해서 주문 정보 가져오기(List)
    @Query(value = "SELECT orderInfo FROM OrderInfo orderInfo WHERE orderInfo.member = :memberId ORDER BY orderInfo.orderDate DESC")
    Page<OrderInfo> findAllByMemberIdOrderByOrderDateDesc(@Param("memberId") String memberId, Pageable pageable);

    // 관리자 - 주문 상태별로 검색해서 가져오기
    @Query(value = "SELECT orderInfo FROM OrderInfo orderInfo WHERE orderInfo.orderStatus = :orderStatusId ORDER BY orderInfo.orderDate DESC")
    Page<OrderInfo> findAllByOrderStatusOrderByOrderDateDesc(@Param("orderStatusId") Long OrderStatusId, Pageable pageable);

    // 주문 정보 생성하기
    // 주문 정보 진행 상태 변경
    // 주문 정보 삭제

}
