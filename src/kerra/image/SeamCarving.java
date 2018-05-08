package kerra.image;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class SeamCarving {

    public static void seamCarve(String file, String save, int seams) throws IOException {
        BufferedImage img = ImageIO.read(new File(file));
        img = seamCarve(img, seams);
        store(img, save);
    }


    public static BufferedImage seamCarve(BufferedImage img, int seams) {
        int[] seam;
        float[][] costs;

        for (int n = 0; n < seams; n++) {
            costs = computeCosts(img);
            seam = computeSeam(costs);
            img = removeSeam(img, seam);
        }
        return img;
    }

    /**
     * Computes a table that, for each pixel, stores the smallest cost for
     * a vertical seam that goes through that pixel. Uses dynamic programming
     * by stepping through all rows from top to bottom of the image. The cost
     * for introducing a seam at each pixel is determined using the energy()
     * method below.
     *
     * @param img the input image
     * @return the table storing the costs
     */
    private static float[][] computeCosts(BufferedImage img)
    {
        float[][] costs = new float[img.getHeight()][img.getWidth()];

        for (int y = 0; y < costs.length; y++) for (int x = 0; x < costs[0].length; x++)
            if (y == 0) costs[y][x] = energy(img, x, y);
            else if (x == 0) costs[y][x] = energy(img, x, y) + Math.min(costs[y - 1][x], costs[y - 1][x + 1]);
            else if (x == costs[0].length-1) costs[y][x] = energy(img, x, y) + Math.min(costs[y - 1][x - 1], costs[y - 1][x]);
            else costs[y][x] = energy(img, x, y) + Math.min(costs[y - 1][x - 1], Math.min(costs[y - 1][x], costs[y - 1][x + 1]));

        return costs;
    }

    /**
     * Reconstructs a vertical seam from the cost table. A vertical seam is stored
     * as an array where element y in the array stores an index seam[y], which indicates
     * that in row y the seam goes through column seam[y].
     *
     * @param costs the cost table
     * @return the seam
     */
    private static int[] computeSeam(float[][] costs) {
        int seam[] = new int[costs.length];

        int top = costs.length - 1;
        float best = costs[top][0];
        for (int x = 1; x < costs[0].length; x++)
            if (costs[top][x] < best) {
                seam[top] = x;
                best = costs[top][x];
            }

        int x = seam[top];
        for (int y = costs.length - 2; y >= 0; y--) {
            if (x == 0) seam[y] = (costs[y][x] <= costs[y][x+1]) ? x : x+1;

            else if (x == costs[0].length-1) seam[y] = (costs[y][x-1] <= costs[y][x]) ? x-1 : x;

            else if (costs[y][x-1] <= costs[y][x] && costs[y][x-1] <= costs[y][x+1]) seam[y] = x-1;
            else if (costs[y][x] <= costs[y][x-1] && costs[y][x] <= costs[y][x+1]) seam[y] = x;
            else if (costs[y][x+1] <= costs[y][x] && costs[y][x+1] <= costs[y][x-1]) seam[y] = x+1;

            x = seam[y];
        }
        return seam;
    }


    /**
     * Removes a vertical seam from the image. The seam is an array that stores
     * for each row y in the image the index of the column where the seam lies.
     * The resulting image after removing the seam has one column less than
     * the original (its width is reduced by one).
     *
     * @param img the input image
     * @param seam the seam to be removed
     * @return the new image
     */
    private static BufferedImage removeSeam(BufferedImage img, int[] seam)
    {
        int width, height;
        width = img.getWidth();
        height = img.getHeight();

        // The width of the new image is reduced by one
        BufferedImage newImg = new BufferedImage(width-1, height, BufferedImage.TYPE_INT_RGB);

        // For all rows in the image
        for(int y=0; y<height; y++) {
            for(int x=0; x<seam[y]; x++) newImg.setRGB(x, y, img.getRGB(x, y));
            // Skip seam and copy the rest of the columns
            for(int x=seam[y]; x<width-1; x++) newImg.setRGB(x, y, img.getRGB(x + 1, y));
        }
        return newImg;
    }

    /**
     * Computes the energy of a pixel in the image. This energy is used as the cost
     * for introducing a seam at this pixel. The energy here approximates the sum
     * of the absolute values of the first derivatives of the image in x and y direction.
     *
     * @param img the input image
     * @param x x-coordinate of the pixel
     * @param y y-coordinate of the pixel
     * @return energy of the pixel
     */
    private static float energy(BufferedImage img, int x, int y)
    {
        int width = img.getWidth();
        int height = img.getHeight();

        if(x<0 || x>=width || y<0 || y>=height)
            return 0.f;

        float c0[],c1[];
        c0 = new float[3];
        c1 = new float[3];
        float didx = 0.f;
        float didy = 0.f;

        if (x+1 < width) {
            for (int i=0; i<c0.length; i++) c0[i] = e(img, i, x, y);
            for (int i=0; i<c1.length; i++) c1[i] = e(img, i, x+1, y);
        } else {
            for (int i=0; i<c0.length; i++) c0[i] = e(img, i, x-1, y);
            for (int i=0; i<c1.length; i++) c1[i] = e(img, i, x, y);
        }

        for(int i=0; i<3; i++) didx += ((c1[i] - c0[i]) * (c1[i] - c0[i]));
        didx = (float)Math.sqrt(didx);

        if(y+1<height) {
            for (int i=0; i<c0.length; i++) c0[i] = e(img, i, x, y);
            for (int i=0; i<c1.length; i++) c1[i] = e(img, i, x, y+1);
        } else {
            for (int i=0; i<c0.length; i++) c0[i] = e(img, i, x, y-1);
            for (int i=0; i<c1.length; i++) c1[i] = e(img, i, x, y);
        }

        for(int i=0; i<3; i++) didy += ((c1[i] - c0[i]) * (c1[i] - c0[i]));
        didy = (float)Math.sqrt(didy);

        return didx+didy;
    }

    private static float e(BufferedImage img, int op, int x, int y) {
        switch (op) {
            case 0: return (float)(img.getRGB(x, y) & 0xFF);
            case 1: return (float)((img.getRGB(x, y) >> 8) & 0xFF);
            case 2: return (float)((img.getRGB(x, y) >> 16) & 0xFF);
            default:
                throw new UnsupportedOperationException();
        }
    }


    private static void store(BufferedImage img, String save) throws IOException {
        ImageIO.write(img, "jpg", new File(save));
    }
}
