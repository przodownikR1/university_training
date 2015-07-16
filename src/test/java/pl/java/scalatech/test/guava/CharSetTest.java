package pl.java.scalatech.test.guava;

import static org.fest.assertions.Assertions.assertThat;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.html.HtmlEscapers;

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
        assertThat(result).isEqualTo(expected);

        //trim
        tabPlusSpace = "     Kawasaki  +      powercommander     =  rocket";

        result = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabPlusSpace, ' ');
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldLetterFilter() {
        String lAndN = "assadasd9fgfg34";
        String expected = "934";
        String retain = CharMatcher.JAVA_DIGIT.retainFrom(lAndN);
        assertThat(retain).isEqualTo(expected);
    }

    @Test
    public void shouldRemoveSpecialCharacters() {
        String input = "przodo$%#downik*.;' pracy _79";
        CharMatcher matcher = CharMatcher.JAVA_LETTER_OR_DIGIT;
        assertThat(matcher.retainFrom(input)).isEqualTo("przododownikpracy79");

    }

    @Test
    public void shouldTrimString() {
        String input = "****przodownik==";

        String result = CharMatcher.is('*').trimLeadingFrom(input);
        assertThat(result).isEqualTo("przodownik==");

        result = CharMatcher.is('=').trimTrailingFrom(input);
        assertThat(result).isEqualTo("****przodownik");

        String str = CharMatcher.WHITESPACE.trimLeadingFrom("       przodownik       ");

        assertThat(str).isEqualTo("przodownik       ");

        String rightStr = CharMatcher.WHITESPACE.trimTrailingFrom("       przodownik       ");
        assertThat(rightStr).isEqualTo("       przodownik");

        String trimmedStr = CharMatcher.WHITESPACE.trimFrom("       przodownik       ");
        assertThat(trimmedStr).isEqualTo("przodownik");

    }

    @Test
    public void shouldReplaceString() {

        String input = "przodownik-pracy=borowiec";

        String result = CharMatcher.anyOf("-=").replaceFrom(input, '~');
        assertThat(result).isEqualTo("przodownik~pracy~borowiec");

    }

    @Test
    public void shouldRangeTest() {
        String phone = CharMatcher.inRange('0', '9').retainFrom("516-168-690");
        assertThat("516168690").isEqualTo(phone);

    }

    @Test
    public void shouldlEscapeWork() {
        assertThat(HtmlEscapers.htmlEscaper().escape("<")).isEqualTo("&lt;");
        assertThat(HtmlEscapers.htmlEscaper().escape(">")).isEqualTo("&gt;");
        assertThat(HtmlEscapers.htmlEscaper().escape("'")).isEqualTo("&#39;");
        assertThat(HtmlEscapers.htmlEscaper().escape("\"")).isEqualTo("&quot;");
        assertThat(HtmlEscapers.htmlEscaper().escape("&")).isEqualTo("&amp;");

    }
}
