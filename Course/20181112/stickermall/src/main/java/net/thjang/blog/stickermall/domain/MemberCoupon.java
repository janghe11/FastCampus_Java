package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "member_coupon")
@Getter
@Setter
public class MemberCoupon implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "order_info_id", referencedColumnName = "id")
    private OrderInfo orderInfo;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    private Date expireDate;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int usedCheck;
}
