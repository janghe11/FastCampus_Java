package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Member 전체 조회
    List<Member> findAll();

    // Member id별로 조회
    Member findById(String id, Pageable pageable);

    // Member userName별로 조회
    Page<Member> findAllByUserName(String userName, Pageable pageable);

    // Member nickName별로 조회
    Member findByNickName(String nickName, Pageable pageable);

    // Member memberGrade별로 조회
//    @Query(value = "SELECT member FROM Member member WHERE member.memberGrade = :memberGradeId ORDER BY id")
//    Page<Member> findAllByMemberGradeOrderById(@Param("memberGradeId") Long memberGradeId, Pageable pageable);

    // Member zipCode별로 조회
    Page<Member> findAllByZipCode(int zipCode, Pageable pageable);

    // Member phone별로 조회
    Page<Member> findAllByPhone(String phone, Pageable pageable);

    // Member 회원가입
    // Member 로그인
    // Member 정보 수정
    // Member 탈퇴
}
