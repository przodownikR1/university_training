package pl.java.scalatech.test.observer;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;
import org.junit.Test;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

abstract class MyObserverable extends Observable{
    public abstract void setData(String data);
}

@Slf4j
class DataStore extends MyObserverable
{
    private String data;   
    public String getData()
    {
        return data;
    }
    public void setData(String data)
    {
        this.data =data;
        //mark the observable as changed
        setChanged();
        this.notifyObservers(data+" test args"); //arg
    }   
}
@Slf4j
class DataStoreNext extends MyObserverable
{
    private String data;   
    public String getData()
    {
        return data;
    }
    public void setData(String data)
    {
        this.data =data;
        setChanged();
        this.notifyObservers();
    }   
}
@Slf4j
class Screen implements Observer {

    @Override
    public void update(Observable o, Object arg) {
           log.info("Notification that something has changed in  :  {} , arg {} ",o.toString(),arg);
    }

}
@Slf4j
public class ObserverTest {
 @Test
 public void shouldObserverWork() {
     log.info("start test");
     Screen screen = new Screen();
     List<MyObserverable> obser = Lists.newArrayList(new DataStore(),new DataStoreNext());
     obser.forEach(o->o.addObserver(screen));
     obser.forEach(new Consumer<MyObserverable>() { //show how to convert to lamba expression

        @Override
        public void accept(MyObserverable t) {
              t.setData("slawek");
            
        }
    });
     
 }
}
