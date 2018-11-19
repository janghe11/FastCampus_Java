package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.ExpireType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ExpireTypeRepositoryTests {
    @Autowired
    private ExpireTypeRepository expireTypeRepository;

    @Test
	public void Coupon목록All가져오기() {
        List<ExpireType> expireTypeList = expireTypeRepository.findAll();

        Assert.assertNotNull(expireTypeList);
        for (ExpireType expireType : expireTypeList) {
            System.out.println(expireType.getId() + " " + expireType.getName());
        }
    }

    @Test
    public void Coupon목록Name으로검색해서최근Date순으로정렬() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<ExpireType> expireTypeList = expireTypeRepository.findAllByName("장태희", pageable);

        Assert.assertNotNull(expireTypeList);
        for (ExpireType expireType : expireTypeList) {
            System.out.println(expireType.getId() + " " + expireType.getName());
        }
    }
}
