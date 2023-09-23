package springbook.user.dao;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * DB에 남아 있는 데이터와 같은 외부 환경에 영향을 받지 말아야하는 것은 물론이고 테c스트를 실행하는 순서를 바꿔도 동일한 결과가 보장되도록 만들어야 한다.
 */
class UserDaoTest {
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUpEach() {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        this.dao = context.getBean("userDao", UserDao.class);

        this.user1 = new User("hello", "헬로이름", "aladinpang");
        this.user2 = new User("sorijulru", "박창민", "eumak");
        this.user3 = new User("thinker", "팅커벨", "@#@#");
    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
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
    void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
        assertThrows(EmptyResultDataAccessException.class, () -> dao.get("unknown"));
    }

    @Test
    @DisplayName("리스트2-11 getCount() 테스트")
    void count() throws SQLException, ClassNotFoundException {
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