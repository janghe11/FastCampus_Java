package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.ExpireType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpireTypeRepository extends JpaRepository<ExpireType, Long> {
    // 모든 만료 타입 조회
    List<ExpireType> findAll();

    // 이름별 만료 타입 검색
    @Query(value = "SELECT expireType FROM ExpireType expireType WHERE expireType.name LIKE CONCAT('%', :name, '%')")
    Page<ExpireType> findAllByName(@Param("name") String name, Pageable pageable);

    // coupon의 만료 타입 생성
    // coupon의 만료 타입 삭제
}
