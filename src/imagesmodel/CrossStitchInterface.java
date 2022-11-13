package imagesmodel;

import java.util.List;

/**
 * This interface defines all the methods which can be implemented on cross
 * stitch pattern.
 * 
 * @author ananth
 *
 */
public interface CrossStitchInterface {
  /**
   * This method is used to generate a cross stitch pattern.
   * 
   * @param imageMatrix The image for which we are going to generate the cross
   *                    stitch.
   * @param xSize       The pixel size of the image.
   */
  public void generatePattern(int[][][] imageMatrix, int xSize);

  /**
   * This method is used to obtain the dmc Legend of the cross stitch pattern.
   * 
   * @return the list of list of string consisting of the legend of the dmc
   *         pattern.
   */
  public List<List<String>> getdmcLegend();

  /**
   * This method is used to obtain all the possible dmc colors.
   * 
   * @return the list of list of string consisting of the all of the dmc colors.
   */
  public List<List<String>> getcompletedmcLegend();

  /**
   * This method is used to obtain the cross stitch pattern.
   * 
   * @return a character matrix of the cross stitch.
   */
  public char[][] getdmcMatrix();

  /**
   * This method is used to convert the image matrix colors into image matrix with
   * only dmc colors.
   * 
   * @param imageMatrix the image matrix which needs to be converted.
   * @return the image matrix after converting.
   */
  public int[][][] dmcColorTransformation(int[][][] imageMatrix);

  /**
   * This method is used to remove the color from the cross stitch pattern.
   * 
   * @param dmc The color which needs to be removed.
   */
  public void removeColor(String dmc);

  /**
   * This method provide the ability to exchange one color for another in a
   * cross-stitch pattern by clicking on the color in a displayed pattern and
   * allowing the user to select a different color from the DMC color options.
   * 
   * @param imageMatrix The image matrix in which the color needs to be replaced.
   * @param x           The x coordinate where the user has clicked.
   * @param y           The y coordinate where the user has clicked.
   * @param dmc         The color with which the pixel needs to be replaced with.
   * @return The image matrix after color replacement.
   */
  public int[][][] replaceColor(int[][][] imageMatrix, int x, int y, String dmc);

  /**
   * This method is used to add text to the cross stitch pattern.
   * 
   * @param imageMatrix The image matrix on which we need to add text.
   * @param text        The text which needs to be added.
   * @param dmc         The color of the text.
   * @param startx      The position where the image needs to start.
   * @param pixelSize   The pixel size of the image.
   * @return The image matrix after adding the text.
   */
  public int[][][] addText(int[][][] imageMatrix, String text, String dmc, int startx,
      int pixelSize);

  /**
   * This method is used to create a cross stitch pattern with a dmc index defined
   * by the user.
   * 
   * @param imageMatrix the image on which the cross stitch needs to be generated.
   * @param xSize       the superpixel size of the image
   * @param dmc         the list of dmc colors provided by the user
   */
  public void updateDmc(int[][][] imageMatrix, int xSize, List<String> dmc);

  /**
   * This method is used to obtain the dmc legend of the cross stitch pattern
   * performed on the colors provided by the user.
   * 
   * @return the dmc legend of the cross stitch
   */
  public List<List<String>> getOwnDmcLegend();

  /**
   * This method is used to obtain the pattern of the cross stitch obtained using
   * dmc colors specified by the user.
   * 
   * @return the cross stitch pattern
   */
  public char[][] getOwnDmcCharactermatrix();

  /**
   * Thiss method is used to transform the image matrix into dmc index colors
   * defined by the user.
   * 
   * @param imageMatrix the image matrix which needs to be transformed.
   * @return the image matrix after transformation
   */
  public int[][][] convertToOwnDmcIndex(int[][][] imageMatrix);
}
