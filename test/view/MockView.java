package view;

import imagescontroller.AcceptStrings;
import imagescontroller.ViewControllerInterface;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a mock view used for testing the controller.
 * 
 * @author ananth
 *
 */
public class MockView implements ViewInterface {

  String input;

  /**
   * This is a constructor for a mock view.
   * 
   * @param input the command being tested.
   */
  public MockView(String input) {
    // TODO Auto-generated constructor stub
    this.input = input;
  }

  @Override
  public void setFeatures(Appendable output, ViewControllerInterface viewControllerImpl) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.VIEWSETFEATURES.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    switch (input) {
      case "IMAGEREAD":
  
        viewControllerImpl.readImage("");
        break;
      case "IMAGEWRITE":
        viewControllerImpl.writeImage("");
        break;
      case "BLUR":
        viewControllerImpl.blur();
        break;
      case "SHARPEN":
        viewControllerImpl.sharpen();
        break;
      case "DITHER":
        viewControllerImpl.dither();
        break;
  
      case "BATCHSCRIPTEXECUTED":
        viewControllerImpl.executeBatchCommands(new StringReader("READ a1.jpg"));
        break;
      case "GREYSCALE":
        viewControllerImpl.greyScale();
        break;
      case "SEPIATONE":
        viewControllerImpl.sepiaTone();
        break;
      case "MOSIAC":
        viewControllerImpl.mosaic("50");
        break;
      case "PIXELLATION":
        viewControllerImpl.pixellation("50");
        break;
      case "CROSSSTITCHPERFORMED":
        viewControllerImpl.crossStitch();
        break;
      case "WRITECROSSSTITCHFILE":
        viewControllerImpl.writeDmcFile("");
        break;
      case "IMAGECONVERTEDTODMCCOLORS":
        viewControllerImpl.convertToDmcColors();
        break;
      case "REMOVEDDMC":
        viewControllerImpl.removeDmcColor("");
        break;
      case "REPLACEDDMC":
        viewControllerImpl.setUpReplaceColorcoordintes();
        break;
      case "ADDTEXT":
        viewControllerImpl.addText("abc 3713");
        break;
      case "CREATEDOWNDMCINDEX":
        List<String> tmp = new ArrayList<>();
        viewControllerImpl.newDmcIndex(tmp);
        break;
      case "WRITTENOWNDMCINDEX":
        viewControllerImpl.writeOwnDmcCharactermatrix("");
        break;
      default:
        throw new IllegalStateException("This operation cannot be performed by the UI");
        
    }

  }

  @Override
  public void replaceDmcColor(Appendable output, ViewControllerInterface controller) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.VIEWREPLACEDMCCOLOR.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    controller.setUpReplaceColorcolor("1 1");
  }

  @Override
  public void getReplaceColor(Appendable output, ViewControllerInterface controller,
      String coordinates) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.VIEWGETREPLACECOLOR.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    controller.replaceDmcColor("1 1 310");
  }

  @Override
  public void setImg(Appendable output, BufferedImage image) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.VIEWSETIMG.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void crossStitch(Appendable output, List<List<String>> index) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.VIEWCROSSSTITCH.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

}
