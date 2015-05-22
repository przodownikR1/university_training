package pl.java.scalatech.test.guava.my.mutable;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Task {

    private String name;
    private Date date;

}

@AllArgsConstructor
class Service {
    private Task task;

    public void doSomethingWithTask() {
               task.getDate().setYear(2013); 
               task.getDate().setMonth(1);
                  
    }

}
@Slf4j
public class SimpleDateTask {
    private Task task;
    private Service evilService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    @Before
    public void init() {
        task = new Task("slawek", new Date());
        evilService = new Service(task);
    }
    
    @Test
    public void shouldDateBroken() { 
       log.info("+++ before task time : {}",sdf.format(task.getDate()));
       evilService.doSomethingWithTask();
       log.info("+++ after task time : {}",sdf.format(task.getDate()));
       
    }
}
