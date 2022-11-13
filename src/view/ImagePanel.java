package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * This class represent a panel of which an image is stored.
 * 
 * @author ananth
 *
 */
public class ImagePanel extends JPanel {

  /** Generated version id. */
  private static final long serialVersionUID = -7919107801874775685L;

  private BufferedImage image;

  /**
   * This is a constructor which initializes the buffered image. It sets it to
   * null which helps to maintain the constraint and it is not possible to paint
   * the image panel without setting the image.
   */
  public ImagePanel() {
    image = null;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, this);
    }
  }
}
