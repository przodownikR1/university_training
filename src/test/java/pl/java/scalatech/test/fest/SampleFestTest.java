package pl.java.scalatech.test.fest;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

import org.fest.assertions.Assertions;
import org.junit.Test;
//import static org.assertj.core.api.Assertions.*;
import com.google.common.collect.Lists;

public class SampleFestTest {
    List<Animal> animals = Lists.newArrayList(new Animal("dog",2),new Animal("cat", 3));
    
    @Test
    public void shouldCollectionTest() {
                   
    }
    
    
}
@AllArgsConstructor
class Animal{
    private String name;
    private int age;
    
}