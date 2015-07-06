package pl.java.scalatech.test.guava;

import static com.google.common.collect.Maps.newHashMap;
import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class JoinTest {
    private List<String> strs = Lists.newArrayList("slawek", "borowiec");
    private final static String RESULT = "slawek, borowiec";

    @Before
    public void init() {
        strs = Lists.newArrayList("slawek", "borowiec");
    }

    @Test
    public void shouldJoinOldWayWork() {
        Assertions.assertThat(buildString(strs, ", ")).isEqualTo(RESULT);
        Assertions.assertThat(buildStringOld(strs)).isEqualTo(RESULT);
    }

    public String buildStringOld(List<String> strs) {
        String result = null;
        StringBuffer buffer = new StringBuffer();
        for (String str : strs) {
            if (str != null) {
                buffer.append(str);
                buffer.append(", ");
            }
        }
        if (buffer.length() >= 2) {
            result = buffer.substring(0, buffer.length() - 2);
        }
        return result.toString();
    }

    public String buildString(List<String> stringList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (String s : stringList) {
            if (s != null) {
                builder.append(s).append(delimiter);
            }
        }
        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    @Test
    public void shouldGuavaJoinWork() {
        String res = Joiner.on(", ").skipNulls().join(strs);
        assertThat(res).isEqualTo(RESULT);
    }

    @Test
    public void shouldJoinFeaturesWork() {
        List<String> strs = Lists.newArrayList("slawek", null, "boorwiec");
        String result = Joiner.on("|").useForNull("empty").join(strs);
        assertThat("slawek|empty|boorwiec").isEqualTo(result);

    }

    @Test
    public void shouldJoinFeatures2Work() {
        List<String> strs = Lists.newArrayList("slawek", null, "borowiec");
        String returned = Joiner.on("|").skipNulls().join(strs);
       assertThat("slawek|borowiec").isEqualTo(returned);

    }

    @Test
    public void shouldJoinWithStringBuilderCooperation() {
        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on("|").skipNulls();
        joiner.appendTo(stringBuilder, "slawek", null, "borowiec");
        assertThat(stringBuilder.toString()).isEqualTo("slawek|borowiec");
    }

    @Test
    public void shoudlJoinToFileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("join.txt"));
        List<String> list = Lists.newArrayList("slawek", null, "borowiec");
        Joiner joiner = Joiner.on("#").useForNull("empty");
        joiner.appendTo(fileWriter, list);
        fileWriter.close();
        assertThat(Files.readFirstLine(new File("join.txt"), Charset.defaultCharset())).isEqualTo("slawek#empty#borowiec");
    }
    @Test
    public void shouldJoinWithMap(){
        Map<Integer,String> map = newHashMap();
        map.put(1, "yamaha");
        map.put(2, "suzuki");
        map.put(3, "honda");
        String joined = Joiner.on(", ").withKeyValueSeparator(" => ").join(map);
        assertThat(joined).isEqualTo("1 => yamaha, 2 => suzuki, 3 => honda");
    }

}
