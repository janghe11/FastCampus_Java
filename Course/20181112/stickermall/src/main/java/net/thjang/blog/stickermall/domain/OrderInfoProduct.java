package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_info_product")
@Getter
@Setter
public class OrderInfoProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_info_id")
    private OrderInfo orderInfo;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String name;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int mileage;
}
