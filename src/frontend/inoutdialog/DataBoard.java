package frontend.inoutdialog;


import frontend.display.DisplayCurrentWork;
import frontend.system.MainWindow;
import frontend.inoutdialog.DialogInSets;
import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;
import javax.swing.border.*;


public class DataBoard extends JPanel {
  public static Border dataBorder;
  public static Border limitBoardNoTitle;
  public static Border limitBoardTitle;
  public static int txtBorderPos;
  public static int txtBorderJust;
  public static Font txtBorderFont;
   public static FontMetrics fontMetrics;
  public static Color txtBorderColor;
  public static int cordX;
  public static int cordY;
  public static int width;
  public static int height;
  public static JScrollPane scroll;
  public static JPanel pnlComponents;
  public static JTextField tfArtigo;
  public static JTextArea taDesc;
  
  public static Point p;
  public static int pX;
  public static int pY;
  public static JLabel lblMarcaArtigo;
   public static Font fontTextWork;
     public static FontMetrics fontMetricsArtigo;
   public static String nomeArtigo;
   public static JScrollPane barra;
   public static String strTxt;
  public DataBoard(int varCordX, int varCordY, int varWidth, int varHeight) {
    super();
    this.cordX = varCordX;
    this.cordY = varCordY;
    this.width = varWidth;
    this.height = varHeight;
    setProperties();
  }


  public void setProperties() {

    fontTextWork=new Font("Futura MD BT", Font.PLAIN,14);

    this.setVisible(true);
    this.setSize(this.width, this.height);
    this.setBounds(this.cordX, this.cordY, this.width, this.height);
    this.setLocation(this.cordX, this.cordY);
    this.setLayout(null);

    pX = this.getLocation().x;
    pY = this.getLocation().y;

    pnlComponents = new JPanel();
    pnlComponents.setSize(this.getSize().width -10, this.getSize().height -35);
    //pnlComponents.setLocation((this.pX+this.width/2)-pnlComponents.getSize().width/2,(this.pY+this.height/2)-pnlComponents.getSize().height/2);
    pnlComponents.setLocation((1 + (this.width / 2)) -
                              (pnlComponents.getSize().width / 2),
                              ( 10+(this.height / 2)) -
                              (pnlComponents.getSize().height / 2));
    pnlComponents.setLayout(null);
    pnlComponents.setVisible(true);
    pnlComponents.setBackground(new Color(225,225,225));
    pnlComponents.setOpaque(true);

    this.add(pnlComponents);
    txtBorderColor = new Color(200, 200, 200);
    setGraphics();
    OnMouseOver();
    //campos de texto

    tfArtigo=new JTextField();
    tfArtigo.setVisible(true);
    tfArtigo.setSize(150,17);
    tfArtigo.setLocation(pnlComponents.getLocation().x+100,pnlComponents.getLocation().y+5);
    taDesc=new JTextArea();

    taDesc.setSize(150,30);
    taDesc.setRows(2);
    taDesc.setLineWrap(true);
    taDesc.setLocation(pnlComponents.getLocation().x+100,tfArtigo.getLocation().y+tfArtigo.getHeight()+5);
    taDesc.setVisible(true);
    barra=new JScrollPane(taDesc);


    //barra.setWheelScrollingEnabled(true);
    //barra.setBounds(taDesc.getLocation().x+taDesc.getWidth(),taDesc.getLocation().y,15,taDesc.getHeight());
    barra.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );

    //labels


    lblMarcaArtigo =new JLabel("Descritivo");
    lblMarcaArtigo.setOpaque(false);
       fontMetricsArtigo=getFontMetrics(fontTextWork);
       fontMetricsArtigo.stringWidth(lblMarcaArtigo.getText());
       lblMarcaArtigo.setSize(fontMetricsArtigo.stringWidth(lblMarcaArtigo.getText()),fontMetricsArtigo.getHeight());
       lblMarcaArtigo.setLocation(tfArtigo.getLocation().x-5-lblMarcaArtigo.getWidth(),tfArtigo.getLocation().y+tfArtigo.getHeight()/2-lblMarcaArtigo.getHeight()/2);
       lblMarcaArtigo.setFont(fontTextWork);
       lblMarcaArtigo.setVisible(true);
       //adicionar componentes
    this.pnlComponents.add(tfArtigo);
    this.pnlComponents.add(taDesc);
    this.pnlComponents.add(barra);
    this.pnlComponents.add(lblMarcaArtigo);
    this.setLayout(null);
  }
   public int getCordX(){
     return this.pX;
   }
   
   public int getCordY(){
     return this.pY;
   }
  public void setGraphics() {
      
     strTxt="trabalho em curso ";

   // limitBoardNoTitle = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
      limitBoardNoTitle= BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY), strTxt.toUpperCase(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,fontTextWork,new Color(85,94,102));
    //limitBoardTitle=BorderFactory.createTitledBorder(limitBoardNoTitle);
    //dataBorder=BorderFactory.createTitledBorder(limitBoardTitle,dados.getText(),TitledBorder.LEADING,TitledBorder.TOP,txtBorderFont,txtBorderColor);
    //txtBorderFont = new Font("Futura MD BT", Font.BOLD, 12);
    //fontMetrics=getFontMetrics(txtBorderFont);
    //dados.setSize(fontMetrics.stringWidth(txtDados),fontMetrics.getHeight());
    //dados.setHorizontalTextPosition(SwingConstants.CENTER);
    //dados.setVerticalTextPosition(SwingConstants.CENTER);
      //dados.setForeground(Color.BLACK);
    //fontMetrics.stringWidth(dados.getText());

    //dados.setFont( txtBorderFont);
    setBorder(limitBoardNoTitle);
    //setBorder(dataBorder);
  }

  public   void setScrollable() {
    scroll = new JScrollPane(this);
    scroll.setSize(this.pnlComponents.getSize().width, 20);
    scroll.setLocation(10, this.height - 50);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scroll.getHorizontalScrollBar().setUnitIncrement(10);
    scroll.setVisible(true);
    this.add(scroll, null);
  }

  public void OnMouseOver() {
    this.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent me) {
  // limitBoardNoTitle = BorderFactory.createLineBorder(Color.ORANGE);
  limitBoardNoTitle= BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.ORANGE), strTxt.toUpperCase(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,fontTextWork,new Color(85,94,102));
          if (me.getSource().equals(DialogInSets.pnlData)) {

             setCursor(new Cursor(Cursor.HAND_CURSOR));
          
              setBorder(limitBoardNoTitle);
          }
          
        }
       
        public void mouseExited (MouseEvent me){
            //limitBoardNoTitle = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
         limitBoardNoTitle= BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY), strTxt.toUpperCase(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,fontTextWork,new Color(85,94,102));
              setBorder(limitBoardNoTitle);
        }
        public void mouseClicked(MouseEvent me){
            if(me.getSource()==MainWindow.pnlData){

              System.out.println(DisplayCurrentWork.lblText.getSize().width);
            }
        } 
      });
  }

  public void InsertComponents() {
  }

  /**
   * Relaciona a localisação deste componente com o componente que o recebe.
   O ponto P do anfitrião, � o ponto do canto superior
   esquerdo e tem valores x,y em 0(Zero). Indicando o componenmte anfitrião
   como parametro consegue-se obter dados desse componente, com as suas
   coordenadas, dimenões etc.
   */
  public void setLocationInTarget(Component target) {
  }

  /**
   * Obt�m as coordenadas x,y do ponto P, no canto sperior esquerdo,
   no espaço ou area do componente anfitrião
   */
  public void getLocationInTarget(Component target) {
  }

  /**
   * Faz coincidir o centro deste componente com o centro do anfitrião
   */
  public void centerInTarget(Component target) {
  }
}
