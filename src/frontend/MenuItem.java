package frontend;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * Esta classe implementa Texto com propriedades de linkButton usados na web:
 Trata-se de texto que detecta eventos do mouse e retorna acções em conformidade

 Será usado essencialmente nos items de submenus, existentes dentro dos ButtonMenuItem

 Só serão visiveis no caso de serem activados os ButtonMenuItem

 */
public class MenuItem extends JLabel {
  public static String strLabel;
  public static FontMetrics fontMetrics;
  public Point midleFont;
  public Font fontText;

  public MenuItem(String varTextoLabel) {
    super(varTextoLabel);
    this.strLabel = varTextoLabel;

    this.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evento) {
        }

        public void mouseEntered(MouseEvent me) {
          ((JLabel) (me.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
      });
  }

  public String getStringLabel() {
    this.getText();

    return strLabel;
  }

  public void setProperties() {
    this.setVisible(true);
  }
}
