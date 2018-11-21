package net.thjang.blog.stickermall.controller;

import lombok.extern.java.Log;
import net.thjang.blog.stickermall.security.StickerMallUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/members")
@Log
public class MemberController {
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/info")
    public String info(Principal principal) {
        log.info("pricipal.getName() : " + principal.getName());
        StickerMallUserDetails loginUser =
                (StickerMallUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("loginUser.getName() : " + loginUser.getName());
        log.info("loginUser.getId() : " + loginUser.getId());
        log.info("loginUser.getEmail() : " + loginUser.getEmail());

        return "info";
    }
}
