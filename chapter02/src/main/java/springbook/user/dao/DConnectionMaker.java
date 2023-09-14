package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionMaker 인터페이스 도입으로 인해 확장이 가능해졌다.
 */
@Deprecated
public class DConnectionMaker implements ConnectionMaker{
    
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        return c;
    }
}
