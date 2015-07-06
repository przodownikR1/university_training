package pl.java.scalatech.test.guava;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

@Slf4j
public class RangeTest {
    @Test
    public void shouldRangeWok() {
        boolean containsAll = Range.closed(1, 5).containsAll(Ints.asList(1, 2, 3));
        Assertions.assertThat(containsAll).isTrue();
        Range.range(1, BoundType.CLOSED, 5, BoundType.CLOSED);
        // create set
        ImmutableSortedSet<Integer> set = ContiguousSet.create(Range.open(1, 5), DiscreteDomain.integers());

    }

    @Test
    public void shouldPrintRange() {
        for (int grade : ContiguousSet.create(Range.closed(1, 5), DiscreteDomain.integers())) {
            log.info("+++  {}", grade);
        }
    }
}
