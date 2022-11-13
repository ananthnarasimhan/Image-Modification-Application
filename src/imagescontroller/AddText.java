package imagescontroller;

import imagesmodel.ImageInterface;

/**
 * This class represents the add text command in command design pattern of the
 * batch file controller.
 * 
 * @author ananth
 *
 */
public class AddText implements ControllerCommands {

  @Override
  public void apply(Appendable output, ImageInterface model, String argument) {
    // TODO Auto-generated method stub
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }

    String[] s = argument.split(" ");
    model.addText(output,s[0], s[1]);
  }

}
