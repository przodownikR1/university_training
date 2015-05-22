/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.scalatech.test.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyImage implements Image {

    private RealImage image = null;
    private String filename = null;

    public ProxyImage(final String FILENAME) {
        filename = FILENAME;
    }
    @Override
    public void displayImage() {
        if (image == null) {    
            image = new RealImage(filename);
        }
        image.displayImage();
    }
}
