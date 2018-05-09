package kerra.image;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class SeamCarvingTest {

    private String path = System.getProperty("user.dir") + "\\testsrc\\kerra\\image\\";
    private String file = path + "test.jpeg";
    private String save = path + "test_processed1.jpg";

    @Test
    void seamCarve() throws IOException {
        SeamCarving.seamCarve(file, save, 99);
    }

    @Test
    void seamCarve2() throws IOException {
        BufferedImage img = ImageIO.read(new File(file));
        img = SeamCarving.seamCarve(img, 200);
        ImageIO.write(img, "jpg", new File(save));
    }
}