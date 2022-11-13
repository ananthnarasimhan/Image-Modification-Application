package imagesmodel;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class represents the smudging of images such as mosiac and pixelation.
 * 
 * @author ananth
 *
 */
public class ColorSmudge {
  private static int calcDist(int sx, int sy, int dx, int dy) {
    return (((dx - sx) * (dx - sx)) + ((dy - sy) * (dy - sy)));
  }

  private static int[] closest(Set<int[]> seedsList, int i, int j) {
    int minx = 0;
    int miny = 0;
    int minDist = Integer.MAX_VALUE;
    for (int[] k : seedsList) {
      if (minDist > calcDist(i, j, k[0], k[1])) {
        minDist = calcDist(i, j, k[0], k[1]);
        minx = k[0];
        miny = k[1];
      }
    }
    return new int[] { minx, miny };
  }

  private static boolean chkpresent(Set<int[]> seedsList, int i, int j) {

    for (int[] k : seedsList) {
      if (k[0] == i && k[1] == j) {
        return true;
      }
    }
    return false;
  }

  private static int[][][] colorMatrix(int[][][] image, Set<int[]> seedsList) {
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[0].length; j++) {
        if (chkpresent(seedsList, i, j)) {
          continue;
        }
        int[] closest = closest(seedsList, i, j);
        for (int c = 0; c < 3; c++) {
          image[i][j][c] = image[closest[0]][closest[1]][c];
        }
      }
    }
    return image;
  }

  /**
   * This method implements the performing operation to get a mosaic of the image.
   * 
   * @param image the image on which we need to perform mosaic
   * @param seeds The number of seeds in the mosaic
   * @return the image in matrix form after the operation
   */
  public static int[][][] imageMosaic(int[][][] image, int seeds) {
    if (image == null) {
      throw new IllegalArgumentException("image should be non null");
    }
    if (seeds < 0) {
      throw new IllegalArgumentException("Negative seeds not possible");
    }
    if (seeds > image[0].length * image.length) {
      throw new IllegalArgumentException("number of seeds greater than number of pixels");
    }
    Random randNum = new Random();
    Set<int[]> seedsList = new LinkedHashSet<int[]>();
    while (seedsList.size() < seeds) {
      int randomNumber = randNum.nextInt(image.length * image[0].length) + 1;
      int divisor = Math.max(image.length, image[0].length);
      seedsList.add(new int[] { randomNumber / divisor, randomNumber % divisor });
    }

    return colorMatrix(image, seedsList);
  }

  /**
   * This method implements the performing operation to get a pixellation of the
   * image.
   * 
   * @param image          the image on which we need to perform pixellation
   * @param numberOfChunks The blocks across the row
   * @return The image in matrix form after pixellation
   */
  public static int[][][] imagePixelation(int[][][] image, int numberOfChunks) {

    if (image == null) {
      throw new IllegalArgumentException("image should be non null");
    }
    if (numberOfChunks > Math.min(image.length, image[0].length)) {
      throw new IllegalArgumentException("number of boxes greater than possible to accomodate");
    }
    Set<int[]> seedsList = new LinkedHashSet<int[]>();
    int lengthOfChunk = image[0].length / numberOfChunks;
    int i = 0;
    int j = 0;
    while (i < image.length) {
      j = 0;
      while (j < image[0].length) {
        seedsList.add(new int[] { (i + ((Math.min(lengthOfChunk, image.length - i)) / 2)),
            (j + ((Math.min(lengthOfChunk, image[0].length - j)) / 2)) });
        j = j + lengthOfChunk;
      }
      i = i + lengthOfChunk;
    }
    return colorMatrix(image, seedsList);
  }
}
