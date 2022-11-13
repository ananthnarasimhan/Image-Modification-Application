package imagescontroller;

import imagesmodel.ImageInterface;


/**
 * This class represents the remove dmc color command in command design pattern of the
 * batch file controller.
 * 
 * @author ananth
 *
 */
public class RemoveDmcColor implements ControllerCommands {

  @Override
  public void apply(Appendable output,ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    model.removeColor(output,argument);
    
  }

}
