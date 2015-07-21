package pl.java.scalatech.test.guava.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.common.io.Flushables;

public class GuavaFileAndStreamTest {

    @Test
    public void shouldWriteAndClean() {
        File file = new File("my.txt");
        try {
            Files.touch(file);
            Files.write("przodownik", file, Charsets.UTF_8);
            Files.toByteArray(file);
            Assertions.assertThat(Files.readFirstLine(file, Charsets.UTF_8)).isEqualTo("przodownik");
            delete(file);
        } catch (IOException e) {
            Throwables.propagate(e);
        }
    }

    private static void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete file: " + f);
    }

    /*
     * try {
     * inputStream.close();
     * } catch (IOException e) {
     * Throwables.propagate(e);
     * }
     */
    @Test
    public void shouldClosingAndFlushig() {
        InputStream inputStream = System.in;
        Closeables.closeQuietly(inputStream);
        PrintStream outputStream = System.out;
        Flushables.flushQuietly(outputStream);
    }
}
