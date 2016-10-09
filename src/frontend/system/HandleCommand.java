package frontend.system;


import frontend.system.FrontendMainWindowHandleBar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.border.*;

public  class HandleCommand extends JPanel{
  // start attributes
    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static MainWindow targetForm;
    public static int R;
    public static int G;
    public static int B;
    public static Color initColor;
    public static Color onOverColor;
    public static Color pressedColor;
    public static Color initCloseColor; //Cor normal do botão Close
    public static Color pressedCloseColor;//Cor quando o rato for Pressionado no botão Close
    public static Color onOverCloseColor; //Cor quando o rato entrar no botão Close
    public static Color onOverLineColor;
    public static Color initLineColor;
    public static Color borderColor;
    public static String buttonText;
    public static Border buttonBorder;
    public static Border buttonLineBorder;
    public static JLabel lblButtonText;
    public static String strText;
    public Point midleFont;
    public Point midleButton;
    public static MainWindow formWindow;
    public static FrontendMainWindowHandleBar logoBar;
    public static String buttonName;
    public static FontMetrics fontMetrics;
    public Font fButtonText;
    private String strClose;
    private String strMaximize;
    private String strMinimize;
    private String closeButton;
    private String maxButton;
    private String minButton;

    
  // end attributes

  //Cocnstrutor
    public HandleCommand(String varButtonText,int varCordX,int varCordY,int varWidth,int varHeight){
        super();
        this.buttonText=varButtonText;
        this.cordX=varCordX;
        this.cordY=varCordY;
        this.width=varWidth;
        this.height=varHeight;
        this.strClose="X";
        this.strMaximize="+";
        this.strMinimize="-";
        this.closeButton="btnClose";
        this.maxButton="btnMaximize";
        this.minButton="btnMinimize";
        setProperties();
        setFormControl();
    }
    
  public HandleCommand(){

  }
    /**
     * retorna o valor definido para o comprimento
     */
   public int R(){
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
  
  public void setButtonName(){
     if(getButtonText().equals("X")){
          this.setName(closeButton);
     }
     else if(getButtonText().equals("+")){
          this.setName(maxButton);
     }
     else if(getButtonText().equals("-")){
           this.setName(minButton);
     }

  }
  public String getButtonName(){
      return this.getName();
  }
  public void setButtonText(String newButtonText){
       if(buttonText.equals(strClose)){
             lblButtonText.setText(strClose);
       }
       else if(buttonText.equals(strMaximize)){
             lblButtonText.setText(strMaximize);
       }
       else if(buttonText.equals(strMinimize)){
             lblButtonText.setText(strMinimize);
       }
  }
  public String getButtonText(){
    return lblButtonText.getText().toString();
  }
  /**
   * retorna o valor definido para a altura
   */

  public int Height(){
    return height;
  }
  
  /**
   * Define apenas o comprimento do botão sem necessidade de
   alterar a sua altura. Util para o redimencionamento do componente
   onde o botão seja incerido
   */

  public void setWidth(int width) {
    this.setSize(this.Width(),this.getHeight());
  }
  /**
   * Define apenas a altura do botão sem necessidade de
   alterar o seu comprimento. Util para o redimencionamento do componente
   onde o botão seja incerido
   */

  public void setHeight(int height){
   this.setSize(this.getHeight(),this.Height());
  }
  
  /**
   * define as dimenções do botao. Este método esta implicito no construtor,
   no entanto vem tornar possivel, a qualquer momento alterar as dimenções
   do objecto
   */
  public void setResize(int sizeWidth,int sizeHeight){
     this.setSize(sizeWidth,sizeHeight);
  }
  public int getTextWidth(){
    return lblButtonText.getSize().width;
  }
  public int getTextHeidht(){
     return lblButtonText.getSize().height;
  }

  /**
   * retorna a cordenada x, no componente onde o botão se vai posicionar
   */
   public int CordX(){
     return cordX;
   }
   
   /**
    * retorna a cordenada y , no componente, onde o botão se vai posicionar
    */
   public int CordY(){
     return cordY;
   }
   
   /**
    * posiciona o botão nas cordenadas x_y do target
    */
   public void setLocalInTarget(){
     this.setLocation(this.CordX(),this.CordY());
   }

   public Color getColor(Color color){
     return color;
   }
   
   /**
    * Define a fonte as propriedades do texto e centra-o no espaço do botão
    */
  public void CenterFont(){
       lblButtonText=new JLabel();
       lblButtonText.setText(buttonText);// o testo a aparecer no botão
       lblButtonText.setForeground(Color.WHITE); //cor do texto
       fButtonText=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
       fontMetrics=getFontMetrics(fButtonText);
       fontMetrics.stringWidth(getButtonText());//o comprimento do texto definido
       lblButtonText.setSize(fontMetrics.stringWidth(getButtonText()),fontMetrics.getHeight());// o tamanho da Label que contem o texto
       lblButtonText.setLocation(Width()/2-getTextWidth()/2,Height()/2-getTextHeidht()/2);//centra a label(com  o texto ) no espaço do botço
       lblButtonText.setFont(fButtonText);//atribui a fonte ao texto do Label
   }
   /**
    * As propriedades gerais do botão:
    carrega os metodos para que o botão seja possivel no target de destino
    */
   public void setProperties(){
        initColor=setColor(79,94,105);
        pressedColor=setColor(22,45,80);
        onOverColor=setColor(141,152,161);
        initCloseColor=setColor(205,0,0);
        pressedCloseColor=setColor(139,0,0);
        onOverCloseColor=setColor(255,69,0);
        initLineColor=setColor(165,165,196);
        onOverLineColor=setColor(255,193,37);
         borderColor=setColor(66, 76, 85);
        this.setBackground(initColor);
        buttonLineBorder=BorderFactory.createMatteBorder(1,1,1,1,borderColor);;
        buttonBorder=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.CenterFont();
        this.setBorder(buttonBorder);
        this.setBorder(buttonLineBorder);
        this.setResize(this.width,this.height);
        this.setLocalInTarget();
        this.add(lblButtonText);
        this.setButtonName();
        this.setOpaque(true);
        this.setLayout(null);
        this.setVisible(true);
   }
   
  // start methods
  
  /**
   * acções inerentes a este botão: alteração do cursor no efeito roll-over ;
   alteração da cor do botão, quando o mouse for pressionado, largado.
   é aqui que fica definido o encerramento da aplicação, quando é feito click
   sobre este objecto, bem como os efeitos graficos de alteração da cor do
   componente, quando o mouse aje sobre o mesmo. O retorno da cor quando o
   mouse sai do componente é feito no evento "mouseExcited" do componente
   onde o mouse entra.Ai a cor desse componente pode ser alterada em "mouseEntered"
   enquanto é feito retorno da cor do componente de onde o mouse saiu.
   */
   
 //Fechar o form (Encerra a aplicação)
  public void setFormControl(){
   setMouseGraphicsEffects();
      this.addMouseListener(
           new MouseAdapter(){
               public void mouseClicked(MouseEvent me){

               }
           });
      this.addMouseMotionListener(
            new MouseAdapter(){
              public void mouseDragged(MouseEvent me){

              }
            });
  }
  public Color setColor(int R,int G,int B){
    Color color=new Color(R,G,B);
    return color;
  }
  public Color getColor(){
    return this.getBackground();
  }
  public void setFormMinimized(){

  }

  public void setFormMaximized(){

  }

// Regista efeitos de roll-over, altera a cor quando é pressionado
// e retorna a cor quando sai do componente.
  public void setMouseGraphicsEffects(){
     if (getButtonText().equals("X")){
         this.setBackground(initCloseColor);
     }
      this.addMouseListener(
           new MouseAdapter(){
               public void mousePressed(MouseEvent me){
                    if(me.getSource().equals(targetForm.closeButton)){
                           ((JPanel)(me.getSource())).setBackground(pressedCloseColor);
                    }
                    else if(me.getSource().equals(targetForm.minimizeButton)){
                           ((JPanel)(me.getSource())).setBackground(pressedColor);
                    }
                    else if(me.getSource().equals(targetForm.maximizeButton)){
                           ((JPanel)(me.getSource())).setBackground(pressedColor);
                    }
               }
               public void mouseReleased(MouseEvent me){
                    if(getButtonName().equals("btnClose")){
                       ((JPanel)(me.getSource())).setBackground(initCloseColor);
                    }
                    else if(getButtonName().equals("btnMaximize")){
                            ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                    else if(getButtonName().equals("btnMinimize")){
                           ((JPanel)(me.getSource())).setBackground(initColor);
                    }

               }
               public void mouseEntered(MouseEvent me){

                 if(me.getSource().equals(targetForm.closeButton)){
                     setToolTipText("Fechar");
                     setBackground(onOverCloseColor);
                     ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
                     targetForm.minimizeButton.setBackground(initColor);
                     targetForm.maximizeButton.setBackground(initColor);
                  }
                  else if(me.getSource().equals(targetForm.maximizeButton)){
                          setBackground(onOverColor);
                          ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
                          targetForm.minimizeButton.setBackground(initColor);
                          targetForm.closeButton.setBackground(initCloseColor);
                  }
                  else if(me.getSource().equals(targetForm.minimizeButton)){
                           setBackground(onOverColor);
                           ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
                           targetForm.maximizeButton.setBackground(initColor);
                           targetForm.closeButton.setBackground(initCloseColor);
                  }

               }
           });
  }

  // end methods

} //end class