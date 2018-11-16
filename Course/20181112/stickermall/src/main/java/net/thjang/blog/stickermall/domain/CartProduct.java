package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product")
@Getter
@Setter
public class CartProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(columnDefinition = "int default 0")
    private int quantity;
}
