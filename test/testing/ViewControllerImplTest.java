package testing;

import static org.junit.Assert.assertEquals;

import imagescontroller.ControllerSystem;
import imagescontroller.ViewControllerImpl;
import imagescontroller.ViewControllerInterface;
import imagesmodel.ImageInterface;
import imagesmodel.MockModel;
import org.junit.Before;
import org.junit.Test;
import view.MockView;
import view.ViewInterface;

/**
 * This class mocks the view and calls various methods of the controller as a
 * view would do.
 * 
 * @author ananth
 *
 */
public class ViewControllerImplTest {
  private ImageInterface model;
  private Appendable appen;
  private ControllerSystem controller;

  /**
   * Setting up the test cases.
   * 
   */
  @Before
  public void setUp() {
    model = new MockModel();
    appen = new StringBuilder();
    controller = new ViewControllerImpl(model, appen);

  }

  /**
   * Testing read operation from view.
   */
  @Test
  public void testRead() {
    ViewInterface view = new MockView("IMAGEREAD");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "IMAGEREAD\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing write operation from view.
   */
  @Test
  public void testWrite() {
    ViewInterface view = new MockView("IMAGEWRITE");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "IMAGEWRITE\n", appen.toString());
  }

  /**
   * Testing blur operation from view.
   */
  @Test
  public void testBlur() {
    ViewInterface view = new MockView("BLUR");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "BLUR\n" + "SETVIEW\n" + "VIEWSETIMG\n", appen.toString());
  }

  /**
   * Testing sharpen operation from view.
   */
  @Test
  public void testSharpen() {
    ViewInterface view = new MockView("SHARPEN");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "SHARPEN\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing dither operation from view.
   */
  @Test
  public void testDither() {
    ViewInterface view = new MockView("DITHER");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "DITHER\n" + "SETVIEW\n" + "VIEWSETIMG\n", appen.toString());
  }

  /**
   * Testing batch script execution operation from view.
   */
  @Test
  public void testBatchScript() {
    ViewInterface view = new MockView("BATCHSCRIPTEXECUTED");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "IMAGEREAD\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing grey scale operation from view.
   */
  @Test
  public void testGreyScale() {
    ViewInterface view = new MockView("GREYSCALE");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "GREYSCALE\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing sepia tone operation from view.
   */
  @Test
  public void testSepiaTone() {
    ViewInterface view = new MockView("SEPIATONE");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "SEPIATONE\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing mosaic operation from view.
   */
  @Test
  public void testMosaic() {
    ViewInterface view = new MockView("MOSIAC");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "MOSIAC\n" + "SETVIEW\n" + "VIEWSETIMG\n", appen.toString());
  }

  /**
   * Testing pixellation operation from view.
   */
  @Test
  public void testPixellation() {
    ViewInterface view = new MockView("PIXELLATION");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "PIXELLATION\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing cross stitch operation from view.
   */
  @Test
  public void testCrossStitch() {
    ViewInterface view = new MockView("CROSSSTITCHPERFORMED");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "CROSSSTITCHPERFORMED\n" + "SETVIEW\n" + "VIEWSETIMG\n"
        + "VIEWCROSSSTITCH\n", appen.toString());
  }

  /**
   * Testing writing cross stitch operation from view.
   */
  @Test
  public void testWriteCrossStitch() {
    ViewInterface view = new MockView("WRITECROSSSTITCHFILE");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "WRITECROSSSTITCHFILE\n", appen.toString());
  }

  /**
   * Testing image to cross stitch image operation from view.
   */
  @Test
  public void testConversiontoDmc() {
    ViewInterface view = new MockView("IMAGECONVERTEDTODMCCOLORS");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "IMAGECONVERTEDTODMCCOLORS\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing remove dmc operation from view.
   */
  @Test
  public void testRemoveDmc() {
    ViewInterface view = new MockView("REMOVEDDMC");
    controller.setView(view);
    assertEquals(
        "VIEWSETFEATURES\n" + "REMOVEDDMC\n" + "SETVIEW\n" + "VIEWSETIMG\n" + "VIEWCROSSSTITCH\n",
        appen.toString());
  }

  /**
   * Testing replace dmc operation from view.
   */
  @Test
  public void testReplaceDmc() {
    ViewInterface view = new MockView("REPLACEDDMC");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "VIEWREPLACEDMCCOLOR\n" + "VIEWGETREPLACECOLOR\n"
        + "REPLACEDDMC\n" + "SETVIEW\n" + "VIEWSETIMG\n", appen.toString());
  }

  /**
   * Testing add text operation from view.
   */
  @Test
  public void testAddText() {
    ViewInterface view = new MockView("ADDTEXT");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "ADDTEXT\n" + "SETVIEW\n" + "VIEWSETIMG\n",
        appen.toString());
  }

  /**
   * Testing create own cross stitch operation from view.
   */
  @Test
  public void testCreateOwnCrossStitch() {
    ViewInterface view = new MockView("CREATEDOWNDMCINDEX");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "UPDATEDMCINDEX\n" + "SETVIEW\n" + "VIEWSETIMG\n"
        + "GETUSERDMCINDEX\n" + "VIEWCROSSSTITCH\n", appen.toString());
  }

  /**
   * Testing write own cross stitch operation from view.
   */
  @Test
  public void testWriteOwnCrossStitch() {
    ViewInterface view = new MockView("WRITTENOWNDMCINDEX");
    controller.setView(view);
    assertEquals("VIEWSETFEATURES\n" + "WRITTENOWNDMCINDEX\n", appen.toString());
  }

  /**
   * Testing for null input in add text.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullForAddText() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.addText(null);
  }

  /**
   * Testing for null input in write dmc.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullwriteDmc() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.writeDmcFile(null);
  }

  /**
   * Testing for null input in write image.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullwriteImage() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.writeImage(null);
  }

  /**
   * Testing for null input in read image.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullreadImage() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.readImage(null);
  }

  /**
   * Testing for null input in batch commands.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullbatchCommands() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.executeBatchCommands(null);
  }

  /**
   * Testing for null input in replace dmc.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullreplaceColor() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.replaceDmcColor(null);
  }

  /**
   * Testing for null input while creating a new dmc index.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullnewDmcIndex() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.newDmcIndex(null);
  }

  /**
   * Testing for null input while setting up a replace command.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullsetUpReplaceColorcolor() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.setUpReplaceColorcolor(null);
  }

  /**
   * Testing for null input while writing own dmc cross stitch pattern.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullwriteOwnDmcCharactermatrix() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.writeOwnDmcCharactermatrix(null);
  }

  /**
   * Testing for null input while setting the view.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testsetView() {
    controller.setView(null);
  }

  /**
   * Testing with null model while creating a controller.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullModel() {
    new ViewControllerImpl(null, appen);
  }

  /**
   * Testing with null appendable while creating a controller.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullAppendable() {
    new ViewControllerImpl(model, null);
  }

  /**
   * Testing for null input for remove dmc color .
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullRemoveColor() {
    ViewControllerInterface viewcontroller = new ViewControllerImpl(model, appen);
    viewcontroller.removeDmcColor(null);
  }
}
