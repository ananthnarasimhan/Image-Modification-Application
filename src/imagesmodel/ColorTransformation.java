package imagesmodel;

/**
 * This class represents the the color transformations of images.
 * transformations.
 * 
 * @author ananth
 *
 */
public class ColorTransformation {
  private static double[][] greyScaleFilterKernel = new double[][] { { 0.2126, 0.7152, 0.0722 },
      { 0.2126, 0.7152, 0.0722 }, { 0.2126, 0.7152, 0.0722 } };

  private static double[][] sepiaFilterKernel = new double[][] { { 0.393, 0.769, 0.189 },
      { 0.349, 0.686, 0.168 }, { 0.272, 0.534, 0.131 } };

  private static int[][][] colorMatrixMultiplier(int[][][] imageMatrix, double[][] filter) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    if (filter == null || filter.length < 3) {
      throw new IllegalArgumentException("filter input incorrect");
    }
    for (int i = 0; i < imageMatrix.length; i++) {
      for (int j = 0; j < imageMatrix[0].length; j++) {

        int r = (int) (filter[0][0] * imageMatrix[i][j][0] + filter[0][1] * imageMatrix[i][j][1]
            + filter[0][2] * imageMatrix[i][j][2]);
        int g = (int) (filter[1][0] * imageMatrix[i][j][0] + filter[1][1] * imageMatrix[i][j][1]
            + filter[1][2] * imageMatrix[i][j][2]);
        int b = (int) (filter[2][0] * imageMatrix[i][j][0] + filter[2][1] * imageMatrix[i][j][1]
            + filter[2][2] * imageMatrix[i][j][2]);
        imageMatrix[i][j][0] = Math.min(Math.max(0, r), 255);
        imageMatrix[i][j][1] = Math.min(Math.max(0, g), 255);
        imageMatrix[i][j][2] = Math.min(Math.max(0, b), 255);
      }
    }
    imageMatrix = FilterImage.clampImage(imageMatrix, 0, 255);
    return imageMatrix;
  }

  /**
   * This method is used to convert the image to grey scale.
   * 
   * @param imageMatrix The image matrix which needs to be transformed
   * @return The image matrix after the grey scale transformation
   */
  public static int[][][] greyScaleTransformation(int[][][] imageMatrix) {
    // TODO Auto-generated method stub
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image can't be null");
    }
    imageMatrix = colorMatrixMultiplier(imageMatrix, greyScaleFilterKernel);
    return imageMatrix;
  }

  /**
   * This method is used to convert the image to sepia tone.
   * 
   * @param imageMatrix The image matrix which needs to be transformed
   * @return The image matrix after the sepia tone transformation
   */
  public static int[][][] sepiaToneTransformation(int[][][] imageMatrix) {
    // TODO Auto-generated method stub
    if (imageMatrix == null) {
      throw new IllegalArgumentException("image matrix can't be null");
    }
    imageMatrix = colorMatrixMultiplier(imageMatrix, sepiaFilterKernel);
    return imageMatrix;
  }
}
