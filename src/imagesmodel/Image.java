package imagesmodel;

import imagescontroller.AcceptStrings;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * This class represents the various functionalities of image class.
 * 
 * @author ananth
 *
 */
public class Image implements ImageInterface {
  private int[][][] imageMatrix;
  private CrossStitchInterface crossStitch;
  private int pixelxSize;
  private boolean isPixelate;
  private int startText;

  /**
   * This constructor assign null to image matrix which ensures that we can't
   * perform any operations on the image unless it is read.
   * 
   */
  public Image() {
    this.imageMatrix = null;
    crossStitch = new CrossStitch();
    startText = 0;
    isPixelate = false;
    pixelxSize = 1;
  }

  /**
   * This constructor assign values to the image matrix.
   * 
   * @param imageMatrix The matrix on which operations need to be performed.
   */
  public Image(int[][][] imageMatrix) {
    /*
     * if (imageMatrix == null) { throw new
     * IllegalArgumentException("image matrix can't be null"); }
     */
    if (imageMatrix == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    this.imageMatrix = imageMatrix;
  }

  private void checkImageMatrix() {
    if (imageMatrix == null) {
      throw new IllegalStateException("image not read");
    }
  }

  @Override
  public void loadImage(Appendable output, String fileName) throws IOException {
    if (fileName == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    this.imageMatrix = ImageUtilities.readImage(fileName);
    try {
      output.append(AcceptStrings.IMAGEREAD.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void greyScale(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.imageMatrix = ColorTransformation.greyScaleTransformation(getImgMatrix());
    try {
      output.append(AcceptStrings.GREYSCALE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void sepiaTone(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.imageMatrix = ColorTransformation.sepiaToneTransformation(getImgMatrix());
    try {
      output.append(AcceptStrings.SEPIATONE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imgBlur(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.imageMatrix = FilterImage.blurImages(getImgMatrix());
    try {
      output.append(AcceptStrings.BLUR.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imgSharpen(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.imageMatrix = FilterImage.sharpenImage(getImgMatrix());
    try {
      output.append(AcceptStrings.SHARPEN.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void ditherImage(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.imageMatrix = ReductionColorDensity.ditherImage(getImgMatrix());
    try {
      output.append(AcceptStrings.DITHER.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void clampImage(int minValue, int maxValue) {
    checkImageMatrix();
    this.imageMatrix = FilterImage.clampImage(getImgMatrix(), minValue, maxValue);

  }

  @Override
  public int[][][] getImgMatrix() {
    checkImageMatrix();
    int[][][] copy = new int[imageMatrix.length][imageMatrix[0].length][imageMatrix[0][0].length];
    for (int i = 0; i < imageMatrix.length; i++) {
      for (int j = 0; j < imageMatrix[0].length; j++) {
        for (int k = 0; k < imageMatrix[0][0].length; k++) {
          copy[i][j][k] = imageMatrix[i][j][k];
        }
      }
    }
    return copy;
  }

  @Override
  public void imageMosaic(Appendable output, int seeds) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    // TODO Auto-generated method stub
    this.imageMatrix = ColorSmudge.imageMosaic(getImgMatrix(), seeds);
    try {
      output.append(AcceptStrings.MOSIAC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void imagePixelation(Appendable output, int blocks) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    this.isPixelate = true;
    // TODO Auto-generated method stub
    this.pixelxSize = imageMatrix[0].length / blocks;
    this.imageMatrix = ColorSmudge.imagePixelation(getImgMatrix(), blocks);
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
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    checkImageMatrix();
    if (!this.isPixelate) {
      this.imagePixelation(output, 100);
    }
    crossStitch.generatePattern(getImgMatrix(), pixelxSize);
    try {
      output.append(AcceptStrings.CROSSSTITCHPERFORMED.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public void writeImage(Appendable output, String filename) throws IOException {
    if (filename == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    ImageUtilities.writeImage(getImgMatrix(), imageMatrix[0].length, imageMatrix.length, filename);
    try {
      output.append(AcceptStrings.IMAGEWRITE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
  }

  @Override
  public BufferedImage notifyView(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.SETVIEW.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    return (ImageUtilities.getBufferedImage(getImgMatrix(), imageMatrix[0].length,
        imageMatrix.length));
  }

  @Override
  public void writeDmcFile(Appendable output, String fileName) {
    // TODO Auto-generated method stub
    if (fileName == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.WRITECROSSSTITCHFILE.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    List<List<String>> legend = crossStitch.getdmcLegend();
    char[][] characterMatrix = crossStitch.getdmcMatrix();
    getDmcString(characterMatrix, legend, fileName);
  }

  @Override
  public void replaceWithDmc(Appendable output, int x, int y, String dmc) {
    // TODO Auto-generated method stub
    if (dmc == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.REPLACEDDMC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    this.imageMatrix = crossStitch.replaceColor(getImgMatrix(), x, y, dmc);
  }

  @Override
  public void removeColor(Appendable output, String colorCode) {
    // TODO Auto-generated method stub
    if (colorCode == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.REMOVEDDMC.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    crossStitch.removeColor(colorCode);
  }

  @Override
  public void displayDmcColor(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.IMAGECONVERTEDTODMCCOLORS.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    this.imageMatrix = crossStitch.dmcColorTransformation(getImgMatrix());
  }

  @Override
  public void addText(Appendable output, String text, String dmc) {
    if (text == null || dmc == null || output == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.ADDTEXT.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    this.imageMatrix = crossStitch.addText(getImgMatrix(), text, dmc, startText, pixelxSize);
    startText += (5 * pixelxSize) + 1;
  }

  @Override
  public List<List<String>> getDmcIndex() {
    // TODO Auto-generated method stub
    return crossStitch.getdmcLegend();
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
    return crossStitch.getcompletedmcLegend();
  }

  @Override
  public void updateDmcIndex(Appendable output, List<String> dmc) {
    // TODO Auto-generated method stub
    if (dmc == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    crossStitch.updateDmc(getImgMatrix(), pixelxSize, dmc);
    this.imageMatrix = crossStitch.convertToOwnDmcIndex(getImgMatrix());
  }

  private void getDmcString(char[][] charaterMatrix, List<List<String>> legend, String filename) {
    try {
      StringBuilder pattern = new StringBuilder();
      pattern
          .append("The size is:" + charaterMatrix.length + "x" + charaterMatrix[0].length + "\n");
      for (int i = 0; i < charaterMatrix.length; i++) {
        for (int j = 0; j < charaterMatrix[0].length; j++) {
          pattern.append(charaterMatrix[i][j]);
        }
        pattern.append("\n");
      }
      pattern.append("\n The legend is:\n");

      for (List<String> traverse : legend) {
        pattern.append(traverse.get(0) + traverse.get(1) + traverse.get(2) + "\n");
      }
      BufferedWriter bw = new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8));

      bw.write(pattern.toString());
      bw.flush();
      bw.close();
    } catch (IOException e) {

      throw new IllegalArgumentException("can't write in file");
    }
  }

  @Override
  public void writeUserDmcFile(Appendable output, String filename) {
    // TODO Auto-generated method stub
    if (filename == null) {
      throw new IllegalArgumentException("Error in argument");
    }
    try {
      output.append(AcceptStrings.WRITTENOWNDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    List<List<String>> legend = crossStitch.getOwnDmcLegend();
    char[][] characterMatrix = crossStitch.getOwnDmcCharactermatrix();
    getDmcString(characterMatrix, legend, filename);
  }

  @Override
  public List<List<String>> getUserDmcIndex(Appendable output) {
    // TODO Auto-generated method stub
    try {
      output.append(AcceptStrings.GETCOMPLETEDMCINDEX.toString() + "\n");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Can't add to apendable");
    }
    return crossStitch.getOwnDmcLegend();
  }

}
