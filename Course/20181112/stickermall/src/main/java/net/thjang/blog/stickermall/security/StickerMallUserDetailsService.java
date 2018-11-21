package net.thjang.blog.stickermall.security;

import net.thjang.blog.stickermall.domain.Member;
import net.thjang.blog.stickermall.domain.Role;
import net.thjang.blog.stickermall.service.MemberService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StickerMallUserDetailsService implements UserDetailsService {
    private MemberService memberService;

    public StickerMallUserDetailsService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberService.getMember(email);
        if (member == null)
            throw new UsernameNotFoundException(email + "is not found");

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : member.getRoleSet()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }

        StickerMallUserDetails stickerMallUserDetails = new StickerMallUserDetails(email, member.getPassword(), authorities);
//        UserDetails userDetails = new User(email, member.getPassword(), authorities);
        stickerMallUserDetails.setName(member.getUserName());
        return stickerMallUserDetails;
    }
}
