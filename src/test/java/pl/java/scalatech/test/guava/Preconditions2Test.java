package pl.java.scalatech.test.guava;

import jdk.nashorn.internal.ir.annotations.Ignore;

import org.fest.assertions.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.common.base.Preconditions;

public class Preconditions2Test {
    private int[] values = new int[10];
    private final String login = null;
    private final int first = 2;
    private final int second = 1;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldPlainJavaValidationNPEThrow() {
        exception.expect(NullPointerException.class);
        if (null == login) { throw new NullPointerException("login must not be null"); }
    }

    @Test
    public void shouldPlainJavaValidationIllegalArgumentExceptionThrow() {
        exception.expect(IllegalArgumentException.class);
        if (first >= second) { throw new IllegalArgumentException("fist (" + first + ") must be smaller than second (" + second + ")"); }
    }

    @Test
    public void shouldNotNullValid() {
        String name = "przodownik";
        String returned = Preconditions.checkNotNull(name, " null");
        Assertions.assertThat(returned).isEqualTo(name);
    }

    @Test
    public void shouldGuavaPreconditionsCheckNPEThrow() {
        exception.expect(NullPointerException.class);
        Preconditions.checkNotNull(login, "login must not be null");
    }

    @Test
    public void shouldGuavaPreconditionsCheckIllegalArgumentThrow() {
        exception.expect(IllegalArgumentException.class);
        Preconditions.checkArgument(first < second, "first (%s) must be smaller than second (%s)", first, second);
    }

    @Test
    @Ignore
    public void shouldPlainJavaAsserts() {
        assert (null != login) : "login must not be null";
        assert (first < second) : "first (" + first + ") must be smaller than second (" + second + ")";
    }

    @Test
    public void shouldThrowIndexOutOfBoundsException() {
        int index = 11;
        exception.expect(IndexOutOfBoundsException.class);
        Preconditions.checkElementIndex(index, values.length, "Index out of bounds for values");
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        int valueToSet = 20;
        int currentIndex = 0;
        exception.expect(IllegalArgumentException.class);
        Preconditions.checkArgument(valueToSet <= 10, "Value can't be more than 10");
        values[currentIndex] = valueToSet;
    }
}