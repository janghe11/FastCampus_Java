package net.thjang.blog.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;
    private long regdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public LocalDateTime getRegdate() {
//        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochMilli(regdate), TimeZone.getDefault().toZoneId());
//
//        return ldt;
//    }

//    public void setRegdate(LocalDateTime regdate) {
//        this.regdate = Long.parseLong(regdate.toString());
//    }
}
