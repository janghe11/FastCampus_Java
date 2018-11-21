package net.thjang.blog.stickermall;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class PasswordEncodeTest {
    private PasswordEncoder passwordEncoder;
    @Before
    public void setup() throws Exception {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    public void PasswordEncode() throws Exception {
        PasswordEncoder passwordEncoder2 = new MessageDigestPasswordEncoder("SHA-256");
        String encode = passwordEncoder2.encode("admin");
        System.out.println(encode);
        String encode2 = passwordEncoder2.encode("1234");
        System.out.println(encode2);
    }
}
