package imagescontroller;

import imagesmodel.ImageInterface;


/**
 * This class represents the replace color command in command design pattern of the
 * batch file controller.
 * 
 * @author ananth
 *
 */
public class ReplaceColor implements ControllerCommands {

  @Override
  public void apply(Appendable output,ImageInterface model, String argument) {
    if (output == null || model == null || argument == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }
    String[] s = argument.split(" ");
    model.replaceWithDmc(output,Integer.valueOf(s[0]),Integer.valueOf(s[1]),s[2]);
    
  }

}
