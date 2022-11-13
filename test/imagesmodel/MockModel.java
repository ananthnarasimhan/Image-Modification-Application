package imagesmodel;

import imagescontroller.AcceptStrings;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * This class is a mock model. It only adds which method have been called by the
 * view.
 * 
 * @author ananth
 *
 */
public class MockModel implements ImageInterface {

  @Override
  public void greyScale(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.GREYSCALE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void sepiaTone(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.SEPIATONE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imgBlur(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.BLUR.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imgSharpen(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.SHARPEN.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void ditherImage(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.DITHER.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public int[][][] getImgMatrix() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void clampImage(int minValue, int maxValue) {
    // TODO Auto-generated method stub

  }

  @Override
  public void imageMosaic(Appendable output, int seeds) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.MOSIAC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imagePixelation(Appendable output, int blocks) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.PIXELLATION.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imageCrossStitch(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.CROSSSTITCHPERFORMED.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void loadImage(Appendable output, String fileName) throws IOException {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.IMAGEREAD.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public BufferedImage notifyView(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.SETVIEW.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    return null;
  }

  @Override
  public void writeImage(Appendable output, String filename) throws IOException {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.IMAGEWRITE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void removeColor(Appendable output, String colorCode) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.REMOVEDDMC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void writeDmcFile(Appendable output, String filename) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.WRITECROSSSTITCHFILE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void displayDmcColor(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.IMAGECONVERTEDTODMCCOLORS.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void replaceWithDmc(Appendable output, int x, int y, String dmc) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.REPLACEDDMC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void addText(Appendable output, String text, String dmc) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.ADDTEXT.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public List<List<String>> getDmcIndex() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateDmcIndex(Appendable output, List<String> dmc) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.UPDATEDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public List<List<String>> getCompleteDmcIndex(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.GETCOMPLETEDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    return null;
  }

  @Override
  public void writeUserDmcFile(Appendable output, String filename) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.WRITTENOWNDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public List<List<String>> getUserDmcIndex(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.GETUSERDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    return null;
  }

}
