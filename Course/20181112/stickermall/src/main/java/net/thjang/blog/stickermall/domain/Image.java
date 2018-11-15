package net.thjang.blog.stickermall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String originalName;
    @Column(nullable = false)
    private String savedName;
    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private Long size;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
}
