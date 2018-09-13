package my.examples.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam02 {
    public static void main(String[] args) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Class.forName("org.h2.Driver");

            String sql = "SELECT role_id, description from ROLE";

            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=1", "sa", "");
//            System.out.println("성공!");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                int roldId = rs.getInt(1);
                String description = rs.getString(2);
                System.out.println(roldId + "," + description);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try{
                rs.close();
            }catch (Exception e){}
            try{
                ps.close();
            }catch (Exception e){}
            try{
                conn.close();
            }catch (Exception e){}

        }
    }
}
