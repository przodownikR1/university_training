package pl.java.scalatech.test.guava.collections;

import static com.google.common.collect.HashMultiset.create;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;

public class CountWordsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    List<String> words = newArrayList("bmw", "ford", "bmw", "fiat", "star");
    ImmutableList<String> wordsImmutable = copyOf(words);

    @Test
    public void shouldCountWords() {
        Multiset<String> counts = create(wordsImmutable);
        Multiset<String> counts2 = create(words);
        Assertions.assertThat(counts.count("bmw")).isEqualTo(2);

    }

    @Test
    public void shouldImmutableTest() {
        thrown.expect(UnsupportedOperationException.class);
        wordsImmutable.add("test");

    }

}
