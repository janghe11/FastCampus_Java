package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.OrderInfo;
import net.thjang.blog.stickermall.domain.OrderStatus;
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
public class OrderStatusRepositoryTests {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    // 확인 필요
    @Test
	public void OrderInfo를전체가져오기() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<OrderStatus> orderStatuses = orderStatusRepository.findAllByName("결제 확인", pageable);

        Assert.assertNotNull(orderStatuses);
        for (OrderStatus orderStatus : orderStatuses) {
            System.out.println(orderStatus.getId() + orderStatus.getName());
        }
    }
}
