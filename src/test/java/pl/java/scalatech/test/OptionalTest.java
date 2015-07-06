package pl.java.scalatech.test;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

@Slf4j
public class OptionalTest {
    private Multimap<String, String> map = ArrayListMultimap.create();

    // map null
    public OptionalTest() {
        map.put("yamaha", "R1");
        map.put("suzuki", "gsxr");
    }

    public void oldWay() {
        String moto = map.get("yamaha").toString().toUpperCase();
        System.out.println(moto);
        moto = map.get("kawasaki").toString().toUpperCase();
        if (moto != null) {
            moto = moto.toUpperCase();
            System.out.println(moto);
        }
    }

    public void guavaWay() {
        Map<String, String> mapOld = Maps.newHashMap();
        mapOld.put("yamaha", "R1");
        mapOld.put("suzuki", "gsxr");
        Optional<String> yamaha = Optional.fromNullable(mapOld.get("yamaha"));
        if (yamaha.isPresent()) {
            String name = yamaha.get();
            Assertions.assertThat(name).isEqualTo("R1");
        }
        String kawasakiName = Optional.fromNullable(mapOld.get("kawasaki")).or("Not Found").toUpperCase();
        Assertions.assertThat(kawasakiName).isEqualTo("NOT FOUND");
    }

    @Test
    public void test() {
        OptionalTest ot = new OptionalTest();
        ot.oldWay();
        ot.guavaWay();
        Item i = null;
        Optional<Item> opI = Optional.fromNullable(i);
        Assertions.assertThat(opI.isPresent()).isFalse();

    }

    @Test
    public void test2() {
        Optional<Integer> optional = Optional.absent();
        Integer or = optional.or(2);
        Assertions.assertThat(optional.isPresent()).isFalse();
        Assertions.assertThat(or).isEqualTo(2);
    }

    @Test
    public void testNull() {
        List<String> persons = Lists.newArrayList("A", null, "C", "przodownik", null);
        persons.stream().forEach(p -> log.info("{} , {} ", p, Strings.nullToEmpty(p)));

    }

    private UserP person = null;

    @Test
    public void nullTest() {
        Optional<UserP> p = Optional.fromNullable(person);
        Assertions.assertThat(MoreObjects.firstNonNull(person, "")).isEqualTo("");
    }

    @Data
    class UserP {
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Item {
        private String name;
    }
}
