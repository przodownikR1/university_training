package pl.java.scalatech.test.exercise;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static java.util.Collections.singleton;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
@Slf4j
public class CleanMapTest {

    private Map<String,String> map= newHashMap();
    @Before
    public void init() {
        map.put("slawek", "borowiec");
        map.put("marek", null);
        map.put("kasia", "");
        map.put("agnieszka", "borowiec");
        map.put(null, "value1");
        map.put("", "value2");
    }
    
    BiFunction<String, String, String> myFunction = (key,value) -> (Strings.isNullOrEmpty(value)) ? "empty" : "set";
    
    @Test
    public void shouldComputeWork() {
      map.compute("kasia", myFunction);
      map.compute("marek", myFunction);
      map.entrySet().stream().forEach(x->log.info("key : {} # value : {}",x.getKey(),x.getValue()));
    }
    
    @Test
    public void shouldRemoveNullAndEmptyString() {
        
      //given
      assertThat(map).hasSize(6);
      map.values().remove(null);
      assertThat(map).hasSize(5);
      map.values().remove("");
      map.remove(null);
      map.entrySet().stream().forEach(x->log.info("key : {} # value : {}",x.getKey(),x.getValue())); 
      assertThat(map).hasSize(3);
        
    }
    
    @Test
    public void shouldRemoveNullAndEmptyString2() {
       map.values().removeAll(Collections.singleton(null));
       Assertions.assertThat(map).excludes(entry("marek", null));
    }
    
    @Test
    public void shouldRemoveNullFromList () {

        List<String> strings = newArrayList("slawek",null,"borowiec");        
        strings.removeAll(singleton(null));
        Assertions.assertThat(strings).hasSize(2); 
       
    }
    
    @Test
    public void shouldRemoveNullFromListJava8 () {

        List<String> strings = newArrayList("slawek",null,"borowiec");        
        strings = strings.stream().filter(s->s!=null).collect(Collectors.toList());
        Assertions.assertThat(strings).hasSize(2); 
       
    }
    
    @Test
    public void shouldRemoveNullFromListJava8Static () {

        List<String> strings = newArrayList("slawek",null,"borowiec");        
        strings = strings.stream().filter(Objects::nonNull).collect(Collectors.toList());
        Assertions.assertThat(strings).hasSize(2); 
       
    }
    @Test
    public void emptyMap() {
        Map<String, String> errors = Maps.newHashMap();
        errors.put("Error Code", null);
        errors.values().remove("null");
        errors.values().remove("");        
        String result = on(",").withKeyValueSeparator("=").useForNull("test").join(errors);
        log.info("+++ reuslt : {}",result);
        
    }
    
}
