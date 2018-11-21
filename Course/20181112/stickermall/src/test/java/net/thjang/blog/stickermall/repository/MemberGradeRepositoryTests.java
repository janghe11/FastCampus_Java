package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.MemberGrade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberGradeRepositoryTests {
    @Autowired
    private MemberGradeRepository memberGradeRepository;

//    @Test
//	public void MemberGrade를이름으로검색() {
//        Pageable pageable = PageRequest.of(0, 5);
//        MemberGrade memberGrades = memberGradeRepository.findByName("jang", pageable);
//
//        Assert.assertNotNull(memberGrades);
//        for (MemberGrade memberGrade : memberGrades) {
//            System.out.println(memberGrade.getId() + " " + memberGrade.getName());
//        }
//    }
}
