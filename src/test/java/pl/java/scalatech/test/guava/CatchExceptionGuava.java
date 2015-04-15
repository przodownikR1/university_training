package pl.java.scalatech.test.guava;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.fest.assertions.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pl.java.scalatech.bean.ExampleBean;

public class CatchExceptionGuava {
    private final static String SQL_EXCEPTION = "retrieve data error ...";
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowSomeException() throws Exception {
        // given
        thrown.expect(SQLException.class);
        thrown.expectMessage(SQL_EXCEPTION);
        ExampleBean exampleBean = new ExampleBean();
        // when
        exampleBean.doSomething(1);
        // then
        fail("SQLException should throw");
    }

}