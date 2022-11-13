package imagesmodel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * This defines the methods for the image transformation.
 * 
 * @author ananth
 *
 */
public interface ImageInterface {
  /**
   * This method is used to transform the image matrix to grey scale matrix.
   * 
   * @param output the appendable to store log of operations.
   */
  public void greyScale(Appendable output);

  /**
   * This method is used to transform the image matrix to sepia toned image
   * matrix.
   * 
   * @param output the appendable to store log of operations.
   */

  public void sepiaTone(Appendable output);

  /**
   * This method is used to transform the image matrix to blurred image matrix.
   * 
   * @param output the appendable to store log of operations.
   */

  public void imgBlur(Appendable output);

  /**
   * This method is used to transform the image matrix to sharpened image matrix.
   * 
   * @param output the appendable to store log of operations.
   */

  public void imgSharpen(Appendable output);

  /**
   * This method is used to transform the image matrix to dithered image matrix.
   * 
   * @param output the appendable to store log of operations.
   */
  public void ditherImage(Appendable output);

  /**
   * This method is used to obtain the image matrix.
   * 
   * @return The image matrix
   */
  public int[][][] getImgMatrix();

  /**
   * This method is used to clamp the values of the image matrix.
   * 
   * @param minValue The minimum value of the color channel
   * @param maxValue The max value of the color channel
   * 
   */
  public void clampImage(int minValue, int maxValue);

  /**
   * This method is used to create a mosaic of image using random points.
   * 
   * @param output the appendable to store log of operations.
   * @param seeds  The number of seeds in the image.
   * 
   */
  public void imageMosaic(Appendable output, int seeds);

  /**
   * This method is used to obtain a Pixelation with the same number of output
   * pixels as input pixels.
   * 
   * @param output the appendable to store log of operations.
   * @param blocks The number of pixel blocks in the row.
   * 
   */
  public void imagePixelation(Appendable output, int blocks);

  /**
   * This method is used to perform the cross stitch and obtain the pattern.
   * 
   * @param output the appendable to store log of operations.
   */
  public void imageCrossStitch(Appendable output);

  /**
   * This method is used to load the image into the model.
   * 
   * @param output   the appendable to store log of operations.
   * @param fileName the file name of the image which needs to be loaded
   * 
   * @throws IOException if any error in loading the image
   */
  public void loadImage(Appendable output, String fileName) throws IOException;

  /**
   * Update the image in the view.
   * 
   * @param appendable the appendable to store log of operations.
   * 
   * @return a buffered image of the image which is undergoing various operations.
   */
  public BufferedImage notifyView(Appendable appendable);

  /**
   * This method is used to save an image in a file.
   * 
   * @param output   the appendable to store log of operations.
   * @param filename the filename in which the image is saved.
   * @throws IOException when error in saving the image in a file.
   */
  public void writeImage(Appendable output, String filename) throws IOException;

  /**
   * This method is used to remove the color from the cross stitch pattern.
   * 
   * @param output    the appendable to store log of operations.
   * @param colorCode The color which needs to be removed.
   */
  public void removeColor(Appendable output, String colorCode);

  /**
   * This method is used to write the cross stitch pattern in a file.
   * 
   * @param output   the appendable to store log of operations.
   * @param filename the file where cross stitch needs to be saved.
   */
  public void writeDmcFile(Appendable output, String filename);

  /**
   * This method is used to convert the image matrix colors into image matrix with
   * only dmc colors.
   * 
   * @param output the appendable to store log of operations.
   */
  public void displayDmcColor(Appendable output);

  /**
   * This method provide the ability to exchange one color for another in a
   * cross-stitch pattern by clicking on the color in a displayed pattern and
   * allowing the user to select a different color from the DMC color options.
   * 
   * @param output the appendable to store log of operations.
   * @param x      The x coordinate where the user has clicked.
   * @param y      The y coordinate where the user has clicked.
   * @param dmc    The color with which the pixel needs to be replaced with.
   */
  public void replaceWithDmc(Appendable output, int x, int y, String dmc);

  /**
   * This method is used to add text to the image.
   * 
   * @param output the appendable to store log of operations.
   * @param text   The text which needs to be added.
   * @param dmc    The color of the text.
   */
  public void addText(Appendable output, String text, String dmc);

  /**
   * This method is used to obtain the dmc Index of the cross stitch pattern.
   * 
   * @return the dmc Index of the cross stitch pattern
   */
  public List<List<String>> getDmcIndex();

  /**
   * This method obtains a list of colors from the user and prepares the cross
   * stitch pattern using these colors.
   * 
   * @param output the appendable to store log of operations.
   * @param dmc    The list of colors provided by the user.
   */
  public void updateDmcIndex(Appendable output, List<String> dmc);

  /**
   * This method is used to obtain the all possible dmc colors available to us.
   * 
   * @param appendable the appendable to store log of operations.
   * @return the all possible dmc colors.
   */
  public List<List<String>> getCompleteDmcIndex(Appendable appendable);

  /**
   * This method is used to write the cross stitch pattern with colors available
   * from user in a file.
   * 
   * @param output   the appendable to store log of operations.
   * @param filename the file where cross stitch needs to be saved.
   */
  public void writeUserDmcFile(Appendable output, String filename);

  /**
   * This method is used to obtain the user dmc Index of the cross stitch pattern.
   * 
   * @param appendable the appendable to store log of operations.
   * @return the user defined dmc index of the cross stitch pattern
   */
  public List<List<String>> getUserDmcIndex(Appendable appendable);
}
