package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shipping_info")
@Getter
@Setter
public class ShippingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private int zipCode;
    @Column(nullable = false)
    private String addr;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private int shippingFee;
    private String memo;
}
