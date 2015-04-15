package pl.java.scalatech.test.domain._java7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class TryWithResourceTest {

    
    @Test
    public void shouldMethodWork(){
        String separator = FileSystems.getDefault().
                getSeparator();
        log.info("separator : {}" , separator);
        Path path = new File("src/test/resources/sample.txt").toPath();
        log.info("{}",path.toString());
        log.info("Absolute path: {} " , path.toAbsolutePath());
        
        try {
            log.info("Real path: {}" , path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        log.info("URI: {} " + path.toUri());
        log.info("fileExists: {} " , Files.exists(path));
        
        Path rootPath = Paths.get("/home/przodownik");
        Path partialPath = Paths.get("sample.txt");
        Path resolvedPath = rootPath.resolve(partialPath);
        log.info("rootPath: {} " , rootPath);
        log.info("partialPath: {} " , partialPath);
        log.info("resolvedPath: {}" , resolvedPath);
        log.info("Resolved absolute path: {} " + resolvedPath.toAbsolutePath());
        
    }
    
    @Test
    public void shouldAutoCloseWork() {

        try (BufferedReader inputReader = Files.newBufferedReader(new File("src/test/resources/sample.txt").toPath(), Charset.defaultCharset());
                BufferedWriter outputWriter = Files.newBufferedWriter(new File("src/test/resources/sample2.txt").toPath(), Charset.defaultCharset())) {
            String inputLine;
            while ((inputLine = inputReader.readLine()) != null) {
                outputWriter.write(inputLine);
                outputWriter.newLine();
            }
            log.info("complete!");
        } catch (IOException ex) {
            log.error("{}", ex);
            // ex.printStackTrace();
        }
    }

}
