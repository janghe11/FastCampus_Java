package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @Column(length = 20, unique = true, nullable = false)
    private String id;
    @Column(length = 20, unique = true, nullable = false)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(length = 20, nullable = false, unique = true)
    private String nickName;
    @OneToMany(mappedBy = "member")
    private List<MemberCoupon> memberCouponList;
    @OneToMany(mappedBy = "member")
    private List<CartProduct> cart;
    @ManyToMany
    @JoinTable(name = "member_role",
                joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "rold_id", referencedColumnName = "id"))
    private Set<Role> roleSet;
    @OneToMany(mappedBy = "member")
    private List<OrderInfo> orderInfoList;
    @ManyToMany
    @JoinTable(name = "favorite_product",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> favorites;
    private String addr;
    @Column(length = 6)
    private Integer zipCode;
    @Column(length = 13)
    private String phone;
    @Column(columnDefinition = "int default 0")
    private int mileage;
    @OneToOne
    private MemberGrade memberGrade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

//    public void addOrderInfo(OrderInfo orderInfo) {
//        orderInfoList.add(orderInfo);
//        orderInfo.setMember(this);
//    }
}
