package springbook.user.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

/**
 * DB에 남아 있는 데이터와 같은 외부 환경에 영향을 받지 말아야하는 것은 물론이고 테스트를 실행하는 순서를 바꿔도 동일한 결과가 보장되도록 만들어야 한다.
 */
class UserDaoTest {

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao = context.getBean("userDao", UserDao.class);
        User user1 = new User("hello", "헬로이름", "aladinpang");
        User user2 = new User("sorijulru", "박창민", "eumak");

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName()).isEqualTo(user1.getName());
        assertThat(userget1.getPassword()).isEqualTo(user1.getPassword());

        User userget2 = dao.get(user2.getId());
        assertThat(userget2.getName()).isEqualTo(user2.getName());
        assertThat(userget2.getPassword()).isEqualTo(user2.getPassword());
    }

    @Test
    @DisplayName("리스트2-11 getCount() 테스트")
    void count() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao = applicationContext.getBean("userDao", UserDao.class);
        User user1 = new User("hello", "헬로이름", "aladinpang");
        User user2 = new User("sorijulru", "박창민", "eumak");
        User user3 = new User("thinker", "팅커벨", "@#@#");

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);

    }
}