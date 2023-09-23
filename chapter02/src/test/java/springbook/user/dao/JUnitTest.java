package springbook.user.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JUnitTest {
    static JUnitTest testObject;

    @Test
    void test1() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    void test2() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    void test3() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }
}
