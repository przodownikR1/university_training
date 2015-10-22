package pl.java.scalatech.test.exception;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import lombok.SneakyThrows;

public class SneakTest {
   @Test(expected=IOException.class)
    public void shouldIOExceptionCatch() {
        SneakyThrowsExample.doThrowsIOExceptionSneak();
    }
   @Test(expected=RuntimeException.class)
   public void shouldWrapWork() {
       SneakyThrowsExample.doThrowIOExceptionWrap();
   }

}



class SneakyThrowsExample implements Runnable {
  @SneakyThrows
  public static void illegalAccessExceptionThrows() {
      throw new IllegalAccessException();
  }


  public static void doThrowIOExceptionWrap() {

      try {
          throw new IOException();


    } catch (IOException e) {
       throw new RuntimeException(e);
    }
  }

   public static void doThrowIOException() throws IOException {
        File f = File.createTempFile("test", "txt");
   }
   @SneakyThrows
   public static void doThrowsIOExceptionSneak() {
       throw new IOException();
   }


  public String utf8ToString(byte[] bytes) throws UnsupportedEncodingException {

        return new String(bytes, "UTF-8");

    }

    @Override
    @SneakyThrows
    public void run() {
       throw new Throwable();
    }
}