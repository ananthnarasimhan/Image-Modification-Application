package imagescontroller;

import imagesmodel.ImageInterface;

import java.io.IOException;

/**
 * This class implements the command of writing image in file.
 * 
 * @author ananth
 *
 */
public class Write implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    try {
      model.writeImage(output,argument);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Image can't be wrtitten there");
    }
    
  }

}
