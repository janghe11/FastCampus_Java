import net.thjang.blog.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiceGameTest01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dicegame.xml");
        Game game = applicationContext.getBean(Game.class);
        game.play();
    }
}
