package pl.java.scalatech.test.exception;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

/**
 * @author Sławomir Borowiec 
 * Module name : university_training
 * Creating time :  15 kwi 2015 00:28:25
 
 */
@Slf4j
public class TryThrowTest {
    @Test //ex -> toString , omit stacktrace
    public void shouldThrowExceptionAndMessage() {
        try {
            throw new IllegalStateException("  invoking method in wrong place ....");
        } catch (IllegalStateException e) {
            //log4j problem log.info(e) //this case in slf4j not compile !!! 
            log.info("" + e); 
           
        }
    }

    @Test
    public void shouldRightThrowExceptionAndMessage() {
        try {
            throw new IllegalStateException("  invoking method in wrong place ....");
        } catch (IllegalStateException e) {
            log.info("{}", e);
        }
    }
    @Test
    public void shouldLoggerWork(){
        log.info("hello world !!");
    }
    @Test
    public void shouldServiceThrowExceptionBad(){
        //given
        SampleService ss = new SampleService();
        try{
            ss.print();
        }catch(Exception e){
           e.printStackTrace();
        }
    }
    @Test
    public void shouldServiceThrowExceptionCheckRight(){
        //given
        SampleService ss = new SampleService();
        try{
            ss.print();
        }catch(Exception e){
           throw new RuntimeException(e.getMessage(),e);
        }
    }
}
