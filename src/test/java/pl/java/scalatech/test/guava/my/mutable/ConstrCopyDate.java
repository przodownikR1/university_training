package pl.java.scalatech.test.guava.my.mutable;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;



class TaskOne {
    private final String name;
    
    private final Date date;
    public TaskOne(final String name, final Date date) {
        this.name = name;
        this.date = date;
    }
    public Date getDate() {
        return new Date(date.getTime());
    }
    
}

@AllArgsConstructor
class ServiceOne {
    private TaskOne task;

    public void doSomethingWithTask() {
               task.getDate().setYear(2013); 
               task.getDate().setMonth(1);
                  
    }

}
@Slf4j
public class ConstrCopyDate {
    private TaskOne task;
    private ServiceOne evilService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
    @Before
    public void init() {
        task = new TaskOne("slawek", new Date());
        evilService = new ServiceOne(task);
    }
    
    @Test
    public void shouldDateBroken() { 
       log.info("+++ before task time : {}",sdf.format(task.getDate()));
       evilService.doSomethingWithTask();
       log.info("+++ after task time : {}",sdf.format(task.getDate()));
       
    }
}
