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
    @Column(nullable = false, columnDefinition = "tinyint default 0")
    private boolean freeShipping;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    private Date expireDate;
    @Column(columnDefinition = "int default 0")
    private Integer durationPeriod;
    @ManyToOne
    @JoinColumn(name = "expire_type_id", referencedColumnName = "id")
    private ExpireType expireType;
    private String description;
}
