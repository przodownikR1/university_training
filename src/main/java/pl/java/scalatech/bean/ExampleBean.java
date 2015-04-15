package pl.java.scalatech.bean;

import java.io.IOException;
import java.sql.SQLException;

import pl.java.scalatech.exception.MyException;
import lombok.extern.slf4j.Slf4j;

import com.google.common.base.Throwables;

@Slf4j
public class ExampleBean {
    public void doSomething(int test) throws IOException, SQLException {
        try {
            someMethodThatCouldThrowAnything(test);
        } catch (MyException e) {
            handle(e);
        } catch (Throwable t) {
            Throwables.propagateIfInstanceOf(t, IOException.class);
            Throwables.propagateIfInstanceOf(t, SQLException.class);
            throw Throwables.propagate(t);
        }
    }

    private void handle(MyException e) {
        log.info("handle exception");
    }

    private void someMethodThatCouldThrowAnything(int i) throws IOException, SQLException {
        if (i % 2 == 0) { throw new IOException("file read error"); }
        throw new SQLException("retrieve data error ...");
    }
}