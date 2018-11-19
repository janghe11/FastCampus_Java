package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Member;
import net.thjang.blog.stickermall.domain.OrderInfo;
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
public class OrderInfoRepositoryTests {
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Test
	public void OrderInfo를전체가져오기() {
        Pageable pageable = PageRequest.of(0, 5);
        List<OrderInfo> orderInfos = orderInfoRepository.findAll();

        Assert.assertNotNull(orderInfos);
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo.getMember().getUserName() + " " + orderInfo.getTotalPrice());
        }
    }

    @Test
    public void OrderInfo를MemberId로검색() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<OrderInfo> orderInfos = orderInfoRepository.findAllByMemberIdOrderByOrderDateDesc("jang", pageable);

        Assert.assertNotNull(orderInfos);
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo.getMember().getUserName() + " " + orderInfo.getTotalPrice());
        }
    }

    @Test
    public void OrderInfo를OrderStatusId로검색() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<OrderInfo> orderInfos = orderInfoRepository.findAllByOrderStatusOrderByOrderDateDesc(1L, pageable);

        Assert.assertNotNull(orderInfos);
        for (OrderInfo orderInfo : orderInfos) {
            System.out.println(orderInfo.getMember().getUserName() + " " + orderInfo.getTotalPrice());
        }
    }
}
