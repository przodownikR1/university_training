package pl.java.scalatech.test.guava.my;

import java.util.List;
import java.util.function.Function;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class MyTest {
    List<String> strings = Lists.newArrayList("slawek","kalina","dorota");
    Function<String, Integer> lengthFunction = new Function<String, Integer>() {
        public Integer apply(String string) {
            return string.length();
        }
    };
    Predicate<String> allCaps = new Predicate<String>() {
        public boolean apply(String string) {
            return CharMatcher.JAVA_UPPER_CASE.matchesAllOf(string);
        }
    };
  //  Multiset<Integer> lengths = HashMultiset.create(Iterables.transform(Iterables.filter(strings, allCaps), lengthFunction));
}
