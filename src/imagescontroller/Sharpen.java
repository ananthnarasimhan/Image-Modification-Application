package imagescontroller;

import imagesmodel.ImageInterface;

/**
 * This class implements the command of generating a sharpen output of image.
 * 
 * @author ananth
 *
 */
public class Sharpen implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    model.imgSharpen(output);
    // TODO Auto-generated method stub

  }

}
