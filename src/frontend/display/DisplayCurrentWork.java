package frontend.display;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.util.*;
import javax.swing.border.*;



public  class DisplayCurrentWork extends JPanel{
  /**
   *
   */


/**
   *
   */

// start attributes

    public static int width;//comprimento
    public static int height; //altura
    public static int cordX; //cordenada x no target
    public static int cordY; //cordenada y no target
    public static int R;   //parametro de cor
    public static int G;    //parametro de cor
    public static int B;   //parametro de cor

    public static Color darkGradient;
    public static Color lightGradient;
    public static Color initColor;
    public static Color onClickColor;
    public static Color pressedColor;
    public static Color onOverColor;
    public static Color initLineColor;

    public static String strWorkText; //a menssagem a mostrar
    public static Point midleFont;
    public static Point midleButton;
    public static FontMetrics fontMetrics;
    public static Font fontText;
    public static String strMsg;
    public static JLabel lblText;
    public static int txtWidth;
    public static int txtHeigth;


  // end attributes

  //Cocnstrutor
    public DisplayCurrentWork(String varCurrentWorkText,int varCordX,int varCordY,int varWidth,int varHeight){
        super();

        this.strWorkText=varCurrentWorkText;
        this.cordX=varCordX;
        this.cordY=varCordY;
        this.width=varWidth;
        this.height=varHeight;
        setProperties();
    }
    public DisplayCurrentWork( String varCurrentWorkText,int varCordX,int varCordY){
           super();

        this.strWorkText=varCurrentWorkText;
        this.cordX=varCordX;
        this.cordY=varCordY;

        setProperties();
    }

       public DisplayCurrentWork( String varCurrentWorkText){
           super();

        this.strWorkText=varCurrentWorkText;


        setProperties();
    }
    
    public DisplayCurrentWork(){
        super();
        setProperties();

    }

  // start methods
    public void setLocalInTarget(int cordX, int cordY){
      this.setLocation(cordX,cordY);
    }
   public int R(){
   for(int r=0;r<=255;r++){
     R=r;
   }
     return R;
   }
   public int G(){
     return G;
   }
   public int B(){
     return B;
   }
  public int Width(){
    return width;
  }

  public int getCordY(){
    return this.cordY;
  }
  public int getCordX(){
    return this.cordX;
  }

  public String getWorkText(){
      return this.lblText.getText();
  }


  public static void setWorkText(String strText){
          lblText.setText(strText);
  }

  public  void setSizeAsText(){
      this.setWidth(lblText.getSize().width);
      this.setHeight(lblText.getSize().height);
  }



  /**
   * retorna o valor definido para a altura
   */
  public  int Height(){
    return height;
  }

  /**
   * Define apenas o comprimento do botão sem necessidade de
   alterar a sua altura. Util para o redimencionamento do componente
   onde o botão seja incerido
   */
  public  void setWidth(int width) {
    this.setSize(this.Width(),this.getHeight());
  }



  public  void setHeight(int height){
   this.setSize(this.getHeight(),this.Height());
  }

  public int setWidthForText(){
           txtWidth=getTextWidth() ;
  this.setWidth(txtWidth);
     return txtWidth;
  }

  public int setHeightForText(){
          txtHeigth = getTextHeight() ;
       this.setHeight(txtHeigth);
       return txtHeigth;
  }

  public void setSizeAsText(int sizeWidth,int sizeHeight){
     this.setSize(sizeWidth,sizeHeight);
  }

  public int getTextWidth(){
    return lblText.getSize().width;
  }

  public int getTextHeight(){
     return lblText.getSize().height;
  }

  /**
   * retorna a cordenada x, no componente onde o objecto se vai posicionar
   */
   public int CordX(){
     return cordX;
   }

   /**
    * retorna a cordenada y , no componente, onde o objecto se vai posicionar
    */
   public int CordY(){
     return cordY;
   }

   /**
    * posiciona o objecto nas cordenadas x_y do target
    */
   public void setLocalInTarget(){
     this.setLocation(this.CordX(),this.CordY());
   }

   public Color getColor(Color color){
     return color;
   }

   /**
    * Define a fonte, as propriedades do texto e centra-o no espaço do componente
    */
  public void CenterFont(){
        //cor do texto
       fontText=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
       fontMetrics=getFontMetrics(fontText);
       fontMetrics.stringWidth(getWorkText());//o comprimento do texto definido
       lblText.setSize(fontMetrics.stringWidth(getWorkText()),fontMetrics.getHeight());// o tamanho da Label que contem o texto
       lblText.setHorizontalTextPosition(SwingConstants.CENTER);
       lblText.setVerticalTextPosition(SwingConstants.CENTER);
       lblText.setOpaque(false);
       lblText.setFont(fontText);//atribui a fonte ao texto do Label
       lblText.setLocation(this.getLocation().x ,this.getLocation().y);
   }

   /**
    * As propriedades gerais do componente:
    carrega os metodos para que o componente seja possivel no target de destino
    */
   public void setProperties(){
        this.setLayout(null);
        initColor=setColor(85,94,102);
        pressedColor=setColor(40,40,50);
        onOverColor=setColor(48,57,66);
        initLineColor=setColor(176,196,222);
         lblText=new JLabel(strWorkText);

        //this.setBackground(new Color(125, 132, 139));


        this.CenterFont();
        setWorkText(lblText.getText());

        this.setSizeAsText(this.width,this.height);
        this.setLocalInTarget();
        this.add(lblText);
        this.setOpaque(true);
        this.setLayout(null);
        this.setVisible(true);


   }
   
  public Color setColor(int R,int G,int B){
    Color color=new Color(R,G,B);
    return color;
  }
  public Color getColor(){
    return this.getBackground();
  }




  public int numItem(){
    int numItem=0;
    return numItem;
  }










  // end methods
} //end clas