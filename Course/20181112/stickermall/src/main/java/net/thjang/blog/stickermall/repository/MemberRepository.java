package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Member 전체 조회
    List<Member> findAll();

    // Member id별로 조회
    Page<Member> findById(String id);

    // Member userName별로 조회
    Page<Member> findAllByUserName(String userName);

    // Member nickName별로 조회
    Page<Member> findByNickName(String nickName);

    // Member zipCode별로 조회
    Page<Member> findAllByZipCode(int zipCode);

    // Member phone별로 조회
    Page<Member> findAllByPhone(String phone);

    // Member 회원가입

    // Member 로그인

    // Member 정보 수정

    // Member 탈퇴
    void deleteById(String id);
}
