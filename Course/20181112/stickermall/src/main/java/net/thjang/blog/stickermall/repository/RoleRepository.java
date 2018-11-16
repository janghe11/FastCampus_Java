package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // 권한 전체 조회
    List<Role> findAll();

    // name으로 권한 검색
    Page<Role> findAllByNameContaining(String name);

    // 권한 name 수정

    // 권한 삭제
    void deleteById(Long id);
}
