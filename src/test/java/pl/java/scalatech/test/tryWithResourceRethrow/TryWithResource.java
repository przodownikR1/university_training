package pl.java.scalatech.test.tryWithResourceRethrow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResource {
    public static void main(String[] args) {
      InputStream is = null;
        try {
            is = new FileInputStream(new File("sample.txt"));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        
        try (InputStream iss = new FileInputStream(new File("sample2.txt"))) {
            System.out.println("ok");
          } catch (IOException ex) {
              System.err.println(ex.getMessage());
          }
    }
}
