package springbook.user;

import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao(new DConnectionMaker());
        dao.dbInit();

        User user = new User();
        user.setId("whiteship");
        user.setName("김연우");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}