package pl.java.scalatech.test.guava;

import static com.google.common.primitives.Ints.join;
import static com.google.common.primitives.Ints.max;
import static com.google.common.primitives.Ints.min;
import static com.google.common.primitives.Ints.tryParse;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class StringPrimitiveTest {
    @Test
    public void shouldStringParse() {
        assertThat(tryParse("1")).isEqualTo(1);
    }

    @Test
    public void shouldFindMinAndMax() {
        int[] ints = { 17, 1, 56, 3 };
        assertThat(max(ints)).isEqualTo(56);
        assertThat(min(ints)).isEqualTo(1);

    }

    @Test
    public void shouldJoinPrimitiveToString() {
        int[] ints = { 1, 2, 3, };
        assertThat(join(",", ints)).isEqualTo("1,2,3");
        assertThat(join(";", ints)).isEqualTo("1;2;3");

    }
}
