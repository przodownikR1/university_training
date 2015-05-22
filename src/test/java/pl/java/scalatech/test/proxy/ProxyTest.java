/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.scalatech.test.proxy;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void shouldProxyest() {
        //given
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
        //when
        image1.displayImage(); // loading necessary
        image1.displayImage(); // loading unnecessary
        image2.displayImage(); // loading necessary
        image2.displayImage(); // loading unnecessary
        image1.displayImage(); // loading unnecessary
    }
}
