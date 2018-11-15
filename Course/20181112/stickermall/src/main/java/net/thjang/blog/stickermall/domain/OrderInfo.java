package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_info")
@Getter
@Setter
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "orderInfo")
    private List<OrderInfoProduct> orderInfoProductList;
    private Integer totalPrice;
    private Date orderDate;
    @OneToOne
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;
    @OneToOne
    @JoinColumn(name = "shipping_info")
    private ShippingInfo shippingInfo;
    @OneToMany(mappedBy = "orderInfo")
    private List<MemberCoupon> memberCouponList;
}
