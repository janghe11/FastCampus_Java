package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Category;
import net.thjang.blog.stickermall.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // 상품 name으로 조회
    Page<Product> findAllByNameAndOrderByIdDesc(String name, Pageable pageable);

    // 상품 category로 조회
    Page<Product> findAllByCategoryListAndOrderByIdDesc(Category category, Pageable pageable);

    // 상품 가격대별 조회

    // 상품 등록

    // 상품은 해당 id가 한번 부여되면 이름, 가격 등이 수정되어도 같은 상품으로 간주한다.
    // 근거 : 옥션에서 상품명 및 가격 수정 테스트, AliExpress
    // 상품 정보 수정(이름, 가격, 총 수량, 마일리지)

    // 상품 삭제
}
