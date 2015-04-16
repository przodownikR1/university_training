package pl.java.scalatech.test.tryWithResourceRethrow;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReThrowTest {
  //imprecise rethrow.
  //must use "throws Exception"
    public static void imprecise() throws Exception{
        try {
            new SimpleDateFormat("yyyyMMdd").parse("foo");
            new FileReader("file.txt").read();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            throw e;
        }
    }
  //java 7: precise rethrow.
  //no longer "throws Exception"
    public static void precise() throws ParseException, IOException{
        try {
            new SimpleDateFormat("yyyyMMdd").parse("foo");
            new FileReader("file.txt").read();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            throw e;
        }
    }
    public static void precise2() throws IOException{
        try {
            new SimpleDateFormat("yyyyMMdd").parse("foo");
            new FileReader("file.txt").read();
        } catch(ParseException e){
            System.out.println("Parse Exception");
        }catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            throw e;
        }
    }
    
/*    public static void java6(String[] args) throws IOException, SQLException {
        try {
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
            throw ex;
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
            throw ex;
        }
        -------------
        public static void java6Too(String[] args) throws Exception {
        try {
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            throw ex;
        }
        public static void java7(String[] args) throws IOException, SQLException{
        try {
        } catch (final Exception ex) {
            System.err.print(ex.getMessage());
            throw ex;
        }
}
}
}*/
    
    public static void main(String[] args) throws Exception {
        //imprecise();
        //precise2();
        precise();
    }
}
