package pl.java.scalatech.test.guava;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;

@Slf4j
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
    public void shouldLetterFilter() {
        String lAndN = "assadasd9fgfg34";
        String expected = "934";
        String retain = CharMatcher.JAVA_DIGIT.retainFrom(lAndN);
        Assertions.assertThat(retain).isEqualTo(expected);
    }

    @Test
    public void shouldRemoveSpecialCharacters() {
        String input = "przodo$%#downik*.;' pracy _79";
        CharMatcher matcher = CharMatcher.JAVA_LETTER_OR_DIGIT;
        Assertions.assertThat(matcher.retainFrom(input)).isEqualTo("przododownikpracy79");

    }

    @Test
    public void shouldTrimString() {
        String input = "****przodownik==";

        String result = CharMatcher.is('*').trimLeadingFrom(input);
        Assertions.assertThat(result).isEqualTo("przodownik==");

        result = CharMatcher.is('=').trimTrailingFrom(input);
        Assertions.assertThat(result).isEqualTo("****przodownik");

        String str = CharMatcher.WHITESPACE.trimLeadingFrom("       przodownik       ");

        Assertions.assertThat(str).isEqualTo("przodownik       ");

        String rightStr = CharMatcher.WHITESPACE.trimTrailingFrom("       przodownik       ");
        Assertions.assertThat(rightStr).isEqualTo("       przodownik");

        String trimmedStr = CharMatcher.WHITESPACE.trimFrom("       przodownik       ");
        Assertions.assertThat(trimmedStr).isEqualTo("przodownik");

    }

    @Test
    public void shouldReplaceString() {

        String input = "przodownik-pracy=borowiec";

        String result = CharMatcher.anyOf("-=").replaceFrom(input, '~');
        Assertions.assertThat(result).isEqualTo("przodownik~pracy~borowiec");

    }

    @Test
    public void shouldRangeTest() {
        CharMatcher mch = CharMatcher.inRange('A', 'C');

    }
}
