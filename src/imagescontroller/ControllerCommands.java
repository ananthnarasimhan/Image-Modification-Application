package imagescontroller;

import imagesmodel.ImageInterface;

/**
 * The controller interface for the image transformation program. The functions
 * here have been designed to give control to the controller, and the primary
 * operation for the controller to function (process a image transformation
 * command).
 * 
 * @author ananth
 *
 */
public interface ControllerCommands {
  /**
   * This method is used to implement the functionality of the command.
   * 
   * @param model    The model used by the controller
   * @param argument The arguments passed for the commands.
   * @param output   The appendable used for storing the log of the operations.
   */
  public void apply(Appendable output, ImageInterface model, String argument);
}
