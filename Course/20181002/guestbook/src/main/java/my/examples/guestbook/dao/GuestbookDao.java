package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class GuestbookDao {
    private String dbUrl =
            "jdbc:mysql://localhost:3306/guestbook?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
    private String dbId = "java";
    private String dbPassword = "java";

    public List<Guestbook> guestbookList() throws RuntimeException{
        List<Guestbook> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DbUtil.connect(dbUrl, dbId,dbPassword);
            String sql = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Guestbook guestbook = new Guestbook();
                guestbook.setId(rs.getLong(1));
                guestbook.setName(rs.getString(2));
                guestbook.setContent(rs.getString(3));
                Date dbDate = rs.getDate(4);
                java.util.Date date = new java.util.Date(dbDate.getTime());
                LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                guestbook.setRegate(ldt);
                list.add(guestbook);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(connection, ps, rs);
        }

        return list;
    }

    public int addGuestbook(Guestbook guestbook) throws RuntimeException{
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "INSERT INTO guestbook (id, name, content, regdate)\n" +
                    "VALUES (null, ?, ?, now())";
            ps = connection.prepareStatement(sql);
            ps.setString(1, guestbook.getName());
            ps.setString(2, guestbook.getContent());
            count = ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(connection, ps);
        }
        return count;
    }

    public int deleteGuestbook(Long id) throws RuntimeException{
        int count = 0;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DbUtil.connect(dbUrl, dbId, dbPassword);
            String sql = "DELETE FROM guestbook WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            DbUtil.close(connection, ps);
        }

        return count;
    }
}
