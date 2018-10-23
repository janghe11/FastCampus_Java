package net.thjang.blog.service;

import net.thjang.blog.dao.MemberDAO;
import net.thjang.blog.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    @Transactional
    public Member addMember(Member member) {
        Long id = memberDAO.addMember(member);
        member.setId(id);

        return member;
    }

    @Override
    @Transactional
    public Member getMember(String email) {
        Member member = memberDAO.getMember(email);

        return member;
    }
}
