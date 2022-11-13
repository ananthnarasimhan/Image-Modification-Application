package imagescontroller;

import imagesmodel.ImageInterface;

/**
 * This class represents the execution of the command write cross stitch
 * pattern.
 * 
 * @author ananth
 *
 */
public class WriteDmcFile implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    model.writeDmcFile(output,argument);
    
  }

}
