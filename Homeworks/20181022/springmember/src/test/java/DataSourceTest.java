import net.thjang.blog.config.ApplicationConfig;
import net.thjang.blog.config.DBConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    public static void main(String[] args) {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DataSource ds = ac.getBean(DataSource.class);
        Connection conn = null;
        try {
            conn = ds.getConnection();
            if (conn != null)
                System.out.println("DB 접속 성공");
        } catch (SQLException ex) {
            throw new RuntimeException();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
        }
    }
}
