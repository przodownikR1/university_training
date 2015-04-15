package pl.java.scalatech.test.guava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.fest.assertions.Assertions;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SplitterTest {
    private String str = "aaa,, bbb,ccc   ,ddd";

    @Test
    public void shouldSplitWork() {
        String str = "{x:1,y:2,z:4,t:g}";
        str = str.substring(1, str.length() - 2);
        Assertions.assertThat(str).isEqualTo("x:1,y:2,z:4,t:");
        Splitter.MapSplitter splitter = Splitter.on(',').omitEmptyStrings().trimResults().withKeyValueSeparator(':');
        Map<String, String> split = splitter.split(str);
        Assertions.assertThat(split.toString()).isEqualTo("{x=1, y=2, z=4, t=}");
    }

    @Test
    public void shouldTrim() {
        String[] split = str.split(",");
        Assertions.assertThat(Arrays.toString(split)).isEqualTo("[aaa, ,  bbb, ccc   , ddd]");
    }

    @Test
    public void shouldGuavaSplit() {
        Assertions.assertThat(Lists.newArrayList(Splitter.on(',').trimResults().omitEmptyStrings().split(str)).toString()).isEqualTo("[aaa, bbb, ccc, ddd]");
    }

    @Test
    public void shouldSplitPattern() {
        String pattern = "\\d+";
        String text = "slawek1borowiec434przodownik";
        List<String> expected = Lists.newArrayList("slawek", "borowiec", "przodownik");
        Iterable<String> values = Splitter.on(Pattern.compile(pattern)).split(text);
        Assertions.assertThat(Lists.newArrayList(values)).isEqualTo(expected);
        text = "4slawek|5borowiec43|4przodownik";
        Iterable<String> values2 = Splitter.on("|").trimResults(CharMatcher.JAVA_DIGIT).split(text);
        Assertions.assertThat(Lists.newArrayList(values2).toString()).isEqualTo("[slawek, borowiec, przodownik]");
    }
  
    @Test
    public void shouldSplitMap() {
        String startSring = "slawek=borowiec#kalina=borowiec#yamaha=R1";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("slawek", "borowiec");
        testMap.put("kalina", "borowiec");
        testMap.put("yamaha", "R1");

        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(startSring);
        Assertions.assertThat(splitMap.toString()).isEqualTo("{slawek=borowiec, kalina=borowiec, yamaha=R1}");

    }
}
