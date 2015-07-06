package pl.java.scalatech.domain.guava;

import com.google.common.base.Predicate;

public class Predicates {

    public static Predicate<Integer> byEvenNumbers() {
        return new Predicate<Integer>() {

            public boolean apply(Integer integer) {
                return integer % 2 == 0;
            }
        };
    }

    public static Predicate<Integer> bigggerThanValues() {
        return new Predicate<Integer>() {

            public boolean apply(Integer integer) {
                return integer > 3;
            }
        };
    }

}