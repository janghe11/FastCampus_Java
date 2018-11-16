package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    // 주문 진행 상태 전체 조회
    List<OrderStatus> findAll();

    // 주문 진행 상태 name으로 조회
    Page<OrderStatus> findAllByName(String name, Pageable pageable);

    // 주문 진행 상태명 등록
    // 주문 진행 상태명 수정
    // 주문 진행 상태명 삭제
}
