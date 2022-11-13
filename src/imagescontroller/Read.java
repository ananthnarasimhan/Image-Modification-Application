package imagescontroller;

import imagesmodel.ImageInterface;

import java.io.IOException;

/**
 * This class implements the command of reading the image from a location.
 * 
 * @author ananth
 *
 */
public class Read implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    // TODO Auto-generated method stub
    try {
      model.loadImage(output,argument);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Image can't be read");
    }
    
  }

}
