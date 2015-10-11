package pl.java.scalatech.test.guava.collections;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class ImmutableCollectionTest {
    Set<String> orginal = newHashSet("slawek","bak","yamaha");
    @Test
    public void shouldImmutableWork() {
       Set<String> copyImmutable = ImmutableSet.copyOf(orginal); //guava
       Set<String> unmodifiable = java.util.Collections.unmodifiableSet(orginal); //java

       orginal.remove("bak");
       Assertions.assertThat(copyImmutable).contains("slawek","bak","yamaha");
       Assertions.assertThat(unmodifiable).contains("slawek","yamaha");

    }

}
