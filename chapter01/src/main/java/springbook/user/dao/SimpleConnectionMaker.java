package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:tcp://localhost/~/Documents/projects/toby-spring/chapter01/hello";
        return DriverManager.getConnection(url, "sa", "");
    }
}
