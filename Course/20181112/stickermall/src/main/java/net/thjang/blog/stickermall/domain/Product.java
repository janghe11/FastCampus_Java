package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int totalQty;
    @Column(nullable = false)
    private int curQty;
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    @Column(nullable = false)
    private List<Category> categoryList;
    @OneToMany(mappedBy = "id")
    @Column(nullable = false)
    private List<Image> imageList;
    @Column(nullable = false)
    private int mileage;
}
