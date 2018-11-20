package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.MemberGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberGradeRepository extends JpaRepository<MemberGrade, Long> {
    // name 별 구매자 등급 조회
    MemberGrade findByName(String name, Pageable pageable);

    // 구매자 등급 등록
    // name 기준 구매자 등급 혜택 수정(절대 값, 상대 값)
    // 구매자 등급 삭제

}
