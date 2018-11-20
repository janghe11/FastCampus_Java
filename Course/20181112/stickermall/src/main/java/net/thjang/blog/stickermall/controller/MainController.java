package net.thjang.blog.stickermall.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
public class MainController {

    public MainController() {
        log.info("MainController가 실행 되었습니다.");
    }

    @RequestMapping("/")
    public String main() {
        return "index";
    }
}
