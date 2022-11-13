package imagescontroller;

import imagesmodel.ImageInterface;
import view.ViewInterface;

import java.io.IOException;
import java.util.List;

/**
 * This class represents the implementation of the various operations performed
 * by the controller with a view and a model.
 * 
 * @author ananth
 *
 */
public class ViewControllerImpl implements ViewControllerInterface, ControllerSystem {
  private ImageInterface model;
  private ViewInterface view;
  private Appendable appendable;

  /**
   * This class creates an object on an instance of the controller. It can be used
   * to perform various tasks such as read, write, dither, blur, sharpen,
   * greyscale, sepia, mosaic, pattern generation and pixelaation.
   * 
   * @param model the model which is going to perform these operations
   */
  public ViewControllerImpl(ImageInterface model, Appendable appen) {
    if (model == null || appen == null) {
      throw new IllegalArgumentException("Invalid argument");
    }

    this.model = model;
    this.appendable = appen;
  }

  @Override
  public void setView(ViewInterface v) {
    if (v == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    view = v;
    // give the feature callbacks to the view
    view.setFeatures(appendable, this);

  }

  @Override
  public void readImage(String location) {
    // TODO Auto-generated method stub
    if (location == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    try {
      model.loadImage(appendable, location);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Image can't be read");
    }
    view.setImg(appendable, model.notifyView(appendable));
  }

  @Override
  public void writeImage(String location) {
    // TODO Auto-generated method stub
    if (location == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    try {
      model.writeImage(appendable, location);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      throw new IllegalArgumentException("Image can't be written");
    }
    
  }

  @Override
  public void blur() {
    // TODO Auto-generated method stub
    model.imgBlur(appendable);
    view.setImg(appendable, model.notifyView(appendable));
   
  }

  @Override
  public void sharpen() {
    // TODO Auto-generated method stub
    model.imgSharpen(appendable);
    view.setImg(appendable, model.notifyView(appendable));
    
  }

  @Override
  public void writeDmcFile(String location) {
    // TODO Auto-generated method stub
    if (location == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.writeDmcFile(appendable, location);

  }

  @Override
  public void dither() {
    // TODO Auto-generated method stub
    model.ditherImage(appendable);
    view.setImg(appendable, model.notifyView(appendable));
  }

  @Override
  public void greyScale() {
    // TODO Auto-generated method stub
    model.greyScale(appendable);
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public void sepiaTone() {
    // TODO Auto-generated method stub
    model.sepiaTone(appendable);
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public void addText(String argument) {
    // TODO Auto-generated method stub
    if (argument == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    String[] s = argument.split(" ");
    model.addText(appendable, s[0], s[1]);
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public void crossStitch() {
    // TODO Auto-generated method stub
    model.imageCrossStitch(appendable);
    view.setImg(appendable, model.notifyView(appendable));
    view.crossStitch(appendable, model.getDmcIndex());

  }

  @Override
  public void removeDmcColor(String argument) {
    // TODO Auto-generated method stub
    if (argument == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.removeColor(appendable, argument);
    view.setImg(appendable, model.notifyView(appendable));
    view.crossStitch(appendable, model.getDmcIndex());

  }

  @Override
  public List<List<String>> getDmcIndex() {
    return model.getDmcIndex();
  }

  @Override
  public void mosaic(String seeds) {
    // TODO Auto-generated method stub
    if (seeds == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.imageMosaic(appendable, Integer.valueOf(seeds));
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public void pixellation(String blocks) {
    // TODO Auto-generated method stub
    if (blocks == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.imagePixelation(appendable, Integer.valueOf(blocks));
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public void replaceDmcColor(String argument) {
    // TODO Auto-generated method stub
    if (argument == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    String[] s = argument.split(" ");
    model.replaceWithDmc(appendable, Integer.valueOf(s[0]), Integer.valueOf(s[1]), s[2]);
    view.setImg(appendable, model.notifyView(appendable));

  }

  @Override
  public List<List<String>> completeDmcIndex() {
    // TODO Auto-generated method stub
    return model.getCompleteDmcIndex(appendable);
  }

  @Override
  public void convertToDmcColors() {
    // TODO Auto-generated method stub
    model.displayDmcColor(appendable);
    view.setImg(appendable, model.notifyView(appendable));
  }

  @Override
  public void executeBatchCommands(Readable commands) {
    if (commands == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    ImageControllerInterface batchController = new ImageControllerImpl(model);
    batchController.parseAndProcess(commands, appendable);
    view.setImg(appendable, model.notifyView(appendable));
  }

  @Override
  public void newDmcIndex(List<String> dmc) {
    // TODO Auto-generated method stub
    if (dmc == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.updateDmcIndex(appendable, dmc);
    view.setImg(appendable, model.notifyView(appendable));
    view.crossStitch(appendable, model.getUserDmcIndex(appendable));

  }

  @Override
  public void setUpReplaceColorcoordintes() {
    // TODO Auto-generated method stub
    view.replaceDmcColor(appendable, this);
  }

  @Override
  public void setUpReplaceColorcolor(String coordinates) {
    // TODO Auto-generated method stub
    if (coordinates == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    view.getReplaceColor(appendable, this, coordinates);
  }

  @Override
  public void writeOwnDmcCharactermatrix(String location) {
    // TODO Auto-generated method stub
    if (location == null) {
      throw new IllegalArgumentException("Invalid argument");
    }
    model.writeUserDmcFile(appendable, location);

  }
}
