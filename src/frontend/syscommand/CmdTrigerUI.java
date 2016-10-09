/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.syscommand;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
//import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class CmdTrigerUI extends BasicButtonUI implements java.io.Serializable,
    MouseListener, KeyListener {
    

  private final static CmdTrigerUI m_buttonUI = new CmdTrigerUI();
  
   //atribuir propriedades
 private  Color borderColor=new Color(66, 76, 85);
 protected Color font_color=(Color)UIManager.put("Button.foreground",new Color(255,255,255));
 protected Font font=(Font)UIManager.put("Button.font",new Font("Futura MD BT", Font.BOLD,12));
  protected Color standardColor=(Color) UIManager.put("Button.background",new startsystem.LoadSettings().readCmdStartColor());
  //return new startsystem.LoadSettings().readCmdStartColor();
  protected Color pressedColor=(Color) UIManager.put("Button.pressedBackground",Color.blue); 
  protected Color enteredColor=(Color) UIManager.put("Button.enteredBackground",Color.green); 
  
  private Border cmdBorder=BorderFactory.createMatteBorder(1,1,1,1,borderColor);
 
  
  //carregar propriedades
  protected Font defaultFont=UIManager.getFont("Button.font");
  protected Border m_borderRaised = UIManager.getBorder("Button.border");

  protected Border m_borderLowered = UIManager.getBorder("Button.borderPressed");

  protected Color m_backgroundNormal = UIManager.getColor("Button.background");

 protected Color m_backgroundPressed = UIManager.getColor("Button.pressedBackground");
    // .getColor("Button.pressedBackground");
protected Color m_backgroundEntered= UIManager.getColor("Button.enteredBackground");// criação minha
  protected Color m_foregroundNormal = UIManager.getColor("Button.foreground");

  protected Color m_foregroundActive = UIManager.getColor("Button.activeForeground");

 // protected Color m_focusBorder = UIManager.getColor("Button.focusBorder");
  
  /*
  cmdBorder=BorderFactory.createMatteBorder(1,1,1,1,borderColor);
 borderColor=setColor(66, 76, 85);
  */
 

  public static ComponentUI createUI(JComponent c) {
    return m_buttonUI;
  }

  public void installUI(JComponent c) {
    super.installUI(c);
    c.addMouseListener(this);
    c.addKeyListener(this);
  }

  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
    c.removeMouseListener(this);
    c.removeKeyListener(this);
  }

  public void paint(Graphics g, JComponent c) {
         Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    AbstractButton b = (AbstractButton) c;
    //Dimension d = b.getSize();
    //b.setSize(100,30);
    g2.setFont(c.getFont());
    FontMetrics fm = g2.getFontMetrics();

    g2.setColor(b.getForeground());
    String caption = b.getText().toUpperCase();
    int x = (b.getWidth() - fm.stringWidth(caption)) / 2;
    int y = (b.getHeight() + fm.getAscent()) / 2;
    g2.drawString(caption, x, y);

  }


  public void mouseClicked(MouseEvent e) {
     
  }

  public void mousePressed(MouseEvent e) {
    JComponent c = (JComponent) e.getComponent();

    c.setBackground(m_backgroundPressed);
  
  }

  public void mouseReleased(MouseEvent e) {
    JComponent c = (JComponent) e.getComponent();
//    c.setBorder(m_borderRaised);
 //   c.setBorder(cmdBorder);
    c.setBackground(m_backgroundNormal);
  }

  public void mouseEntered(MouseEvent e) {
    JComponent c = (JComponent) e.getComponent();
    c.setForeground(m_foregroundActive);
    c.setBackground(m_backgroundEntered);
    c.setBorder(cmdBorder);
    c.repaint();
  }

  public void mouseExited(MouseEvent e) {
    JComponent c = (JComponent) e.getComponent();
    c.setForeground(m_foregroundNormal);
     c.setBackground(m_backgroundNormal);
    c.repaint();
  }

  public void keyTyped(KeyEvent e) {
       
  }

  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
      JComponent c = (JComponent) e.getComponent();
    //  c.setBorder(m_borderLowered);
    //  c.setBorder(cmdBorder);
    
      c.setBackground(m_backgroundPressed);
    
    
    }
  }

  public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
      JComponent c = (JComponent) e.getComponent();
     // c.setBorder(m_borderRaised);
    //  c.setBorder(cmdBorder);
      c.setBackground(m_backgroundNormal);
    }
  }

}
