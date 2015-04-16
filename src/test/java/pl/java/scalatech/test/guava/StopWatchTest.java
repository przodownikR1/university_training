package pl.java.scalatech.test.guava;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Stopwatch;
import com.google.common.io.Files;

public class StopWatchTest {
    @Test
    public void shouldStopWork() {
        final Stopwatch stopwatch = Stopwatch.createStarted();

        // Sleep for few random milliseconds.
        try {
            int i = new Random().nextInt(1000);
            System.out.println(i);

            Thread.sleep(i);
        } catch (final InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        stopwatch.stop(); // optional

        System.out.println("Elapsed time ==> " + stopwatch);
        System.out.println("Elapsed time in Nanoseconds ==> " + stopwatch.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Elapsed time in Microseconds ==> " + stopwatch.elapsed(TimeUnit.MICROSECONDS));
        System.out.println("Elapsed time in Milliseconds ==> " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }

    @Test
    public void shouldStopWatchOnFileTest() throws IOException {
        List<String> lines = Files.readLines(new File("src/test/resources/file.txt"), Charsets.UTF_8);

        Stopwatch stopwatch = Stopwatch.createStarted();
        for (String nextLine : lines) {

        }
        stopwatch.stop();
        System.out.printf("Completed run in %d ms", stopwatch.elapsed(TimeUnit.MICROSECONDS));

        Assert.assertEquals(4, lines.size());
    }
}
