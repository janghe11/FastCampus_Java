package my.examples.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCExam01 {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");

        Connection conn = null;

        try{
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=1", "sa", "");
            System.out.println("성공!");
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
