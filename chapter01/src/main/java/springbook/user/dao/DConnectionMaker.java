package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        // D 사 DB Connection 생성 코드
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:tcp://localhost/~/test";
        return DriverManager.getConnection(url, "sa", "");
    }
}
