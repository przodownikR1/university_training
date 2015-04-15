package pl.java.scalatech.test.domain.lombok;

import java.io.UnsupportedEncodingException;

import lombok.Lombok;
import lombok.SneakyThrows;

import org.junit.Test;

public class SneakyTest {

    @SneakyThrows(UnsupportedEncodingException.class)
    public String utf8ToString(byte[] bytes) {
        return new String(bytes, "UTF-8");
    }

    // as result
    public String utf8ToStringResult(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw Lombok.sneakyThrow(e);
        }
    }

    @Test
    public void shouldSneakyWork() {
        utf8ToString("slawek".getBytes());
    }

    public String utf8ToStringWithoutSneakyFeature(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes, "UTF-8");
    }

    @Test
    public void shouldThrowWithoutSneakyFeature() throws UnsupportedEncodingException {
        utf8ToStringWithoutSneakyFeature("slawek".getBytes());
    }
}
