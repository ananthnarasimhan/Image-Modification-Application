package imagescontroller;

import view.ViewInterface;

/**
 * This interface represents the methods offered by the controller for setting
 * up.
 * 
 * @author ananth
 *
 */
public interface ControllerSystem {
  /**
   * This method is used to set the view to the controller.
   * @param v The view attached to this controller.
   */
  public void setView(ViewInterface v);
}
