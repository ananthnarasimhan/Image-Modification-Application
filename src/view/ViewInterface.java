package view;

import imagescontroller.ViewControllerInterface;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * This interface represents all the operations performed by the view.
 * 
 * @author ananth
 *
 */
public interface ViewInterface {

  /**
   * Get the set of feature callback that the view can use.
   * 
   * @param output             the appendable to store log of operations.
   * @param viewControllerImpl the set of controller callback as a View controller
   *                           interface object
   */
  public void setFeatures(Appendable output, ViewControllerInterface viewControllerImpl);

  /**
   * This method is used to replace the dmc color in the image.
   * 
   * @param output     the appendable to store log of operations.
   * @param controller the controller object for the call back after the
   *                   operation.
   */
  public void replaceDmcColor(Appendable output, ViewControllerInterface controller);

  /**
   * This method is use to obtain the color with which we want to replace with.
   * 
   * @param output      the appendable to store log of operations.
   * @param controller  the controller object to return the value after obtaining
   *                    from the user.
   * @param coordinates the coordinates of the point which we need to replace it
   *                    with.
   */
  public void getReplaceColor(Appendable output, ViewControllerInterface controller,
      String coordinates);

  /**
   * This method is used to print the cross stitch pattern index on the view.
   * 
   * @param output the appendable to store log of operations.
   * @param index  list of list of string containing cross stitch pattern index.
   */
  public void crossStitch(Appendable output, List<List<String>> index);

  /**
   * This method is used to set the image in the view after update are done in
   * model.
   * 
   * @param output the appendable to store log of operations.
   * @param image  the image to be shown on the view.
   */
  public void setImg(Appendable output, BufferedImage image);
}
