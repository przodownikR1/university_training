package pl.java.scalatech.test.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.Test;

public class PreconditionTest {

    public int oldWay(String message, int scope) {
        if (scope < 0) { throw new IllegalArgumentException("wrong scope value"); }
        if (scope > 3) { throw new IllegalArgumentException("scope may not be greater than 3"); }
        return message.length();
    }

    public int guavaWay(String message, int scope) {
        checkNotNull(message);
        checkArgument(scope >= 0, "wrong scope value");
        checkArgument(scope <= 3, "scope may not be > 3");
        return message.length();
    }
    @Test(expected=NullPointerException.class)
    public void shouldPreconditionThrowNullPointerException(){
        guavaWay (null, 2);
    }
    @Test
    public void shouldPreconditionIllegalArgumentException(){
        guavaWay("przodownik", 1);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldPreconditionThrowIllegalArgumentException(){
        guavaWay("przodownik", 4);
    }
}
