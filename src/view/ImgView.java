package view;

import imagescontroller.ViewControllerInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 * This class represents the UI for our application. It provides all the various
 * operation needed to be performed on the image such as blur, sharpen,
 * pixellate, mosaic, read, write, perform cross stitch,replace dmc as well as
 * display the image . color,remove cross stich color,
 * 
 * @author ananth
 *
 */
public class ImgView extends JFrame implements ViewInterface {
  private static final long serialVersionUID = -2492025591092884851L;
  private ImagePanel imagePanel;

  private JMenuItem menuItemReplaceDmc;
  private JMenuItem menuItemRemoveDmc;
  private JMenuItem menuItemAddText;
  private JMenuItem menuItemDisplayImgCross;
  private JMenuItem menuItemWriteCross;
  private JMenuItem menuItemPerformCross;
  private JMenuItem menuItemPixellation;
  private JMenuItem menuItemMosaic;
  private JMenuItem menuItemSepia;
  private JMenuItem menuItemGrey;
  private JMenuItem menuItemLoad;
  private JMenuItem menuItemSave;
  private JMenuItem menuItemBlur;
  private JMenuItem menuItemSharpen;
  private JMenuItem menuItemDither;
  private JMenuItem batchScript;
  private JMenuItem menuItemWriteOwnDmcFile;
  private JMenuItem menuItemOwnDmcColors;
  private JRadioButton radioButton;
  private ButtonGroup buttonGroup;

  JPanel right;
  ScrollablePicture picture;
  JScrollPane pictureScrollPane;
  // JPanel p1 = new JPanel();
  JCheckBox[] cbarr;
  JLabel[] jlarr;
  JList<JLabel> list;

  /**
   * This is a constructor that initializes all the instance variables.
   * 
   * @param title The title of the UI for the application.
   */
  public ImgView(String title) {
    super(title);

    list = new JList<>();
    // needed for JFrame
    this.setSize(800, 600);
    this.setLocation(10, 10);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // necessary so it closes correctly
    this.setLayout(new BorderLayout());

    imagePanel = new ImagePanel();
    JScrollPane pane = new JScrollPane(imagePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(pane, BorderLayout.CENTER);
    // Menu code

    right = new JPanel(new FlowLayout(FlowLayout.CENTER));
    right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

    // Build the first menu.
    JMenuBar menuBar = new JMenuBar();
    JMenu menuLoad = new JMenu("Load Save Images");
    menuLoad.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuLoad);

    // a group of JMenuItems
    menuItemLoad = new JMenuItem("Load Image", KeyEvent.VK_T);
    menuItemLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuLoad.add(menuItemLoad);

    menuItemSave = new JMenuItem("Save Image", KeyEvent.VK_T);
    menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuLoad.add(menuItemSave);

    JMenu runbatchScript = new JMenu("Batch Script");
    runbatchScript.setMnemonic(KeyEvent.VK_A);
    menuBar.add(runbatchScript);

    // a group of JMenuItems
    batchScript = new JMenuItem("Run batch script", KeyEvent.VK_T);
    batchScript.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    runbatchScript.add(batchScript);

    JMenu menuFilter = new JMenu("Filter Images");
    menuFilter.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuFilter);

    // a group of JMenuItems
    menuItemBlur = new JMenuItem("Blur Image", KeyEvent.VK_T);
    menuItemBlur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuFilter.add(menuItemBlur);

    menuItemSharpen = new JMenuItem("Sharpen Image");
    menuItemSharpen.setMnemonic(KeyEvent.VK_B);
    menuFilter.add(menuItemSharpen);

    JMenu menuDither = new JMenu("Dither Images");
    menuDither.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuDither);

    menuItemDither = new JMenuItem("Dither Image");
    menuItemDither.setMnemonic(KeyEvent.VK_B);
    menuDither.add(menuItemDither);

    JMenu menuColorTransform = new JMenu("Color Transformation");
    menuColorTransform.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuColorTransform);

    // a group of JMenuItems
    menuItemGrey = new JMenuItem("Grey Scale", KeyEvent.VK_T);
    menuItemGrey.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuColorTransform.add(menuItemGrey);

    menuItemSepia = new JMenuItem("Sepia tone");
    menuItemSepia.setMnemonic(KeyEvent.VK_B);
    menuColorTransform.add(menuItemSepia);

    JMenu menuSmudge = new JMenu("Color Smudging");
    menuSmudge.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuSmudge);

    // a group of JMenuItems
    menuItemMosaic = new JMenuItem("Mosaic", KeyEvent.VK_T);
    menuItemMosaic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuSmudge.add(menuItemMosaic);

    menuItemPixellation = new JMenuItem("Pixellation");
    menuItemPixellation.setMnemonic(KeyEvent.VK_B);
    menuSmudge.add(menuItemPixellation);

    JMenu menuCross = new JMenu("Cross stitch");
    menuCross.setMnemonic(KeyEvent.VK_A);
    menuBar.add(menuCross);

    menuItemPerformCross = new JMenuItem("Perform cross stitch", KeyEvent.VK_T);
    menuItemPerformCross
        .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuCross.add(menuItemPerformCross);

    menuItemWriteCross = new JMenuItem("Write stitch on file");
    menuItemWriteCross.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemWriteCross);

    menuItemDisplayImgCross = new JMenuItem("Convert to cross stitch Image");
    menuItemDisplayImgCross.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemDisplayImgCross);

    menuItemRemoveDmc = new JMenuItem("Remove DMC");
    menuItemRemoveDmc.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemRemoveDmc);

    menuItemReplaceDmc = new JMenuItem("Replace DMC");
    menuItemReplaceDmc.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemReplaceDmc);

    menuItemAddText = new JMenuItem("Add text");
    menuItemAddText.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemAddText);

    menuItemOwnDmcColors = new JMenuItem("Own dmc Index");
    menuItemOwnDmcColors.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemOwnDmcColors);

    menuItemWriteOwnDmcFile = new JMenuItem("Write dmc Index");
    menuItemWriteOwnDmcFile.setMnemonic(KeyEvent.VK_B);
    menuCross.add(menuItemWriteOwnDmcFile);

    JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    menuPanel.add(menuBar);
    menuBar.setEnabled(true);
    this.add(menuPanel, BorderLayout.NORTH);

    this.add(right, BorderLayout.EAST);
    this.setVisible(true);
  }

  @Override
  public void setFeatures(Appendable output, ViewControllerInterface viewControllerImpl) {
    menuItemLoad.addActionListener(l -> {
      String filename = this.getFile();
      if (!filename.equals("Failed to READ")) {
        viewControllerImpl.readImage(filename);
      }
    });
    menuItemSave.addActionListener(l -> {
      String filename = this.saveFile();
      if (!filename.equals("Failed to READ")) {
        viewControllerImpl.writeImage(filename);
      }
    });
    menuItemBlur.addActionListener(l -> viewControllerImpl.blur());
    menuItemSharpen.addActionListener(l -> viewControllerImpl.sharpen());
    menuItemSepia.addActionListener(l -> viewControllerImpl.sepiaTone());
    menuItemGrey.addActionListener(l -> viewControllerImpl.greyScale());
    menuItemMosaic.addActionListener(l -> {
      String input = this.getSeedsMosaic();
      if (input != null) {
        viewControllerImpl.mosaic(input);
      }
    });
    menuItemPixellation.addActionListener(l -> {
      String input = this.getSeedsPixellation();
      if (input != null) {
        viewControllerImpl.pixellation(input);
      }
    });
    menuItemPerformCross.addActionListener(l -> viewControllerImpl.crossStitch());
    menuItemDither.addActionListener(l -> viewControllerImpl.dither());
    menuItemWriteCross
        .addActionListener(l -> viewControllerImpl.writeDmcFile(this.getCrossStitchfileName()));
    menuItemWriteOwnDmcFile.addActionListener(
        l -> viewControllerImpl.writeOwnDmcCharactermatrix(this.getCrossStitchfileName()));
    batchScript.addActionListener(l -> {
      Readable commands = getBatchCommands();
      if (commands != null) {
        viewControllerImpl.executeBatchCommands(commands);
      }
    });
    menuItemAddText.addActionListener(l -> viewControllerImpl.addText(this.getAddText()));
    menuItemRemoveDmc.addActionListener(
        l -> viewControllerImpl.removeDmcColor(getRemoveColor(viewControllerImpl)));
    menuItemOwnDmcColors
        .addActionListener(l -> viewControllerImpl.newDmcIndex(getOwnDmcIndex(viewControllerImpl)));
    menuItemReplaceDmc.addActionListener(l -> viewControllerImpl.setUpReplaceColorcoordintes());
    menuItemDisplayImgCross.addActionListener(l -> viewControllerImpl.convertToDmcColors());
  }

  private Readable getBatchCommands() {
    String value = JOptionPane.showInputDialog(this, "Enter the commands");
    if (value == null) {
      return null;
    }
    return new StringReader(value);

  }

  @Override
  public void replaceDmcColor(Appendable output, ViewControllerInterface controller) {
    StringBuilder input = new StringBuilder();
    picture.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,
            "Mouse Clicked: (" + event.getX() + ", " + event.getY() + ")");

        input.append(event.getY());
        input.append(" ");
        input.append(event.getX());
        input.append(" ");
        controller.setUpReplaceColorcolor(input.toString());
      }
    });

  }

  private ScrollPane getSingleSelection(List<List<String>> choices) {
    buttonGroup = new ButtonGroup();
    cbarr = new JCheckBox[choices.size()];
    JPanel panel = new JPanel();
    List<JRadioButton> listRadioButton = new ArrayList<>();
    for (int i = 0; i < choices.size(); i++) {
      radioButton = new JRadioButton(choices.get(i).get(0));
      radioButton.setActionCommand(choices.get(i).get(0));
      radioButton.setBackground(new Color(Integer.valueOf(choices.get(i).get(1)),
          Integer.valueOf(choices.get(i).get(2)), Integer.valueOf(choices.get(i).get(3))));
      panel.add(radioButton);
      listRadioButton.add(radioButton);
      buttonGroup.add(radioButton);
    }
    ScrollPane pane = new ScrollPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    pane.add(panel);
    return pane;
  }

  @Override
  public void getReplaceColor(Appendable output, ViewControllerInterface controller,
      String coordinates) {
    StringBuilder input = new StringBuilder();
    input.append(coordinates);
    List<List<String>> choices = controller.completeDmcIndex();
    ScrollPane pane = getSingleSelection(choices);
    int inp = JOptionPane.showOptionDialog(null, pane, "Select replacing color",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

    if (inp == JOptionPane.OK_OPTION) {
      input.append(buttonGroup.getSelection().getActionCommand());
      controller.replaceDmcColor(input.toString());
    }
  }

  private String getAddText() {
    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);
    StringBuilder sb = new StringBuilder();
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Text:"));
    myPanel.add(xField);
    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
    myPanel.add(new JLabel("Enter the Dmc color for Font:"));
    myPanel.add(yField);

    int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter the text and color of text",
        JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
      sb.append(xField.getText());
      sb.append(" ");
      sb.append(yField.getText());
    }
    return sb.toString();
  }

  private String getRemoveColor(ViewControllerInterface controller) {
    List<List<String>> choices = controller.getDmcIndex();
    // Cannot have common implementation with replace color as the index format are
    // different.
    buttonGroup = new ButtonGroup();
    cbarr = new JCheckBox[choices.size()];
    JPanel panel = new JPanel();
    List<JRadioButton> listRadioButton = new ArrayList<>();
    for (int i = 0; i < choices.size(); i++) {
      radioButton = new JRadioButton(choices.get(i).get(2));
      radioButton.setBackground(new Color(Integer.valueOf(choices.get(i).get(3)),
          Integer.valueOf(choices.get(i).get(4)), Integer.valueOf(choices.get(i).get(5))));
      panel.add(radioButton);
      listRadioButton.add(radioButton);
      buttonGroup.add(radioButton);
    }
    ScrollPane pane = new ScrollPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    pane.add(panel);

    JOptionPane.showMessageDialog(this, pane, "Select the color to be removed", 2);
    String input = new String();
    for (int i = 0; i < listRadioButton.size(); i++) {
      if (listRadioButton.get(i).isSelected()) {
        input = listRadioButton.get(i).getText();
      }
    }
    return input;

  }

  private String getFile() {
    JFileChooser fc = new JFileChooser();
    int result = fc.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fc.getSelectedFile();
      return String.format(file.getAbsolutePath());
    }
    return String.format("Failed to READ");
  }

  private String saveFile() {
    JFrame parentFrame = new JFrame();

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file to save");

    int userSelection = fileChooser.showSaveDialog(parentFrame);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileChooser.getSelectedFile();
      return String.format(fileToSave.getAbsolutePath());
    }
    return String.format("Failed to WRITE ");
  }

  private String getSeedsMosaic() {
    String value = JOptionPane.showInputDialog(this, "Enter number of seeds for mosaic");
    return value;
  }

  private String getSeedsPixellation() {
    String value = JOptionPane.showInputDialog(this, "Enter blocks across for pixellation");
    return value;
  }

  private ScrollPane getMultipleSelect(List<List<String>> choices) {
    cbarr = new JCheckBox[choices.size()];

    for (int i = 0; i < choices.size(); i++) {
      JCheckBox cb = new JCheckBox(
          choices.get(i).get(0) + choices.get(i).get(1) + choices.get(i).get(2));
      cb.setBackground(new Color(Integer.valueOf(choices.get(i).get(3)),
          Integer.valueOf(choices.get(i).get(4)), Integer.valueOf(choices.get(i).get(5))));
      cbarr[i] = cb;

    }
    JPanel panel = new JPanel();
    JLabel dmcindex = new JLabel("dmc index");
    panel.add(dmcindex);
    for (JCheckBox cb : cbarr) {
      panel.add(cb);
    }
    ScrollPane pane = new ScrollPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    pane.add(panel);
    return pane;
  }

  private ScrollPane getMultipleSelect1(List<List<String>> choices) {
    cbarr = new JCheckBox[choices.size()];

    for (int i = 0; i < choices.size(); i++) {
      JCheckBox cb = new JCheckBox(choices.get(i).get(0));
      cb.setBackground(new Color(Integer.valueOf(choices.get(i).get(1)),
          Integer.valueOf(choices.get(i).get(2)), Integer.valueOf(choices.get(i).get(3))));
      cbarr[i] = cb;

    }
    JPanel panel = new JPanel();
    JLabel dmcindex = new JLabel("dmc index");
    panel.add(dmcindex);
    for (JCheckBox cb : cbarr) {
      panel.add(cb);
    }
    ScrollPane pane = new ScrollPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    pane.add(panel);
    return pane;
  }

  @Override
  public void crossStitch(Appendable output, List<List<String>> index) {
    List<List<String>> choices = index;

    right.removeAll();
    right.add(getMultipleSelect(choices));
    right.revalidate();
    right.repaint();

  }

  private String getCrossStitchfileName() {
    String value = JOptionPane.showInputDialog(this, "Enter filename for cross stitch");
    return String.format(value);
  }

  @Override
  public void setImg(Appendable output, BufferedImage image) {
    ImageIcon imageIcon = new ImageIcon(image);

    imagePanel.removeAll();
    picture = new ScrollablePicture(imageIcon, 10);
    pictureScrollPane = new JScrollPane(picture);
    pictureScrollPane.setPreferredSize(new Dimension(400, 300));
    pictureScrollPane.setViewportBorder(BorderFactory.createLineBorder(Color.black));

    JOptionPane.showMessageDialog(null, "Operation successfull");

    // Put it in this panel.
    imagePanel.add(pictureScrollPane);
    imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    imagePanel.revalidate();
    imagePanel.repaint();
  }

  private List<String> getOwnDmcIndex(ViewControllerInterface controller) {
    List<List<String>> choices = controller.completeDmcIndex();
    JOptionPane.showMessageDialog(null, getMultipleSelect1(choices), "Select available colors", 2);
    List<String> dmcSelected = new ArrayList<>();
    for (int i = 0; i < cbarr.length; i++) {
      if (cbarr[i].isSelected()) {
        dmcSelected.add(cbarr[i].getText());
      }
    }

    return dmcSelected;
  }
}
