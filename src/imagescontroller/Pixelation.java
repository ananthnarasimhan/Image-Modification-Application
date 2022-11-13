package imagescontroller;

import imagesmodel.ImageInterface;


/**
 * This class implements the command of generating pixellation pattern of image.
 * 
 * @author ananth
 *
 */
public class Pixelation implements ControllerCommands {
  
  @Override
  public void apply(Appendable output,ImageInterface model, String argument) {
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    if (Integer.parseInt(argument) < 0) {
      throw new IllegalArgumentException("Invalid parameter");
    }
    model.imagePixelation(output,Integer.valueOf(argument));
    // TODO Auto-generated method stub
    
  }

}
