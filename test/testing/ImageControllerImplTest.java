package testing;

import static org.junit.Assert.assertEquals;

import imagescontroller.Commands;
import imagescontroller.ImageControllerImpl;
import imagescontroller.ImageControllerInterface;
import imagesmodel.ImageInterface;
import imagesmodel.MockModel;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

/**
 * This class is used to test if the batch file controller works correctly.
 * 
 * @author ananth
 *
 */
public class ImageControllerImplTest {
  private ImageControllerInterface controller;
  private Appendable output;

  /**
   * This method is used for setting up the test cases.
   */
  @Before
  public void setUp() {
    output = new StringBuilder();
    ImageInterface model = new MockModel();
    controller = new ImageControllerImpl(model);
  }

  /**
   * Testing for read command.
   */
  @Test
  public void testRead() {
    controller.parseAndProcess(new StringReader("READ input.jpg"), output);
    assertEquals("IMAGEREAD\n", output.toString());
  }

  /**
   * Testing for write command.
   */
  @Test
  public void testWrite() {
    controller.parseAndProcess(new StringReader("WRITE output.jpg"), output);
    assertEquals("IMAGEWRITE\n", output.toString());
  }

  /**
   * Testing for greyscale command.
   */
  @Test
  public void testGreyscale() {
    controller.parseAndProcess(new StringReader(Commands.GREYSCALE.toString()), output);
    assertEquals("GREYSCALE\n", output.toString());
  }

  /**
   * Testing for sepia tone command.
   */
  @Test
  public void testSepiaTone() {
    controller.parseAndProcess(new StringReader(Commands.SEPIATONE.toString()), output);
    assertEquals("SEPIATONE\n", output.toString());
  }

  /**
   * Testing for sharpen command.
   */
  @Test
  public void testSharpen() {
    controller.parseAndProcess(new StringReader("SHARPEN"), output);
    assertEquals("SHARPEN\n", output.toString());
  }

  /**
   * Testing for blur command.
   */
  @Test
  public void testblur() {
    controller.parseAndProcess(new StringReader(Commands.BLUR.toString()), output);
    assertEquals("BLUR\n", output.toString());
  }

  /**
   * Testing for dither command.
   */
  @Test
  public void testDither() {
    controller.parseAndProcess(new StringReader("DITHER"), output);
    assertEquals("DITHER\n", output.toString());
  }

  /**
   * Testing for mosaic command.
   */
  @Test
  public void testMosiac() {
    controller.parseAndProcess(new StringReader("MOSAIC 1650"), output);
    assertEquals("MOSIAC\n", output.toString());
  }

  /**
   * Testing for pixellate command.
   */
  @Test
  public void testPixellate() {
    controller.parseAndProcess(new StringReader("PIXELLATE 1650"), output);
    assertEquals("PIXELLATION\n", output.toString());
  }

  /**
   * Testing for cross stitch.
   */
  @Test
  public void testCrossStitch() {
    controller.parseAndProcess(new StringReader("CROSSTITCH"), output);
    assertEquals("CROSSSTITCHPERFORMED\n", output.toString());
  }

  /**
   * Testing for writing cross stitch.
   */
  @Test
  public void testWriteCrossStitch() {
    controller.parseAndProcess(new StringReader("WRITECROSSTITCH a1.jpg"), output);
    assertEquals("WRITECROSSSTITCHFILE\n", output.toString());
  }

  /**
   * Testing for remove cross stitch color.
   */
  @Test
  public void testRemovingCrossStitch() {
    controller.parseAndProcess(new StringReader("REMOVECOLOR 3317"), output);
    assertEquals("REMOVEDDMC\n", output.toString());
  }

  /**
   * Testing for replace cross stitch color.
   */
  @Test
  public void testReplacingCrossStitch() {
    controller.parseAndProcess(new StringReader("REPLACECOLOR 2 2 3317"), output);
    assertEquals("REPLACEDDMC\n", output.toString());
  }

  /**
   * Testing for adding text to cross stitch.
   */
  @Test
  public void testAddTextCrossStitch() {
    controller.parseAndProcess(new StringReader("ADDTEXT abc 3317"), output);
    assertEquals("ADDTEXT\n", output.toString());
  }

  /**
   * Testing for change image to dmc colors.
   */
  @Test
  public void testConvertToDmcColors() {
    controller.parseAndProcess(new StringReader("CONVERTINGIMGDMC"), output);
    assertEquals("IMAGECONVERTEDTODMCCOLORS\n", output.toString());
  }

  /**
   * Testing for invalid parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidParameterMosaic() {
    controller.parseAndProcess(new StringReader("MOSAIC -2"), output);
  }

  /**
   * Testing for invalid parameter.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidParameterPixellation() {
    controller.parseAndProcess(new StringReader("PIXELLATION -2"), output);
  }

  /**
   * Testing for invalid command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCommand() {
    controller.parseAndProcess(new StringReader("ABCD"), output);
  }
}
