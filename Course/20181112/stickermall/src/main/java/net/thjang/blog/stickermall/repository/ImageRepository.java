package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
    // Image 가져오기(Download)

    // Image 등록(업로드)

    // Image 삭제
}
