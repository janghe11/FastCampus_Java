package my.examples.guestbook.dao;

import java.sql.*;

public class DbUtil {
    public static Connection connect(String dbUrl, String dbId, String dbPassword)
            throws RuntimeException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbId, dbPassword);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }

        return connection;
    }

    // insert, update, delete 쿼리 실행 후 close
    public static void close(Connection connection, PreparedStatement ps) {
        if (ps != null){
            try {
                ps.close();
            }catch (SQLException e){

            }
        }

        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){

            }
        }
    } // close

    public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
        if (rs != null){
            try {
                rs.close();
            }catch (SQLException e){

            }
        }
        close(connection, ps);
    } //close
}
