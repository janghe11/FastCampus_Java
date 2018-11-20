package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    // CartProduct의 목록 가져오기
    // CartProduct에 상품 넣기(Product, 수량)
    // CartProduct에 있는 기존 상품에 수량 변경하기
    // CartProduct에 있는 상품 제거하기

}
