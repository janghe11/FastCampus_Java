package net.thjang.blog.stickermall.repository;

import net.thjang.blog.stickermall.domain.Member;
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

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
	public void Member전체가져오기() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Member> members = memberRepository.findAll();

        Assert.assertNotNull(members);
        for (Member member : members) {
            System.out.println(member.getId() + " " + member.getUserName());
        }
    }

//    @Test
//    public void Member를Id로검색() {
//        Pageable pageable = PageRequest.of(0, 5);
//        Page<Member> members = memberRepository.findById("jang", pageable);
//
//        Assert.assertNotNull(members);
//        for (Member member : members) {
//            System.out.println(member.getId() + " " + member.getUserName());
//        }
//    }

    @Test
    public void Member를이름으로검색() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Member> members = memberRepository.findAllByUserName("장태희", pageable);

        Assert.assertNotNull(members);
        for (Member member : members) {
            System.out.println(member.getId() + " " + member.getUserName());
        }
    }

    //확인필요
//    @Test
//    public void Member를Nickname으로검색() {
//        Pageable pageable = PageRequest.of(0, 5);
//        Page<Member> members = memberRepository.findByNickName("admin", pageable);
//
//        Assert.assertNotNull(members);
//        for (Member member : members) {
//            System.out.println(member.getId() + " " + member.getUserName());
//        }
//    }

    @Test
    public void Member를우편번호로검색() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Member> members = memberRepository.findAllByZipCode(11709, pageable);

        Assert.assertNotNull(members);
        for (Member member : members) {
            System.out.println(member.getId() + " " + member.getUserName());
        }
    }

    @Test
    public void Member를전화번호로검색() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Member> members = memberRepository.findAllByPhone("010-1234-5678", pageable);
        Assert.assertNotNull(members);
        for (Member member : members) {
            System.out.println(member.getId() + " " + member.getUserName());
        }
    }
}
