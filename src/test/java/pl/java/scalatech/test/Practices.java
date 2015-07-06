package pl.java.scalatech.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class Practices {
    public void f1(int v) {
        // Bad usage of literal
        if (v == 45) {
            // What is 45? Why??
        }
    }

    // Should have used
    public static final int MAXIMUM_ANGLE_IN_DEG = 45;

    // I call it my billion-dollar mistake. It was the invention of the null reference in
    // 1965.

    class Person {

    };

    public void f2() {
        Map<String, Person> map = Maps.newHashMap();
        // Must check before ... but what if we forget?
        if (map.containsKey("slawek")) {
        }
        Person p = map.get("slawek");
        // Or check after ... but what if we forget?
        Person p2 = map.get("slawek");
        if (p != null) {

        }
    }
    @Test
    public void test(){
        List<Integer> is = new ArrayList(4); // 4 not actual size
        int i = is.get(2);
    }
}
