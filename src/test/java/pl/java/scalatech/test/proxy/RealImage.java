package pl.java.scalatech.test.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class RealImage implements Image {

    private String filename = null;

    public RealImage(final String FILENAME) {
        filename = FILENAME;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        log.info("Loading from disk  {}" , filename);
    }

    @Override
    public void displayImage() {
        log.info("Displaying {}" , filename);
    }
}
