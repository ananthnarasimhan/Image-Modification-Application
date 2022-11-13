package imagesmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a various letters.
 * 
 * @author ananth
 *
 */
public class Font {
  /**
   * This method will return a integer matrix depending upon the character.
   * 
   * @param input the character whose integer ,matrix we need.
   * @return the image matrix of the character.
   */
  public static int[][] letterMatrix(char input) {
    final int[][] chara = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1 } };
    final int[][] charb = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charc = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] chard = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] chare = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 },
        { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
    final int[][] charf = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 },
        { 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 } };
    final int[][] charg = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charh = new int[][] { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 } };
    final int[][] chari = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
    final int[][] charj = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0 } };
    final int[][] chark = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 0, 1 } };
    final int[][] charl = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0 } };
    final int[][] charm = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
        { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 } };
    final int[][] charn = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 } };
    final int[][] charo = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charp = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0 } };
    final int[][] charq = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 } };
    final int[][] charr = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0 } };

    final int[][] chars = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] chart = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
    final int[][] charu = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
        { 0, 1, 0, 0, 1 }, { 0, 0, 1, 1, 0 } };
    final int[][] charv = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 } };
    final int[][] charw = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 } };
    final int[][] charx = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 } };
    final int[][] chary = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 }, };
    final int[][] charz = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0 } };

    final int[][] charA = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 } };
    final int[][] charB = new int[][] { { 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0 } };
    final int[][] charC = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 } };
    final int[][] charD = new int[][] { { 0, 1, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0 } };
    final int[][] charE = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, };
    final int[][] charF = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 } };
    final int[][] charG = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
        { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 } };
    final int[][] charH = new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 } };

    final int[][] charI = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charJ = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0 } };
    final int[][] charK = new int[][] { { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0 },
        { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 } };
    final int[][] charL = new int[][] { { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0 } };
    final int[][] charM = new int[][] { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 } };
    final int[][] charN = new int[][] { { 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 },
        { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 } };

    final int[][] charO = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charP = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 } };
    final int[][] charQ = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 },
        { 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 } };
    final int[][] charR = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0 } };
    final int[][] charS = new int[][] { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 },
        { 0, 0, 0, 1, 0 }, { 1, 1, 1, 1, 0 } };
    final int[][] charT = new int[][] { { 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };

    final int[][] charU = new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
    final int[][] charV = new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 } };
    final int[][] charW = new int[][] { { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
        { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 0 } };
    final int[][] charX = new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 } };
    final int[][] charY = new int[][] { { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
    final int[][] charZ = new int[][] { { 1, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0 },
        { 0, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 } };
    Map<Character, int[][]> map = new HashMap<>();
    map.put('a', chara);
    map.put('b', charb);
    map.put('c', charc);
    map.put('d', chard);
    map.put('e', chare);
    map.put('f', charf);
    map.put('g', charg);
    map.put('h', charh);
    map.put('i', chari);
    map.put('j', charj);
    map.put('k', chark);
    map.put('l', charl);
    map.put('m', charm);
    map.put('n', charn);
    map.put('o', charo);
    map.put('p', charp);
    map.put('q', charq);
    map.put('r', charr);
    map.put('s', chars);
    map.put('t', chart);
    map.put('u', charu);
    map.put('v', charv);
    map.put('w', charw);
    map.put('x', charx);
    map.put('y', chary);
    map.put('z', charz);

    map.put('A', charA);
    map.put('B', charB);
    map.put('C', charC);
    map.put('D', charD);
    map.put('E', charE);
    map.put('F', charF);
    map.put('G', charG);
    map.put('H', charH);
    map.put('I', charI);
    map.put('J', charJ);
    map.put('K', charK);
    map.put('L', charL);
    map.put('M', charM);
    map.put('N', charN);
    map.put('O', charO);
    map.put('P', charP);
    map.put('Q', charQ);
    map.put('R', charR);
    map.put('S', charS);
    map.put('T', charT);
    map.put('U', charU);
    map.put('V', charV);
    map.put('W', charW);
    map.put('X', charX);
    map.put('Y', charY);
    map.put('Z', charZ);

    int[][] output = map.get(input);
    int[][] copy = new int[output.length][output[0].length];
    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output[0].length; j++) {
        copy[i][j] = output[i][j];
      }
    }
    return copy;
  }
}
