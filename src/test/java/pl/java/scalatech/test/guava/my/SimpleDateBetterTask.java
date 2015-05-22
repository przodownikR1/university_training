package pl.java.scalatech.test.guava.my;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Task {

    private String name;
    private LocalDate localDate;

}

@AllArgsConstructor
class Service {
    private Task task;

    public void doSomethingWithTask() {
               //task.getLocalDate().getYear()setYear(2013); 
               //task.getDate().setMonth(1);
                  
    }

}
@Slf4j
public class SimpleDateBetterTask {
    private Task task;
    private Service evilService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    @Before
    public void init() {
        task = new Task("slawek", LocalDate.now());
        evilService = new Service(task);
    }
    
    @Test
    public void shouldDateBroken() { 
       log.info("+++ before task time : {}",task.getLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
       log.info("+++ before full  task time : {}",task.getLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
       log.info("+++ before short time : {}",task.getLocalDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
       evilService.doSomethingWithTask();
       log.info("+++ after task time : {}",task.getLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
       
    }
}