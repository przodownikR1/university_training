package pl.java.scalatech.test.guava.collections;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

@Slf4j
public class CollectionTest {
    @Test
    public void whenPartitionList_thenPartitioned() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom", "Viki", "Tyler");
        List<List<String>> result = Lists.partition(names, 2);
        assertEquals(3, result.size());
        assertThat(result.get(0), contains("John", "Jane"));
        assertThat(result.get(1), contains("Adam", "Tom"));
        assertThat(result.get(2), contains("Viki", "Tyler"));
    }

    @Test
    public void whenRemoveNullFromList_thenRemoved() {
        List<String> names = Lists.newArrayList("John", null, "Adam", null, "Jane");
        Iterables.removeIf(names, Predicates.isNull());
        assertEquals(3, names.size());
        assertThat(names, contains("John", "Adam", "Jane"));
    }

    @Test
    public void shouldSetManipulation() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3", "5", "6", "8");
        Set<String> s2 = Sets.newHashSet("2", "3", "4", "5", "7");
        Assertions.assertThat(Sets.difference(s1, s2)).isEqualTo(Sets.newHashSet("1", "8", "6"));

        SetView<String> symmetric = Sets.symmetricDifference(s1, s2);
        Assertions.assertThat(symmetric).isEqualTo(Sets.newHashSet("1", "8", "6", "7", "4"));

        Sets.SetView<String> intersection = Sets.intersection(s1, s2);
        Assertions.assertThat(intersection).isEqualTo(Sets.newHashSet("3", "2", "5"));

        Sets.SetView<String> sv = Sets.union(s1, s2);
        Assertions.assertThat(sv).isEqualTo(Sets.newHashSet("3", "2", "1", "8", "6", "5", "7", "4"));

    }

    @Test
    public void shouldTableWork() {
        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();

        table.put(1, 1, "yamaha");
        table.put(1, 2, "suzuki");
        table.put(1, 3, "honda");
        table.put(2, 1, "ducati");
        table.put(2, 2, "kawasaki");
        table.put(2, 3, "aprilla");
        log.info("table : {}", table);
        Assertions.assertThat(table.contains(1, 1)).isTrue();
        Assertions.assertThat(table.containsColumn(2)).isTrue();
        Assertions.assertThat(table.containsRow(1)).isTrue();
        Assertions.assertThat(table.containsValue("kawasaki")).isTrue();
        Assertions.assertThat(table.remove(1, 3)).isEqualTo("honda");
        Assertions.assertThat(table.get(3, 4)).isNull();
        Assertions.assertThat(table.get(2, 2)).isEqualTo("kawasaki");

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBimapThrowException() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "honda");
        biMap.put("2", "honda"); // IllegalArgumentException
    }

    @Test
    public void shouldForcePutWork() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "honda");
        biMap.put("2", "yamaha");
        biMap.forcePut("3", "honda");
        Assertions.assertThat(biMap.containsKey("1")).isFalse();
        Assertions.assertThat(biMap.get("2")).isEqualTo("yamaha");
        Assertions.assertThat(biMap.get("3")).isEqualTo("honda");
    }

    @Test
    public void shouldInverseBiMap() {
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "a");
        biMap.put(2, "b");
        biMap.put(3, "d");
        biMap.forcePut(3, "c");
        Assertions.assertThat(biMap.containsKey("c"));
        Assertions.assertThat(biMap.containsKey("d")).isFalse();
        BiMap<String, Integer> inversedBiMap = biMap.inverse();
        log.info("orginal : {}", biMap);
        log.info("inverse : {}", inversedBiMap);
    }

    ImmutableList<String> wordsImmutable = ImmutableList.copyOf(Lists.newArrayList("bmw", "ford", "bmw", "fiat", "star"));

    @Test
    public void shouldMapOldWork() {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : wordsImmutable) {
            if (!countMap.containsKey(word)) {
                countMap.put(word, 0);
            }
            countMap.put(word, countMap.get(word) + 1);
        }
        Assertions.assertThat(countMap.get("bmw")).isEqualTo(2);
        Assertions.assertThat(countMap.get("ford")).isEqualTo(1);
        Assertions.assertThat(countMap.get("star")).isEqualTo(1);

    }

    @Test
    public void shouldGuavaMultiSetWork() {
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordsImmutable);
      
        wordsMultiset.add("star",10);
        
        log.info("wordsMultiset: after set 10 elements:  {}",wordsMultiset);
        wordsMultiset.remove("star",4);
        log.info("wordsMultiset: after removed : {}",wordsMultiset);
        
        wordsMultiset.setCount("star", 5);
        assertThat(wordsMultiset.count("star")).isEqualTo(5);
        
        assertThat(wordsMultiset.count("bmw")).isEqualTo(2);

    }

    List<Programmer> programmers = Lists.newArrayList(new Programmer("grooby", "przodownik"), new Programmer("java", "agnieszka"), new Programmer("java",
            "marcin"));

    @Test
    public void oldMultiList() {
        Map<String, List<String>> languagesMap = new HashMap<>();
        for (Programmer programmer : programmers) {
            String language = programmer.getLanguage();
            if (languagesMap.get(language) == null) {
                languagesMap.put(language, new ArrayList<String>());
            }
            languagesMap.get(language).add(programmer.getEmail());
        }
        Assertions.assertThat(languagesMap.get("java")).isEqualTo(Lists.newArrayList("agnieszka", "marcin"));

    }

    @Test
    public void shouldGuavaMultiMapWork() {
        Multimap<String, String> languagesMap = HashMultimap.create();
        for (Programmer programmer : programmers) {
            languagesMap.put(programmer.getLanguage(), programmer.getEmail());
        }
        Assertions.assertThat(languagesMap.containsKey("java"));
        Assertions.assertThat(languagesMap.containsKey("grooby"));
        System.out.println(languagesMap + "  " + languagesMap.entries());
    }

    @Test
    public void shouldHashMultiMapWork() {
        HashMultimap<Integer, String> map = HashMultimap.create();
        map.put(1, "a");
        map.put(1, "b");
        map.put(2, "k");
        map.put(3, "x");
        map.put(3, "y");
        map.put(3, "ya");
        System.out.println(map);
        Assertions.assertThat(map.get(3)).contains("ya", "y", "x");
        Assertions.assertThat(map.get(99)).isEmpty();
        Assertions.assertThat(map.containsValue("x")).isTrue();
        Assertions.assertThat(map.keySet()).contains(1, 2, 3);
        System.out.println(map.keys());

    }

    @Test
    public void shouldCollectionOperartionWork() {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 1, 2);
        Assertions.assertThat(Iterables.frequency(intList, 1)).isEqualTo(2);
        Integer[] intArray = Iterables.toArray(intList, Integer.class);
        Assertions.assertThat(intArray).contains(1, 2, 3, 4, 5, 1, 2);
    }
    
    
   
    
}

class Programmer {
    private String language;
    private String email;

    public Programmer(String language, String email) {
        super();
        this.language = language;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
