package pl.java.scalatech.test.guava.collections;

import static com.google.common.collect.Lists.partition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DivideCollectionIntoSmallerPartTest {
    List<String> names = newArrayList("slawek", "bak", "kasia", "ola", "edyta", "tomek", "jacek", "piotr");

    @Test
    public void shouldDivideListIntoSmallerPart() {

        for (List<String> parts : partition(names, 3)) {
            for (String p : parts) {
                log.info("{} , {}", p, parts);
            }
        }

    }

    @Test
    public void shouldPartitionWork() {
        List<List<String>> result = partition(names, 2);

        result.forEach(l -> log.info("{}", l));
        List<String> lastPartition = result.get(3);
        log.info("last : {}", lastPartition);

    }

    @Test
    public void shouldManipulateOnOrginalListWork() {
        List<List<String>> result = partition(names, 2);
        names.add("end");
        result.forEach(l -> log.info("{}", l));
        assertThat(result.get(4)).contains("end");

    }

}
