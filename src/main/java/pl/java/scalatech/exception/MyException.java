package pl.java.scalatech.exception;

public class MyException extends RuntimeException {
    /**
*
*/
    private static final long serialVersionUID = 4076033008401452133L;

    public MyException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public MyException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public MyException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}