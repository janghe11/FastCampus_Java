package net.thjang.blog.stickermall.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class StickerMallUserDetails extends User {
    private String name;
    private Long id;

    public StickerMallUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password,true, true, true, true, authorities);
    }

    public String getEmail() {
        return super.getUsername();
    }
}
