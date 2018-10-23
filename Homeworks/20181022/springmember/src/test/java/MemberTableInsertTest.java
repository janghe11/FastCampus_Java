import net.thjang.blog.config.ApplicationConfig;
import net.thjang.blog.dto.Member;
import net.thjang.blog.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTableInsertTest {
    public static void main(String[] args) {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member();
        member.setName("park");
        member.setEmail("park@pc.com");
        member.setPassword("5678");

        Member result = memberService.addMember(member);

        System.out.println(result);
    }
}
