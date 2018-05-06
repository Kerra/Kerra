package kerra.image;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class SeamCarvingTest {

    private String path = System.getProperty("user.home") + "\\Git\\Github\\Kerra\\testsrc\\kerra\\image";
    private String file = path + "\\1.jpg";
    private String save = path + "\\1_processed.jpg";

    @Test
    void seamCarve() throws IOException {
        SeamCarving.seamCarve(file, save, 200);
    }

    @Test
    void seamCarve2() throws IOException {
        BufferedImage img = ImageIO.read(new File(file));
        img = SeamCarving.seamCarve(img, 200);
        ImageIO.write(img, "jpg", new File(save));
    }
}