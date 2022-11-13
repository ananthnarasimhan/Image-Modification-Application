package imagescontroller;

import imagesmodel.ImageInterface;



/**
 * This class implements the command of generating cross stitch pattern of
 * image.
 * 
 * @author ananth
 *
 */
public class ConvertImgDmc implements ControllerCommands {
  @Override
  public void apply(Appendable output,ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    model.displayDmcColor(output);
    
  }
}
