package imagescontroller;

/**
 * This class represents the interface for the controller of the image
 * controller. It states all the functions performed by the controller.
 * 
 * @author ananth
 *
 */
public interface ImageControllerInterface {
  /**
   * This method is used to parse the batch file and carry out the necessary
   * operations.
   */
  public void parseAndProcess(Readable command, Appendable output);

}
