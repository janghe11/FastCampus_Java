package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 기존 Category 가져와서 보여주기
    List<Category> findAll();

    // 새 Category 생성(삽입)하기

    // Category명 수정하기

    // Category 삭제하기
    void deleteByName(Category category);
}
