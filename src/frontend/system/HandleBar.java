package frontend.system;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import startsystem.Load;
import java.io.File;

import java.io.IOException;
import java.io.FileInputStream;
import settings.SetFont;


public class HandleBar extends JPanel {
  /**
   * Esta classe implementa uma barra de titulos. Normalmente  trata-se de uma
   barra que carrega o logo da aplicação, os  botões de controlo e o nome da form.
   Esta classe implementa métodos para que a barra possa ser adaptada não só
   ao frame principal da aplicação, mas também aos frames secundarios
   que aquela possa exigir.
   */
  public static int posX;
  public static int posY;
  public static Point local;
  public static MouseEvent getLocal;
  public static MainWindow formWindow;
  public static String formName;
  public static String strBarName;
  public static JLabel lblName;
  public static int width;
  public static int height;
  public static Dimension screenSize;
  public static Point mouseLocal;
  public static JLabel inconLabel=new JLabel();
 public static ImageIcon imgIcon;

  public HandleBar() {
  }

  public HandleBar(String varFormName, MainWindow varFormWindow) {
    super();
    formWindow = varFormWindow;
    formName = varFormName;
    setProperties();
  
  }

  public HandleBar(String varFormName, String varBarName, int varWidth,
                     int varHeight) {
    super();
    this.formName = varFormName;
    this.strBarName = varBarName;
    this.width = varWidth;
    this.height = varHeight;
   
  }
  
  public HandleBar(String varFormName, JLabel varLblIcon, String varBarName, int varWidth,
                     int varHeight) {
    super();
    this.formName = varFormName;
    this.strBarName = varBarName;
    this.width = varWidth;
    this.height = varHeight;
     inconLabel= varLblIcon;
  }
 public HandleBar(String varFormName, ImageIcon varImgIcon, String varBarName, int varWidth,
                     int varHeight) {
    super();
    this.formName = varFormName;
    this.strBarName = varBarName;
    this.width = varWidth;
    this.height = varHeight;
    imgIcon=varImgIcon;
  }
  public HandleBar(String varBarName) {
    super();
    strBarName = varBarName;
    setProperties();
  }
  public HandleBar(String varBarName, ImageIcon varImgIcon) {
    super();
    strBarName = varBarName;
     imgIcon=varImgIcon;
    setProperties();
  }
    public HandleBar(String varBarName, JLabel varLblIcon) {
    super();
    strBarName = varBarName;
    inconLabel= varLblIcon;
    setProperties();
  }
    public void setIconImg(){
     
    }
  public String setFormName() {
    formWindow.setNameApp();

    return formName;
  }

  public String getFormName() {
    return formWindow.getName();
  }

  public int setDefinedWidth() {
    return this.width = formWindow.getDefinedWidth();
  }

  public int getDefinedWidth() {
    return this.getWidth();
  }

  public int setDefinedHeight() {
    this.height = 50;

    return this.height();
  }

  public int getDefinedHeight() {
    return this.getHeight();
  }

  public int width() {
    return width;
  }

  public int height() {
    return height;
  }

  public void setBarName(String varStrBarName) {
    strBarName = varStrBarName;
    this.setName(strBarName);
  }

  public String getBarName() {
    return this.getName();
  }

  public void setProperties() {
    setFormName();
    setBarName("logoBar");
    this.setLayout(null);
    this.setVisible(true);
    this.setOpaque(true);
    this.setFormDraggable();
    this.setFormControls();
    this.setBackground(Color.DARK_GRAY);
    this.width = this.getDefinedWidth();
    this.height = this.getDefinedHeight();
    
  }

  public void setFormDraggable() {
    this.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
          getLocal = me;
          mouseLocal = me.getPoint();
        }
      });
    this.addMouseMotionListener(new MouseAdapter() {
        public void mouseDragged(MouseEvent me) {
          screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          local = formWindow.getLocation(local);

          int x = local.x - getLocal.getX() + me.getX();
          int y = local.y - getLocal.getY() + me.getY();

          if (mouseLocal.y >= 5) {
            if ((formWindow.getWidth() != screenSize.width) ||
                  (formWindow.getHeight() != (screenSize.height - 30))) {
              formWindow.setLocation(x, y);
              formWindow.formOldLocal.x = x;
              formWindow.formOldLocal.y = y;
            }
          }
        }
      });
  }

  public void setFormControls() {
    this.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent me) {
          /* Para  mudar o aspecto do cursor quando o mouse entrar no espaço
           deste componente, é necessario que o frame target não tenha o glassPane
           sobreposto a este componente.
           */


          if (MainWindow.closeButton.getBackground() == MainWindow.closeButton.onOverCloseColor) {
            MainWindow.closeButton.setBackground(MainWindow.closeButton.initCloseColor);
          } else if (MainWindow.maximizeButton.getBackground() == MainWindow.maximizeButton.onOverColor) {
            MainWindow.maximizeButton.setBackground(MainWindow.maximizeButton.initColor);
          } else if (MainWindow.minimizeButton.getBackground() == MainWindow.minimizeButton.onOverColor) {
            MainWindow.minimizeButton.setBackground(MainWindow.minimizeButton.initColor);
          }
  
        }
      });
  }
  

  
  public void paint(Graphics g) {

   
    Graphics2D g2 = (Graphics2D) g;

    //1ªparte da pintura da barra
    GradientPaint G = new GradientPaint(0, this.getHeight() / 2,
                                        new Color(85, 94, 102), 0, 0,
                                        new Color(125, 132, 139));
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(G);
    g2.fillRect(0, 0, formWindow.getWidth(), this.getHeight() / 2);

    //2ªparte da pintura da barra
    GradientPaint G2 = new GradientPaint(0, this.getHeight(),
                                         new Color(48, 57, 66), 0,
                                         this.getHeight() / 2,
                                         new Color(66, 76, 85));
    g2.setPaint(G2);
    g2.fillRect(0, this.getDefinedHeight() / 2, formWindow.getDefinedWidth(),
                this.getDefinedHeight() / 2);
    //Escreve o titulo do  form
    g2.setColor(new Color(200,200,200));

   //Font fTitle = new Font("Futura MD Bt", Font.PLAIN, 26);
    //g2.setFont(fTitle);
    g2.setFont(SetFont.EmbFont());
    g2.drawString(formName, 100, 35);
  }
  
   

}


