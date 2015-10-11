package pl.java.scalatech.test.guava.notnull;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.base.MoreObjects;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class NullPointerGuardTest {
    private int test;
    @Test
    public void shouldStringsWork(){
        assertThat(isNullOrEmpty("")).isTrue();
        assertThat(isNullOrEmpty(null)).isTrue();

    }
    @Test
    public void shouldGiveFirstNotNullValue() {
        String first = null;
        String second = "second";
        assertThat(firstNonNull(first, second)).isEqualTo("second");
        log.info("{}",MoreObjects.toStringHelper(this).add("test", 2).add("second", "eee"));
    }

}
