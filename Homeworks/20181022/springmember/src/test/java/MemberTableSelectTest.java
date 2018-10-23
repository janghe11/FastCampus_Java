import net.thjang.blog.config.ApplicationConfig;
import net.thjang.blog.dto.Member;
import net.thjang.blog.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class MemberTableSelectTest {
    public static void main(String[] args) {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Member member = memberService.getMember("janghe11@naver.com");

        System.out.println(member.getId() + " " + member.getName() + " "
                + member.getPassword() + " " + member.getEmail() );
    }
}
