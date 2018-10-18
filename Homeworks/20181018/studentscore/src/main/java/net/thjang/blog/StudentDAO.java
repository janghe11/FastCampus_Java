package net.thjang.blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection connection = null;
    String url = null;
    String host = null;
    String database = null;
    String username = null;
    String password = null;

    public StudentDAO(String host, String database, String username, String password) {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = String.format("jdbc:mysql://%s/%s?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC", host, database);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        return connection;
    }

    public void close(PreparedStatement ps, Connection conn) {
        try {
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void close(PreparedStatement ps, ResultSet rs, Connection conn) {
        this.close(ps, conn);

        try {
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

    }

    public void add(Student student) {
        PreparedStatement ps = null;
        String sql = null;

        try {
            connection = connect();
            sql = "INSERT INTO student(name, literature, english, math) VALUES(?, ?, ?, ?)";
            ps = connect().prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getLiteratureScore());
            ps.setInt(3, student.getEnglishScore());
            ps.setInt(4, student.getMathScore());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            close(ps, connection);
        }
    }

    public void getList() {
        List<Student> studentsList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;

        try {
            connection = connect();
            sql = "SELECT * FROM student";
            ps = connect().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString(1));
                student.setLiteratureScore(rs.getInt(2));
                student.setEnglishScore(rs.getInt(3));
                student.setMathScore(rs.getInt(4));
                studentsList.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } finally {
            close(ps, connection);
        }
    }
}
