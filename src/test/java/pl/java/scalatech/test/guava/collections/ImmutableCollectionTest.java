package pl.java.scalatech.test.guava.collections;

import static com.google.common.collect.Ordering.natural;
import static com.google.common.collect.Sets.newHashSet;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ImmutableCollectionTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    
    Set<String> orginal = newHashSet("slawek","bak","yamaha");
    @Test
    public void shouldImmutableWork() {
       Set<String> copyImmutable = ImmutableSet.copyOf(orginal); //guava
       Set<String> unmodifiable = java.util.Collections.unmodifiableSet(orginal); //java

       orginal.remove("bak");
       assertThat(copyImmutable).contains("slawek","bak","yamaha");
       assertThat(unmodifiable).contains("slawek","yamaha");

    }
    
  
    @Test
    public void whenCreatingImmutableMap_thenCorrect() {
        Map<String, Integer> salary = ImmutableMap.<String, Integer> builder()
          .put("John", 1000)
          .put("Jane", 1500)
          .put("Tom", 2000)
          .build();
     
       assertThat(salary.get("John").intValue()).isEqualTo(1000);
      
        
    }
    @Test
    public void shouldErrorExceptonWhenModifyCollection(){
        thrown.expect(UnsupportedOperationException.class);
        Map<String, Integer> salary = ImmutableMap.<String, Integer> builder()
                .put("John", 1000)
                .build();
        salary.put("slawek", 1222);
    }
    
    @Test
    public void shouldModifyCollection(){
        Map<Integer, Wrapper> salary = ImmutableMap.<Integer,Wrapper> builder()
                .put(1,new Wrapper("slawek", 2))
                .put(2,new Wrapper("piotr", 2))
                .build();
        salary.get(1).setName("karol");
        log.info("{}",salary);
    }
    
    @Test
    public void shouldOrderCollection() {
        ImmutableSortedMap<String, Integer> salary = new ImmutableSortedMap
          .Builder<String, Integer>(natural()) //up and low letter !!!!
          .put("John", 1000)
          .put("slawek", 1500)
          .put("Ala", 150)
          .put("Tom", 2000)
          .build();
     
        assertThat(salary.firstKey()).isEqualTo("Ala");
        assertThat(salary.lastEntry().getValue().intValue()).isEqualTo(1500);
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Wrapper {
        private String name;
        private int value;
    }
}
