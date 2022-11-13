package imagesmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class represents the cross stitch pattern generation and the various
 * method needed to do it.
 * 
 * @author ananth
 *
 */
public class CrossStitch implements Comparator<String>, CrossStitchInterface {
  private char[][] outputPattern;
  private List<List<String>> dmcLegend;
  private final List<List<String>> dmcIndex;
  private List<List<String>> userDmcIndex;
  private List<List<String>> userdmcLegend;
  private char[][] useroutputPattern;

  /**
   * This is a constructor that initializes all the instance variable of the cross
   * stitch. The output pattern and dmc legend for predefined and user defined are
   * set to null in the beginning which will help us know that getter for these
   * will be able to return only after the cross stitch pattern is generated.
   */
  public CrossStitch() {
    // TODO Auto-generated constructor stub
    try {
      dmcIndex = ReadDmc.readDmc();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Dmc Colors cannot be read");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Dmc Colors cannot be read");
    }
    outputPattern = null;
    dmcLegend = new ArrayList<>();
    userDmcIndex = new ArrayList<>();
    userdmcLegend = new ArrayList<>();
    useroutputPattern = null;
  }

  @Override
  public int compare(String s1, String s2) {
    return s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() - s2.length();
  }

  private static String findClosestDmc(int r, int g, int b, List<List<String>> dmcIndex) {
    double minDeltaC = Integer.MAX_VALUE;
    String closestDmcvalue = "";
    for (int i = 0; i < dmcIndex.size(); i++) {
      int rBar = (r + Integer.valueOf(dmcIndex.get(i).get(1))) / 2;
      int deltaR = r - Integer.valueOf(dmcIndex.get(i).get(1));
      int deltaG = g - Integer.valueOf(dmcIndex.get(i).get(2));
      int deltaB = b - Integer.valueOf(dmcIndex.get(i).get(3));
      double expressionValue = ((2 + (rBar / 256)) * deltaR * deltaR) + (4 * deltaG * deltaG)
          + ((2 + (255 - rBar) / 256) * deltaB * deltaB);
      double deltaC = Math.sqrt(expressionValue);
      if (minDeltaC > deltaC) {
        minDeltaC = deltaC;
        closestDmcvalue = dmcIndex.get(i).get(0);
      }
    }
    return closestDmcvalue;
  }

  private int[] findClosestColor(int r, int g, int b, List<List<String>> dmc) {
    int[] color = new int[3];
    double minDeltaC = Integer.MAX_VALUE;
    for (int i = 0; i < dmc.size(); i++) {
      int rBar = (r + Integer.valueOf(dmc.get(i).get(1))) / 2;
      int deltaR = r - Integer.valueOf(dmc.get(i).get(1));
      int deltaG = g - Integer.valueOf(dmc.get(i).get(2));
      int deltaB = b - Integer.valueOf(dmc.get(i).get(3));
      double expressionValue = ((2 + (rBar / 256)) * deltaR * deltaR) + (4 * deltaG * deltaG)
          + ((2 + (255 - rBar) / 256) * deltaB * deltaB);
      double deltaC = Math.sqrt(expressionValue);
      if (minDeltaC > deltaC) {
        minDeltaC = deltaC;
        for (int k = 0; k < 3; k++) {
          color[k] = Integer.valueOf(dmc.get(i).get(k + 1));
        }
      }
    }
    return color;
  }

  private void generateP(int[][][] imageMatrix, int xSize, List<List<String>> dmcIndextemp,
      char[][] output, List<List<String>> dmcLeg) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException(" image should be non null");
    }
    Map<String, Character> dmccolors = new TreeMap<String, Character>(new CrossStitch());
    char symbol = 'a';
    int a = 0;
    int b = 0;
    for (int i = 0; i + xSize < imageMatrix.length; i = i + xSize) {
      for (int j = 0; j + xSize < imageMatrix[0].length; j = j + xSize) {
        String temp = findClosestDmc(imageMatrix[i][j][0], imageMatrix[i][j][1],
            imageMatrix[i][j][2], dmcIndextemp);
        if (!dmccolors.containsKey(temp)) {
          while (!Character.isLetterOrDigit(symbol)) {
            symbol++;
          }
          dmccolors.put(temp, symbol++);
        }
        output[a][b++] = dmccolors.get(temp);
      }
      a++;
      b = 0;
    }

    dmcLeg.clear();

    for (Map.Entry<String, Character> entry : dmccolors.entrySet()) {
      List<String> temp = new ArrayList<>();
      temp.add(entry.getValue().toString());
      temp.add(": DMC-");
      temp.add(entry.getKey());
      for (int i = 0; i < dmcIndextemp.size(); i++) {
        if (dmcIndextemp.get(i).get(0).equals(entry.getKey())) {
          temp.add(dmcIndextemp.get(i).get(1));
          temp.add(dmcIndextemp.get(i).get(2));
          temp.add(dmcIndextemp.get(i).get(3));
          break;
        }
      }
      dmcLeg.add(temp);
    }
  }

  @Override
  public void generatePattern(int[][][] imageMatrix, int xSize) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    outputPattern = new char[imageMatrix.length / xSize + 1][imageMatrix[0].length / xSize + 1];
    generateP(imageMatrix, xSize, dmcIndex, outputPattern, this.dmcLegend);
  }

  @Override
  public char[][] getdmcMatrix() {
    if (outputPattern == null) {
      throw new IllegalStateException("Pattern not generated");
    }
    char[][] copy = new char[outputPattern.length][outputPattern[0].length];
    for (int i = 0; i < outputPattern.length; i++) {
      for (int j = 0; j < outputPattern[0].length; j++) {
        copy[i][j] = outputPattern[i][j];
      }
    }
    return copy;
  }

  @Override
  public List<List<String>> getdmcLegend() {
    if (dmcLegend == null) {
      throw new IllegalStateException("Pattern not generated");
    }
    return copyLegend(dmcLegend);
  }

  private List<List<String>> copyLegend(List<List<String>> dmcLegend) {
    List<List<String>> copy = new ArrayList<>();
    for (int i = 0; i < dmcLegend.size(); i++) {
      List<String> temp = new ArrayList<>();
      for (int j = 0; j < dmcLegend.get(0).size(); j++) {
        temp.add(dmcLegend.get(i).get(j));
      }
      copy.add(temp);
    }
    return copy;
  }

  @Override
  public List<List<String>> getcompletedmcLegend() {
    return copyLegend(dmcIndex);
  }

  private int[][][] getImgMatrix(int[][][] imageMatrix) {
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

  private int[][][] helperColorTransformation(int[][][] imageMatrix, List<List<String>> dmc) {
    if (imageMatrix == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    for (int i = 0; i < imageMatrix.length; i++) {
      for (int j = 0; j < imageMatrix[0].length; j++) {
        int[] temp = findClosestColor(imageMatrix[i][j][0], imageMatrix[i][j][1],
            imageMatrix[i][j][2], dmc);
        for (int k = 0; k < 3; k++) {
          imageMatrix[i][j][k] = temp[k];
        }
      }
    }
    return this.getImgMatrix(imageMatrix);
  }

  @Override
  public int[][][] dmcColorTransformation(int[][][] imageMatrix) {
    return helperColorTransformation(imageMatrix, dmcIndex);
  }

  @Override
  public int[][][] convertToOwnDmcIndex(int[][][] imageMatrix) {

    return helperColorTransformation(imageMatrix, userDmcIndex);
  }

  @Override
  public void removeColor(String dmc) {
    if (dmc == null) {
      throw new IllegalArgumentException("Dmc can't be null");
    }
    int position = 0;
    for (int i = 0; i < dmcLegend.size(); i++) {
      if (dmcLegend.get(i).get(2).equals(dmc)) {
        position = i;
        break;
      }
    }
    char removedSymbol = dmcLegend.get(position).get(0).charAt(0);

    
    List<String> temp = new ArrayList<>();
    temp.add(". ");
    temp.add(" dmc:");
    temp.add("blank");
    temp.add(dmcLegend.get(position).get(3));
    temp.add(dmcLegend.get(position).get(4));
    temp.add(dmcLegend.get(position).get(5));
    dmcLegend.remove(position);
    for (int i = 0; i < outputPattern.length; i++) {
      for (int j = 0; j < outputPattern[0].length; j++) {
        if (outputPattern[i][j] == removedSymbol) {
          outputPattern[i][j] = '.';
        }
      }
    }
    this.dmcLegend.add(0, temp);
  }

  @Override
  public int[][][] replaceColor(int[][][] imageMatrix, int x, int y, String dmc) {
    if (dmc == null || imageMatrix == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    int[] oldcolor = new int[3];
    int[] newcolor = new int[3];
    // getting new color
    newcolor = getColorForDmc(dmc);

    // getting old color
    for (int i = 0; i < 3; i++) {
      oldcolor[i] = imageMatrix[x][y][i];
    }

    // replacing old with new color
    for (int i = 0; i < imageMatrix.length; i++) {
      for (int j = 0; j < imageMatrix[0].length; j++) {

        if (imageMatrix[i][j][0] == oldcolor[0] && imageMatrix[i][j][1] == oldcolor[1]
            && imageMatrix[i][j][2] == oldcolor[2]) {
          imageMatrix[i][j][0] = newcolor[0];
          imageMatrix[i][j][1] = newcolor[1];
          imageMatrix[i][j][2] = newcolor[2];
        }

      }
    }

    return this.getImgMatrix(imageMatrix);
  }

  private void writeText(int[][][] imageMatrix, int x, int y, int pixelSize, int[] fontColor) {
    if (fontColor == null || imageMatrix == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    for (int c = 0; c < pixelSize; c++) {
      for (int d = 0; d < pixelSize; d++) {
        for (int k = 0; k < 3; k++) {
          if (x + c >= imageMatrix.length || y + d >= imageMatrix[0].length) {
            throw new IllegalStateException("Text does not fit in image");
          }
          imageMatrix[x + c][y + d][k] = fontColor[k];
        }
      }
    }
  }

  private int[] getColorForDmc(String dmc) {
    int[] fontColor = new int[3];
    for (int i = 0; i < dmcIndex.size(); i++) {
      if (dmcIndex.get(i).get(0).equals(dmc)) {
        fontColor[0] = Integer.valueOf(dmcIndex.get(i).get(1));
        fontColor[1] = Integer.valueOf(dmcIndex.get(i).get(2));
        fontColor[2] = Integer.valueOf(dmcIndex.get(i).get(3));
        break;
      }
    }
    return fontColor;
  }

  @Override
  public int[][][] addText(int[][][] imageMatrix, String text, String dmc, int startx,
      int pixelSize) {
    if (imageMatrix == null || text == null || dmc == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    int[] fontColor = getColorForDmc(dmc);
    int ypos = 0;
    for (int i = 0; i < text.length(); i++) {
      int[][] stitchPattern = Font.letterMatrix(text.charAt(i));
      int xpos = startx;
      int y = ypos;
      for (int a = 0; a < stitchPattern.length; a++) {
        for (int b = 0; b < stitchPattern[0].length; b++) {
          if (stitchPattern[a][b] == 1) {
            writeText(imageMatrix, xpos, y, pixelSize, fontColor);
          }
          y += pixelSize;
        }
        xpos += pixelSize;
        y = ypos;
      }
      ypos += stitchPattern[0].length * pixelSize;
    }
    return this.getImgMatrix(imageMatrix);
  }

  @Override
  public void updateDmc(int[][][] imageMatrix, int xSize, List<String> newDmc) {
    if (imageMatrix == null || newDmc == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    List<List<String>> nwDmcIndex = new ArrayList<>();

    for (String dmc : newDmc) {
      for (int i = 0; i < dmcIndex.size(); i++) {
        if (dmcIndex.get(i).get(0).equals(dmc)) {
          List<String> temp = new ArrayList<>();
          temp.add(dmc);
          temp.add(dmcIndex.get(i).get(1));
          temp.add(dmcIndex.get(i).get(2));
          temp.add(dmcIndex.get(i).get(3));
          nwDmcIndex.add(temp);
          break;
        }
      }
    }
    userDmcIndex = nwDmcIndex;

    useroutputPattern = new char[imageMatrix.length / xSize + 1][imageMatrix[0].length / xSize + 1];
    generateP(imageMatrix, xSize, nwDmcIndex, useroutputPattern, this.userdmcLegend);

  }

  @Override
  public List<List<String>> getOwnDmcLegend() {
    if (userdmcLegend == null) {
      throw new IllegalStateException("Pattern not generated");
    }

    return copyLegend(userdmcLegend);
  }

  @Override
  public char[][] getOwnDmcCharactermatrix() {
    // TODO Auto-generated method stub
    if (useroutputPattern == null) {
      throw new IllegalStateException("Pattern not generated");
    }
    char[][] copy = new char[useroutputPattern.length][useroutputPattern[0].length];
    for (int i = 0; i < useroutputPattern.length; i++) {
      for (int j = 0; j < useroutputPattern[0].length; j++) {
        copy[i][j] = useroutputPattern[i][j];
      }
    }
    return copy;
  }
}
