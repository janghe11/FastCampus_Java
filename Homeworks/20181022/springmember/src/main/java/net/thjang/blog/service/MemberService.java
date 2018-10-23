package net.thjang.blog.service;

import net.thjang.blog.dto.Member;

public interface MemberService {
    Member addMember(Member member);
    Member getMember(String email);
}
