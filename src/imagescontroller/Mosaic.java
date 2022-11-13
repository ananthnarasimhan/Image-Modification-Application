package imagescontroller;

import imagesmodel.ImageInterface;

/**
 * This class implements the command of generating mosaic pattern of image.
 * 
 * @author ananth
 *
 */
public class Mosaic implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    if (Integer.parseInt(argument) < 0) {
      throw new IllegalArgumentException("Invalid parameter");
    }
    model.imageMosaic(output,Integer.parseInt(argument));
    
  }

}
