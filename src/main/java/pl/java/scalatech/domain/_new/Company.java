package pl.java.scalatech.domain._new;

import java.io.ByteArrayOutputStream;
import java.util.List;

import lombok.Cleanup;
import lombok.Data;
import lombok.SneakyThrows;
import pl.java.scalatech.domain.old.Person;

@Data(staticConstructor="of")
public class Company {
    private final Person founder;
    private String name;
    private List<Person> employees;

    @SneakyThrows
    public void testCleanUp() {

            @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(new byte[] {'Y','e','s'});
            System.out.println(baos.toString());

    }

    /*
     * public void testCleanUp() {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(new byte[]{'Y', 'e', 's'});
            System.out.println(baos.toString());
        } finally {
            baos.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
     */



}