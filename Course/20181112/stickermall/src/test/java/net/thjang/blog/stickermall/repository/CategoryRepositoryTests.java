package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
	public void Category목록All가져오기() {
        List<Category> categories = categoryRepository.findAll();

        Assert.assertNotNull(categories);
        for (Category category : categories) {
            System.out.println(category.getId() + " " + category.getName());
        }
    }

    // 특정 상품이 속한 카테고리들 보여주기
}
