package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int totalQty;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int curQty;
    @Column(columnDefinition = "int default 0")
    private int saleMoney;
    @Column(columnDefinition = "float default 0.0")
    private double saleRatio;
    private Date expireDate;
    @Column(columnDefinition = "int default 0")
    private Integer durationPeriod;
    @Column(length = 2, nullable = false)
    private int expireType;
    private String description;
}
