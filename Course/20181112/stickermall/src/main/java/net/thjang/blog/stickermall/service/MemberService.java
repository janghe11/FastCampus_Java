package net.thjang.blog.stickermall.service;

import net.thjang.blog.stickermall.domain.Member;
import net.thjang.blog.stickermall.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Member getMember(String email) {

        return memberRepository.findByEmail(email);
    }
}
