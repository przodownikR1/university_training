package pl.java.scalatech.test.guava;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;

public class CharSetTest {
    private final static String TEST = "SlawekBorowiec.";

    @Test
    public void shouldCharSetWork() {
        byte[] bytes2 = TEST.getBytes(Charsets.UTF_8);
        // java 7
        // StandardCharsets.UTF_8
    }

    @Test
    public void shouldRemovedWhiteSpace() {
        String tabPlusSpace = "Kawasaki  +      powercommander     =  rocket";
        String expected = "Kawasaki + powercommander = rocket";
        String result = CharMatcher.WHITESPACE.collapseFrom(tabPlusSpace, ' ');
        Assertions.assertThat(result).isEqualTo(expected);
        
         //trim
         tabPlusSpace = "     Kawasaki  +      powercommander     =  rocket";
        
        result = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabPlusSpace, ' ');
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void shouldLetterFilter()
    {
        String lAndN = "assadasd9fgfg34";
        String expected = "934";
        String retain = CharMatcher.JAVA_DIGIT.retainFrom(lAndN);
        Assertions.assertThat(retain).isEqualTo(expected);
    }
}
