package pl.java.scalatech.test.exercise;

import org.junit.Test;

import com.google.common.base.StandardSystemProperty;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeparatorTest {

    @Test
    public void shouldEndOfLinePrint() {
      log.info("{}",StandardSystemProperty.LINE_SEPARATOR.value());  
    }
    
}
