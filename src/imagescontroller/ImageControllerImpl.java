package imagescontroller;

import imagesmodel.ImageInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/**
 * This class represents the Image Controller Interface. It implements various
 * functionalities of the Image Controller.
 * 
 * @author ananth
 *
 */
public class ImageControllerImpl implements ImageControllerInterface {

  private ImageInterface model;

  /**
   * This class creates an object on an instance of the controller. It can be used
   * to perform various tasks such as read, write, dither, blur, sharpen,
   * greyscale, sepia, mosaic, pattern generation and pixelaation.
   * 
   * @param model the model which is going to perform these operations
   */
  public ImageControllerImpl(ImageInterface model) {
    if (model == null) {
      throw new IllegalArgumentException("model and location should be non null");
    }
    this.model = model;
  }

  @Override
  public void parseAndProcess(Readable command, Appendable output) {
    if (output == null || model == null) {
      throw new IllegalArgumentException("model and argument should be non null");
    }

    Map<String, Function<String, ControllerCommands>> commands = new HashMap<>();
    commands.put(Commands.GREYSCALE.toString(), s -> new GreyScale());
    commands.put(Commands.MOSAIC.toString(), s -> new Mosaic());
    commands.put(Commands.PIXELLATE.toString(), s -> new Pixelation());
    commands.put(Commands.SEPIATONE.toString(), s -> new SepiaTone());
    commands.put(Commands.SHARPEN.toString(), s -> new Sharpen());
    commands.put(Commands.WRITE.toString(), s -> new Write());
    commands.put(Commands.DITHER.toString(), s -> new Dither());
    commands.put(Commands.CROSSTITCH.toString(), s -> new GeneratePattern());
    commands.put(Commands.READ.toString(), s -> new Read());
    commands.put(Commands.BLUR.toString(), s -> new Blur());
    commands.put(Commands.WRITECROSSTITCH.toString(), s -> new WriteDmcFile());
    commands.put(Commands.CONVERTINGIMGDMC.toString(), s -> new ConvertImgDmc());
    commands.put(Commands.REMOVECOLOR.toString(), s -> new RemoveDmcColor());
    commands.put(Commands.REPLACECOLOR.toString(), s -> new ReplaceColor());
    commands.put(Commands.ADDTEXT.toString(), s -> new AddText());
    Scanner scan = new Scanner(command);
    while (scan.hasNextLine()) {

      String operation = scan.next();
      ControllerCommands c;
      Function<String, ControllerCommands> cmd = commands.getOrDefault(operation, null);
      if (cmd == null) {
        throw new IllegalArgumentException("Wrong input command");
      } else {
        c = cmd.apply(operation);
        if (operation.equals(Commands.REMOVECOLOR.toString())
            || operation.equals(Commands.READ.toString())
            || operation.equals(Commands.WRITE.toString())
            || operation.equals(Commands.PIXELLATE.toString())
            || operation.equals(Commands.MOSAIC.toString())
            || operation.equals(Commands.WRITECROSSTITCH.toString())) {
          c.apply(output, model, scan.next());
        } else if (operation.equals("ADDTEXT")) {
          String argument = scan.next() + " " + scan.next();

          c.apply(output, model, argument);
        } else if (operation.equals(Commands.REPLACECOLOR.toString())) {
          String argument = scan.next() + " " + scan.next() + " " + scan.next();
          c.apply(output, model, argument);
        } else {
          c.apply(output, model, "");
        }
      }
    }
    scan.close();
  }

}
