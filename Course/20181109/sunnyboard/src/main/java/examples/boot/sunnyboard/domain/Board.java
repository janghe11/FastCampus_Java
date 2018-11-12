package examples.boot.sunnyboard.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name= "springboot")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 20자 not null
//    @NotNull
    @Column(nullable = false, length = 20)
    private String name;
    // 255자 not null
//    @NotNull
    @Column(nullable = false, length = 255)
    private String title;
    // text not null
    @NotNull
    @Lob
//    @Column(columnDefinition = "TEXT")
    private String content;
    private int readCount;
    // DBMS의 시간이 저장 됨
//    @Temporal(TemporalType.TIMESTAMP)
    @Column
    @CreationTimestamp
    private LocalDateTime regdate;

    @Column
    @CreationTimestamp
    private LocalDateTime updateDate;

//    public Board() {
//        // DB의 시간이 저장되는 것이 아니고 WAS 안의 시간이 저장됨
//        regdate = LocalDateTime.now();
//    }
}
