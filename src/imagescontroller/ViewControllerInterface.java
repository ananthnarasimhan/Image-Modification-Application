package imagescontroller;

import java.util.List;

/**
 * This class represent the various operations that can be performed from the UI
 * which is supported by the controller.
 * 
 * @author ananth
 *
 */
public interface ViewControllerInterface {
  /**
   * This method is invoked when the user reads the image file from UI. This
   * method also call the corresponding operation to be performed in the model.
   * 
   * @param location The name and location of the file which is read.
   */
  public void readImage(String location);

  /**
   * This method is invoked when the user writes the image file from UI. This
   * method also call the corresponding operation to be performed in the model.
   * 
   * @param location The name and location of the file which is saved.
   */
  public void writeImage(String location);

  /**
   * This method is invoked when the user performs blurring of the image from UI.
   * This method also call the corresponding operation to be performed in the
   * model.
   * 
   */
  public void blur();

  /**
   * This method is invoked when the user performs sharpening of the image from
   * UI. This method also call the corresponding operation to be performed in the
   * model.
   */
  public void sharpen();

  /**
   * This method is invoked when the user performs writing of the cross stitch
   * from UI. This method also call the corresponding operation to be performed in
   * the model.
   * 
   * @param location the location where we need to write the file
   */
  public void writeDmcFile(String location);

  /**
   * This method is invoked when the user performs dithering of the image from UI.
   * This method also call the corresponding operation to be performed in the
   * model.
   */
  public void dither();

  /**
   * This method is invoked when the user performs greyscale transformation of the
   * image from UI. This method also call the corresponding operation to be
   * performed in the model.
   */
  public void greyScale();

  /**
   * This method is invoked when the user performs sepia tone transformation of
   * the image from UI. This method also call the corresponding operation to be
   * performed in the model.
   */
  public void sepiaTone();

  /**
   * This method is invoked when the user add text to the image from UI. This
   * method also call the corresponding operation to be performed in the model.
   *
   * @param argument The color and text to be added.
   */
  public void addText(String argument);

  /**
   * This method is invoked when the user performs cross stitch pattern generation
   * of the image from UI. This method also call the corresponding operation to be
   * performed in the model.
   */

  public void crossStitch();

  /**
   * This method is invoked when the user performs remove dmc color from cross
   * stitch pattern of the image from UI. This method also call the corresponding
   * operation to be performed in the model.
   * 
   * @param color The color ro be removed
   */
  public void removeDmcColor(String color);

  /**
   * This method is invoked when the user performs mosaic transformation of the
   * image from UI. This method also calls the corresponding operation to be
   * performed in the model.
   * 
   * @param seeds The number of seeds in the image.
   */
  public void mosaic(String seeds);

  /**
   * This method is invoked when the user performs pixellation transformation of
   * the image from UI. This method also calls the corresponding operation to be
   * performed in the model.
   * 
   * @param blocks The number of blocks accross the image.
   */
  public void pixellation(String blocks);

  /**
   * This method is invoked when the user performs replace dmc color from cross
   * stitch pattern of the image from UI. This method also calls the corresponding
   * operation to be performed in the model.
   *
   * @param argument contains the color with which we want to replace with and x
   *                 and y cordinates of the source pixel.
   */
  public void replaceDmcColor(String argument);

  /**
   * This method is used to obtain the dmc index from the model.
   * 
   * @return the dmc index.
   */
  public List<List<String>> getDmcIndex();

  /**
   * This method is used to obtain all the possible dmc colors from the model.
   * 
   * @return all possible dmc colors.
   */
  public List<List<String>> completeDmcIndex();

  /**
   * This method is invoked when the user performs convert image to dmc colors
   * from cross stitch pattern of the image from UI. This method also calls the
   * corresponding operation to be performed in the model.
   *
   */
  public void convertToDmcColors();

  /**
   * This method is invoked when the user performs add new dmc index to be used in
   * the cross stitch pattern from UI. This method also calls the corresponding
   * operation to be performed in the model.
   * 
   * @param dmc the list of dmc colors selected by the user.
   */
  public void newDmcIndex(List<String> dmc);

  /**
   * This method is used to respond to replace dmc color command from the user.
   * This method will then invoke the operation required in the UI to obtain the
   * coordinates.
   */
  public void setUpReplaceColorcoordintes();

  /**
   * This method is invoked when the user performs a set of batch commands on the
   * image from UI. This method also calls the corresponding operation to be
   * performed in the model.
   * 
   * @param commands the commands provided by the user.
   */
  void executeBatchCommands(Readable commands);

  /**
   * This method is invoked when the user provides the input data and the
   * controller tells the UI to obtain the color we need to replace with.
   * 
   * @param coordinates the cordinates of the pixel that we need to replace the
   *                    color of.
   */
  void setUpReplaceColorcolor(String coordinates);

  /**
   * This method is invoked when the user performs writing of the cross stitch
   * with the dmc index specified by him from UI. This method also call the
   * corresponding operation to be performed in the model.
   * 
   * @param location the location where the file needs to written.
   */
  void writeOwnDmcCharactermatrix(String location);

}
