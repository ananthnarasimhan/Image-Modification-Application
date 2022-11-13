package main;

import imagescontroller.ControllerSystem;
import imagescontroller.ImageControllerImpl;
import imagescontroller.ImageControllerInterface;
import imagescontroller.ViewControllerImpl;
import imagesmodel.Image;
import imagesmodel.ImageInterface;
import view.ImgView;
import view.ViewInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class represents a run of the program.
 * 
 * @author ananth
 *
 */
public class Driver2 {
  /**
   * This class represents the main method which is the initialization of the
   * program.
   * 
   * @param args the arguments passed in runtime.
   */
  public static void main(String[] args) {
    Appendable output = new StringBuilder();
    ImageInterface model = new Image();
    if (args[0].equals("-script")) {
      Readable rd;
      try {
        rd = new FileReader(args[1]);
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        throw new IllegalArgumentException("Image not found");
      }
      
      ImageControllerInterface controller = new ImageControllerImpl(model);
      controller.parseAndProcess(rd, output);
    }

    else if (args[0].equals("-interactive")) {
      ControllerSystem controller = new ViewControllerImpl(model, output);
      ViewInterface view = new ImgView("Image");
      controller.setView(view);
    } else {
      throw new IllegalArgumentException("wrong parameters for opening the file");
    }
    System.out.println(output);
  }
}
