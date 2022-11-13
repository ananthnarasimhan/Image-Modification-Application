package imagescontroller;

import imagesmodel.ImageInterface;



/**
 * This class implements the command of blurring of image.
 * 
 * @author ananth
 *
 */
public class Blur implements ControllerCommands {

  @Override
  public void apply(Appendable output,ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    
    model.imgBlur(output);
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
  }

}
