package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N 사 DB Connection 생성 코드
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:tcp://localhost/~/Documents/projects/toby-spring/chapter01/hello";
        return DriverManager.getConnection(url, "sa", "");
    }
}
