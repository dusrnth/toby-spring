package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 합성 방식의 분리 - db connection 관심 class
 * interface 방식을 쓰면서 직접적인 합성방식은 deprecated 되었다.
 */
@Deprecated
public class SimpleConnectionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        return c;
    }
}
