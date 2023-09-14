package springbook.user;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTestTest {

    @Test
    public void addAndGet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

}