package pl.java.scalatech.test.guava.my;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateTest {
    String fileName = "messages1.properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateTest.class); //slfj

    @Test
    public void templateTest() {

        List<String> lines = new ArrayList<>(); //readLine
        try {
            lines = Files.readAllLines(Paths.get(fileName), Charset.forName("UTF-8"));
            System.out.println("+++ " + lines);
        } catch (IOException e) {
            // TODO: handle exception
        }
        System.err.println(lines);

    }

    @Test
    public void shouldTemplateWork() { //should
        Path p = Paths.get(fileName);
        System.out.println(p);//writeToFile
        try (BufferedWriter out = Files.newBufferedWriter(p, Charset.forName("UTF-8"))) {
            out.write("test");
            out.newLine();

        } catch (IOException e) {
            // TODO: handle exception
        }
        // Given

        // When

        // Then

    }
}
