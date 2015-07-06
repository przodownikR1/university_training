package pl.java.scalatech.test.guava;

import static com.google.common.collect.FluentIterable.from;
import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.junit.Test;

import pl.java.scalatech.domain.guava.Predicates;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

public class FunctionTest {
    ImmutableList<Worker> workers = ImmutableList.<Worker> builder().add(new Worker("slAwek", 1l, 36)).add(new Worker("Przodownik", 2l, 46)).build();

    Function<Worker, Person> transformW2P = new Function<Worker, Person>() {
        @Override
        public Person apply(Worker input) {
            return new Person("id :" + input.getId() + " name : " + input.getName());
        }
    };

    Function<Person, String> lowerCaseFunction = new Function<Person, String>() {
        @Override
        public String apply(Person p) {
            return p.getDesc().toLowerCase();
        }
    };

    Function<Worker, String> joiner = new Function<Worker, String>() {
        @Override
        public String apply(Worker input) {
            return Joiner.on('#').join(input.getName(), input.getId(), input.getAge());
        }
    };

    Function<String, String> upperCase = new Function<String, String>() {
        @Override
        public String apply(String input) {
            return input.toUpperCase();
        }
    };

    @Test
    public void workersTest() {
        Person p = transformW2P.apply(workers.get(0));
        System.out.println("person " +p);
        System.out.println("compose result :  " + Functions.compose(upperCase, joiner).apply(workers.get(1)));
    }

    @Test
    public void mapTest() {
        Map<Integer, String> testmap = Maps.newHashMap();
        testmap.put(111, "String111");
        testmap.put(222, "String222");
        testmap.put(333, "String333");

        Function<Integer, String> lookup1 = Functions.forMap(testmap);
        System.out.println("lookup : " + lookup1.toString());

        String get = lookup1.apply(222);
        System.out.println("get :" + get);

        Function<Integer, String> lookup2 = Functions.forMap(testmap, "default");
        System.out.println(lookup2.toString());
        testmap.put(444, "String444");

        String get2 = lookup2.apply(444);
        System.out.println("get2 " + get2);
        String get3 = lookup2.apply(555);
        System.out.println("get3 : " + get3);
    }

    @Test
    public void fluentTest() {
        FluentIterable<Integer> numbers = from(asList(1, 2, 3, 4, 5, 6));
        System.out.println(numbers.filter(Predicates.byEvenNumbers()));
        System.out.println(numbers.filter(Predicates.bigggerThanValues()));
        System.out.println(numbers.limit(4));
        System.out.println(numbers.toSortedList(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2.intValue() > o1.intValue()) {
                    return 1;
                } else if (o2.intValue() == o1.intValue())
                    return 0;

                return -1;
            }
        }));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Worker {
    String name;
    long id;
    int age;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    String desc;

}
