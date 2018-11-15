package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int saleMoney;
    @Column(nullable = false, columnDefinition = "int default 0")
    private double saleRatio;
    @Column(nullable = false, columnDefinition = "tinyint default 0")
    private boolean freeShipping;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    private Date expireDate;
}
