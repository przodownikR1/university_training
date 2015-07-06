package pl.java.scalatech.test;

import java.util.List;
import java.util.Set;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class PredicateTest {

     final ImmutableList<String> names = ImmutableList.of("slawek", "tomek", "ela", "ala", "maciek", "staszek", "tomek", "bolek", "lolek",
                "agnieszka", "prometeusz");
    
        Predicate<String> onlyNameWithGreaterThanFive = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                if (input.length() > 5) { return true; }
                return false;
            }
        };
        
        
        Predicate<String> startOnS = new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                if (input.startsWith("s")) { return true; }
                return false;
            }
        };
        
        @Test
        public void testPArtirion(){
            List<List<String>> subList = Lists.partition(names,2);
            System.out.println(" subList" + subList);
        }
        
        
        public void iterableTest(){
            Iterables.any(names, new Predicate<String>() {
                @Override
                public boolean apply(String s) {
                    return s.startsWith("a");
                }
            }); //
        }
        
        @Test
        public void addTest(){
           Set<String> ss = Sets.newHashSet(names);
           Set<String> narrowNames = Sets.filter(ss, onlyNameWithGreaterThanFive);
           for(String s : narrowNames ){
               System.out.println("now first : "+s);
           }
           ss.add("sdrere");
           for(String s : narrowNames ){
               System.out.println("now after : "+s);
           }
        }
    
        @Test
        public void predicateTest() {
            Iterable<String> narrowNames = Iterables.filter(names, onlyNameWithGreaterThanFive);
            Assertions.assertThat(narrowNames).contains("slawek","maciek","staszek","agnieszka","prometeusz");
            Assertions.assertThat(Iterables.filter(names,Predicates.and(onlyNameWithGreaterThanFive,startOnS))).contains("slawek", "staszek");
         
            System.out.println("or(onlyNameWithGreaterThanFive,startOnS) " + Iterables.filter(names,Predicates.or(onlyNameWithGreaterThanFive,startOnS)));
            Predicate alwaysTrue=Predicates.alwaysTrue();
            Assertions.assertThat(alwaysTrue.apply(123)).isTrue();
            Assertions.assertThat(alwaysTrue.apply("abc")).isTrue();
            
        }

}
