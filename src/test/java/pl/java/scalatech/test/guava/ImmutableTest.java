package pl.java.scalatech.test.guava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class ImmutableTest {
    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.add("four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = ImmutableList.copyOf(list);
        unmodifiableList.add("four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableTest() {
        final ImmutableList guavaImmutableList = ImmutableList.of(1, 2, 3);
        guavaImmutableList.add(3);
    }

    @Test
    public void immutableTest1() {
        HashSet<String> modifiableSet = Sets.newHashSet("a", "b", "c");
        Set<String> jdkUnmodifiable = Collections.unmodifiableSet(modifiableSet);
        ImmutableSet<String> guavaUnmodifiable = ImmutableSet.copyOf(modifiableSet);
        modifiableSet.remove("a");
        
        System.out.println(jdkUnmodifiable.size()); // prints 2
        System.out.println(guavaUnmodifiable.size()); // prints 3

    }

    @Test
    public void demoGuavaImmutableSet() {

        final Set<String> originalStrings = buildUnderlyingSampleSet();
        final ImmutableSet<String> strings = ImmutableSet.copyOf(originalStrings);
        System.out.println("Immutable Set of Strings: " + strings);
        originalStrings.remove("slawek");
        System.out.println("Original Set of Strings: " + originalStrings);
        System.out.println("Immutable Set of Strings: " + strings);
    }

    private Set<String> buildUnderlyingSampleSet() {
        Set<String> s = Sets.newHashSet("slawek", "borowiec", "kalina", "przodownik");
        return s;
    }

    @Test(expected = NullPointerException.class)
    public void testNullImmutableList() {
        List<String> names = null;
        ImmutableList<String> r = ImmutableList.copyOf(names);

    }

    @Test
    public void demoJdkUnmodifiableSet() {
        System.err.println("java");
        final Set<String> originalStrings = buildUnderlyingSampleSet();
        final Set<String> strings = Collections.unmodifiableSet(originalStrings);
        System.out.println("Unmodifiable Set of Strings: " + strings);
        originalStrings.remove("slawek");
        System.out.println("Original Set of Strings: " + originalStrings);
        System.out.println("Unmodifiable Set of Strings: " + strings);
    }

    @Test
    public void demoGuavaImmutableMap() {

        final Map<String, String> originalStringsMapping = new HashMap<>();
        originalStringsMapping.put("D", "Dustin");
        originalStringsMapping.put("G", "Guava");
        originalStringsMapping.put("J", "Java");
        final ImmutableMap<String, String> strings = ImmutableMap.<String, String> builder().putAll(originalStringsMapping).build();
        System.out.println("Immutable Map of Strings: " + strings);
        originalStringsMapping.remove("D");
        System.out.println("Original Map of Strings: " + originalStringsMapping);
        System.out.println("Immutable Map of Strings: " + strings);
    }

    @Test
    public void demoJdkUnmodifiableMap() {

        final Map<String, String> originalStringsMapping = new HashMap<>();
        originalStringsMapping.put("D", "Dustin");
        originalStringsMapping.put("G", "Guava");
        originalStringsMapping.put("J", "Java");
        final Map<String, String> strings = Collections.unmodifiableMap(originalStringsMapping);
        System.out.println("Unmodifiable Map of Strings: " + strings);
        originalStringsMapping.remove("D");
        System.out.println("Original Map of Strings: " + originalStringsMapping);
        System.out.println("Unmodifiable Map of Strings: " + strings);
    }
}
