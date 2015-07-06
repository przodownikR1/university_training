package pl.java.scalatech.test.guava.my;

import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;

public class ProfileTest {
    @Test
    public void shouldProfileWork(){
        //System.out.println(System.getProperties());
        Properties p = System.getProperties();
        for (Entry<Object,Object> entry: p.entrySet()) {
            System.out.println(entry.getKey() + "-> "+entry.getKey());
        }
        System.err.println("+++  : "+System.getenv("propTest"));
        System.err.println("+++  : "+System.getProperty("message"));
        System.err.println("+++  : "+System.getProperty("foo"));
    }
}
