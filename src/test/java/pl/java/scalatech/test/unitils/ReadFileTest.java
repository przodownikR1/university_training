package pl.java.scalatech.test.unitils;



import java.io.File;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.io.annotation.FileContent;
import org.unitils.io.annotation.TempDir;
import org.unitils.io.annotation.TempFile;

public class ReadFileTest extends UnitilsJUnit4{
    @TempDir(value="tmp")
    private File directory;
    @FileContent(value="hello.txt",encoding="UTF-8")
    String content;
    @TempFile("output.txt")
    private File output;
    
    
    @Test
    public void testFile() {
    System.out.println(content);
    // Assert.assertTrue(file.exists());
    }
}
