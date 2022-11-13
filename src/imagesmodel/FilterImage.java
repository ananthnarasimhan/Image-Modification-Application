package imagesmodel;

/**
 * This is class represents the filtering of images.
 * 
 * @author ananth
 *
 */
public class FilterImage {

  private static int[][][] filterMatrixMultiplier(int[][][] imageMatrix, double[][] filter) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    if (filter == null) {
      throw new IllegalArgumentException("filter can't be null");
    }
    int[][][] temp = new int[imageMatrix.length][imageMatrix[0].length][3];
    double total;
    int center = filter.length / 2;
    for (int color = 0; color < 3; color++) {
      for (int i = 0; i < imageMatrix.length; i++) {
        for (int j = 0; j < imageMatrix[0].length; j++) {
          total = 0;
          for (int a = 0; a <= filter.length / 2; a++) {
            for (int b = 0; b <= filter.length / 2; b++) {
              if (a == 0 & b == 0) {
                total += imageMatrix[i][j][color] * filter[center][center];
                continue;
              }
              if (a == 0 && b >= 1) {
                if ((j - b) >= 0) {
                  total += imageMatrix[i][j - b][color] * filter[center - a][center - b];
                }
                if ((j + b) < imageMatrix[0].length) {
                  total += imageMatrix[i][j + b][color] * filter[center - a][center + b];
                }
                continue;
              }
              if (a > 0 && b == 0) {
                if ((i - a) >= 0) {
                  total += imageMatrix[i - a][j][color] * filter[center - a][center + b];

                }
                if ((i + a) < imageMatrix.length) {
                  total += imageMatrix[i + a][j][color] * filter[center + a][center - b];

                }
                continue;
              }

              if ((i - a) >= 0 && (j - b) >= 0) {
                total += imageMatrix[i - a][j - b][color] * filter[center - a][center - b];
              }
              if ((i - a) >= 0 && (j + b) < imageMatrix[0].length) {
                total += imageMatrix[i - a][j + b][color] * filter[center - a][center + b];
              }
              if ((i + a) < imageMatrix.length && (j - b) >= 0) {
                total += imageMatrix[i + a][j - b][color] * filter[center + a][center - b];
              }
              if ((i + a) < imageMatrix.length && (j + b) < imageMatrix[0].length) {
                total += imageMatrix[i + a][j + b][color] * filter[center + a][center + b];
              }

              temp[i][j][color] = Math.min(Math.max(0, (int) total), 255);
            }
          }
        }
      }
    }
    temp = FilterImage.clampImage(temp, 0, 255);
    return temp;
  }

  /**
   * This method is used to blur the images.
   * 
   * @param imageMatrix The image matrix which needs to be blurred
   * @return The image matrix after blurring.
   */
  public static int[][][] blurImages(int[][][] imageMatrix) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    double[][] blurImageFilterKernel = new double[][] { { 0.0625, 0.125, 0.0625 },
        { 0.125, 0.25, 0.125 }, { 0.0625, 0.125, 0.0625 } };
    imageMatrix = filterMatrixMultiplier(imageMatrix, blurImageFilterKernel);
    return imageMatrix;
  }

  /**
   * This method is used to clamp the values of colors in the images.
   * 
   * @param imgMatrix The image matrix which needs to be clamped
   * @param min       The minimum value of the clamping
   * @param max       The maximum value of clamping
   * @return The image matrix after clamping
   */
  public static int[][][] clampImage(int[][][] imgMatrix, int min, int max) {
    if (imgMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    if (min < 0 || max > 255) {
      throw new IllegalArgumentException("error in input");
    }
    for (int c = 0; c < 3; c++) {
      for (int i = 0; i < imgMatrix.length; i++) {
        for (int j = 0; j < imgMatrix[0].length; j++) {
          if (imgMatrix[i][j][c] < min) {
            imgMatrix[i][j][c] = min;
          } else if (imgMatrix[i][j][c] > max) {
            imgMatrix[i][j][c] = max;
          }
        }
      }
    }

    return imgMatrix;
  }

  /**
   * This method is used to sharpen the images.
   * 
   * @param imageMatrix The image matrix which needs to be sharpened
   * @return The image matrix after sharpening.
   */
  public static int[][][] sharpenImage(int[][][] imageMatrix) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    double[][] sharpenImageFilterKernel = new double[][] {
        { -0.125, -0.125, -0.125, -0.125, -0.125 }, { -0.125, 0.25, 0.25, 0.25, -0.125 },
        { -0.125, 0.25, 1, 0.25, -0.125 }, { -0.125, 0.25, 0.25, 0.25, -0.125 },
        { -0.125, -0.125, -0.125, -0.125, -0.125 } };

    imageMatrix = filterMatrixMultiplier(imageMatrix, sharpenImageFilterKernel);
    return imageMatrix;
  }
}
