package imagesmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents reading of a Dmc index.
 * 
 * @author ananth
 *
 */
public class ReadDmc {
  private InputStream getFileFromResourceAsStream(String fileName) {

    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    if (inputStream == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return inputStream;
    }

  }

  /**
   * This method is used to read the dmc index from file.
   * 
   * @return the dmc index
   * @throws IOException thrown if error in reading the file.
   */
  public static List<List<String>> readDmc() throws ClassNotFoundException, IOException {
    String filename = "dmc_floss.csv";
    List<List<String>> dmcIndex = new ArrayList<>();
    ReadDmc app = new ReadDmc();
    String line = "";
    String splitBy = ",";
    InputStream i = app.getFileFromResourceAsStream(filename);
    BufferedReader br = new BufferedReader(new InputStreamReader(i));
    while ((line = br.readLine()) != null) {
      List<String> row = new ArrayList<>();
      String[] entry = line.split(splitBy);
      row.add(entry[0]);
      row.add(entry[2]);
      row.add(entry[3]);
      row.add(entry[4]);
      dmcIndex.add(row);
    }
    br.close();

    return dmcIndex;
  }
}
