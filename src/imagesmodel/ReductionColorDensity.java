package imagesmodel;

/**
 * This class represents dithering of images.
 * 
 * @author ananth
 *
 */
public class ReductionColorDensity {

  private static int findClosetPaltteColor(int color) {
    final int[] colorPalatte = new int[] { 0, 36, 72, 108, 144, 180, 216, 255 };
    if (color < 0) {
      return 0;
    }
    if (color > 255) {
      return 255;
    }
    for (int i = 0; i < colorPalatte.length - 1; i++) {
      if (color >= colorPalatte[i] && color < colorPalatte[i + 1]) {
        int diff1 = color - colorPalatte[i];
        int diff2 = colorPalatte[i + 1] - color;
        if (diff1 < diff2) {
          return colorPalatte[i];
        }
        return colorPalatte[i + 1];
      }

    }
    return 255;
  }

  /**
   * This method is used to dither the image.
   * 
   * @param imageMatrix The input image which needs to be dithered
   * @return The image matrix after dithering
   */
  public static int[][][] ditherImage(int[][][] imageMatrix) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }

    int oldColor;
    int newColor;
    int error;
    for (int c = 0; c < 3; c++) {
      for (int i = 0; i < imageMatrix.length; i++) {
        for (int j = 0; j < imageMatrix[0].length; j++) {
          oldColor = imageMatrix[i][j][c];
          newColor = findClosetPaltteColor(oldColor);
          error = oldColor - newColor;
          imageMatrix[i][j][c] = newColor;

          if (j + 1 < imageMatrix[0].length) {
            imageMatrix[i][j + 1][c] += (int) ((0.4375) * error);
          }
          if ((i + 1) < imageMatrix.length && (j - 1) > 0) {
            imageMatrix[i + 1][j - 1][c] += (int) ((0.1875) * error);
          }
          if ((i + 1) < imageMatrix.length) {
            imageMatrix[i + 1][j][c] += (int) ((0.3125) * error);
          }
          if ((i + 1) < imageMatrix.length && (j + 1) < imageMatrix[0].length) {
            imageMatrix[i + 1][j + 1][c] += (int) ((0.0625) * error);
          }

        }
      }
    }

    return imageMatrix;
  }
}
