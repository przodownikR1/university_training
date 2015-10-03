package pl.java.scalatech.test.exercise;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;

public class ClearWhiteSpaceTest {
    @Test
    public void shouldRemoveWhiteSpace() {

        String text = "ala ma kota   ";

        String removeAllSpaces = CharMatcher.BREAKING_WHITESPACE
                .removeFrom(text);

        Assertions.assertThat(removeAllSpaces).isEqualTo("alamakota");
    }
}
