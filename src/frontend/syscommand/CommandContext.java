package frontend.syscommand;



import frontend.display.DisplayCurrentWork;
import frontend.MenuItem;
import frontend.inoutdialog.DialogInSets;
import frontend.inoutdialog.StatusDialog;
import frontend.syscommand.ContextPlaceHolder;
import frontend.system.MainWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import java.util.*;
import javax.swing.border.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.*;

import office.OfficeSetUp;
import office.OfficeLoader;
import office.OfficeData;
import frontend.inoutdialog.SystemBrowser;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Component;
import jdesktop.app.ShortCut;
import jdesktop.indrive.SetInDrive;
import jdesktop.system.JExplorer;

/**
 * Cria um painel que contem em si os items do menu.
 Ao clicar neste componente o mesmo é redimencionado mostrando os items/**
 * Cria um painel que contem em si os items do menu.
 Ao clicar neste componente o mesmo é redimencionado mostrando os items
 do submenu (MenuItem)
 */


public  class CommandContext extends JPanel{

// start attributes

    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static int R;
    public static int G;
    public static int B;

   public static  CommandContext objScn;
    public static Color darkGradient;
    public static Color lightGradient;
    public static Color initColor;
    public static Color onClickColor;
    public static Color pressedColor;
    public static Color onOverColor;
    public static Color initLineColor;
    public static Color borderColor;
    public static String cmdText;
    public static String strName;
    public static String strChieldClass;
    public static String strClassName;
    public static String strText;
    public static String strChieldReference;
    public static String strChieldName;
    public static Border sectorBorder;
    public static Border contentLineBorder;
    public static Border coloredBorder;
    public static Border sectorTitledBorder;
     public static Border separatorBorder;
    public static JLabel lblCmdText;
    public static Point midleFont;
    public static Point midleButton;
    public static MainWindow formWindow;
    private static ContextPlaceHolder sideMenu;
    public static FontMetrics fontMetrics;
    public static Font fButtonText;
    public static Font fontMessageText;
    public static MenuItem itemNovo;
    public static Component sideMenuComp;
     public static Component btnMenuItem;
      public static Component itemScn;
      public static Component cTarget;
    public static int i,iter,c,x,defaultW,defaultH=60,expandedHeight=0,sizeWidth=0,actualW,actualH,varH=0;
    public static String btnText;
    public static String formato;
public static boolean ctxtStatus;
     public static  DisplayCurrentWork workMsg;
//    public static ArrayList<JLabel>menuItem= new ArrayList<JLabel>();
     public static ArrayList<String>categoryItem= new ArrayList<String>();
     public static ArrayList<Object>cmdObject=new ArrayList<Object>();
     private static ArrayList<Component>parentObjComp=new ArrayList<Component>();
     public static  Thread status,buildOffice;
    public static StatusDialog sttDialog;
    private final String strKeyExP="EXPANDED";
    private final String strKeyRet="RETRACTED";
    private final String strStatusKey="";
    private final int extStatus=1;
    private final int retStatus=2;
    private int wSize,hSize;
    private final String objClass="Command";
    private MouseEvent me; 
    private Component cmpTarget;
  // end attributes

  //Cocnstrutor
    public CommandContext(String varCategoryText,int varCordX,int varCordY,int varWidth,int varHeight){
        super();
       
        this.cmdText=varCategoryText;
        this.cordX=varCordX;
        this.cordY=varCordY;
        this.width=varWidth;
        this.height=varHeight;

        formWindow=new MainWindow();
        setPack(new ContextPlaceHolder());
        Settings();
        addMouseListener(new HandleCommand());
        OnContextAdapter();

        /*Atributos para identificar a classe (o nome desta classe) por acesso
        aos objectos componentes que em outras classes
        */

      SetComponentToStructure();
      // SetCommandToStructure();
    }
    
     private void SetComponentToStructure(){
         for(int i=0;i<getComponentCount();i++){
            Component c=getComponent(i);
            Command cmd;
             new startsystem.Structure().RecieveComponent(c);
          
        }
       
   }
   private void SetCommandToStructure(){
         for(int i=0;i<getComponentCount();i++){
             Command cmd;
            Component c=getComponent(i);
          
             
        }
       
   }
    
       public CommandContext(String varCategoryText,int varCordX,int varCordY){
        super();
       
        this.cmdText=varCategoryText;
        this.cordX=varCordX;
        this.cordY=varCordY;
       

        formWindow=new MainWindow();
        setPack(new ContextPlaceHolder());
        Settings();
        setSize(getParent().getWidth()-10,60);
        //setSize(wSize,hSize);
        addMouseListener(new HandleCommand());
        OnContextAdapter();

        /*Atributos para identificar a classe (o nome desta classe) por acesso
        aos objectos componentes que em outras classes
        */



    }
    public CommandContext(){
        super();
        formWindow=new MainWindow();
        setPack(new ContextPlaceHolder());
        Settings();
        addMouseListener(new HandleCommand());

       OnContextAdapter();
        /*Atributos para identificar a classe (o nome desta classe) por acesso
        aos objectos componentes que em outras classes
        */



    }

  // start methods

    /**
     * retorna o valor definido para o comprimento
     */
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


  public void setItemName(){
    setName(strName);
  }
  
  public String getSectorName(){
      return this.getName();
  }
  
  /**
   * Atribui o texto a ser mostrado no objecto criado por esta classe. Esse texto
   é o que identifica visualmente uma categoria definida par o menu
   */
  public String setText(String strText){
          cmdText=strText;

         return strText;
  }
  
   public int getTextWidth(){
    return lblCmdText.getSize().width;
  }
  
  public int getTextHeight(){
     return lblCmdText.getSize().height;
  }
  
  /**
   * Retorna o texto mostrado identificador da categoria do menu
   */
  public String getCmdText(){
    return cmdText;
  }
  
  
  /**
   * retorna o valor definido para a altura
   */
  public int Height(){
    return height;
  }

  /**
   * Define apenas o comprimento do bot�o sem necessidade de
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
   setSize(getHeight(),Height());
  }

  /**
   * Define as dimenções do componente. O incremento é feito pela soma das
   alturas recebidas pelo numero de items existentes dentro do componente
   */
  public void setResize(int sizeWidth,int sizeHeight){
     this.setSize(sizeWidth,sizeHeight);
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
   public void relocalInTarget(){

   }
   public Color getColor(Color color){
     return color;
   }

   /**
    * Define a fonte, as propriedades do texto e centra-o no espa�o do componente
    */
  public void CenterFont(){
       fontMetrics.stringWidth(getCmdText());//o comprimento do texto definido
       lblCmdText.setSize(fontMetrics.stringWidth(getCmdText()),fontMetrics.getHeight());// o tamanho da Label que contem o texto
      // lblCmdText.setLocation(Width()/2-getTextWidth()/2,Height()/2-getTextHeight()/2);//centra a label(com  o texto ) no espa�o do bot�o
       lblCmdText.setFont(fButtonText);//atribui a fonte ao texto do Label

   }

    
   /**"Futura MD BT", Font.BOLD,14
    * As propriedades gerais do componente:
    carrega os metodos para que o componente seja possivel no target de destino
    */
   public void Settings(){
        lblCmdText=new JLabel(cmdText);
        lblCmdText.setForeground(Color.WHITE); //cor do texto
        fButtonText=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
        fontMetrics=getFontMetrics(fButtonText);
        initColor=setColor(85,94,102);
        pressedColor=setColor(40,40,50);
        onOverColor=setColor(48,57,66);
        initLineColor=setColor(176,196,222);
        onClickColor=getParentColor();
       // borderColor=setColor(66, 76, 85);
        borderColor=setColor(200,200,10);
        setBackground(initColor);
       
        contentLineBorder=BorderFactory.createMatteBorder(1,1,1,1,borderColor);
        sectorBorder=BorderFactory.createTitledBorder(contentLineBorder,getCmdText().toUpperCase(),TitledBorder.LEADING,TitledBorder.TOP,fButtonText,Color.orange);
      //CenterFont();
        setBorder(sectorBorder);
       setResize(this.width,this.height);
 
        setLocalInTarget();
        add(lblCmdText);
        setOpaque(true);
        setLayout(null);
        setVisible(true);
        setInHostClass();
      
   }
   
   public void InstallComponent(Component c){
       add(c);
        new startsystem.Structure().RecieveComponent(c);
       UpdateSize(c);
       
   }
   
   private void UpdateSize(Component c){
       int updateHeight=c.getHeight();
       setSize(getWidth(),updateHeight);
   }
    public void OnContextAdapter(){
  
       addMouseListener(new MouseAdapter(){
          
           public void mouseEntered(MouseEvent me){
             UpdateStatus(cTarget,me);
           
               }
           public void mouseClicked(MouseEvent me){
            
               cTarget=(Component) me.getSource();
               if(getStatus(cTarget,me)==strKeyExP){
                 //JOptionPane.showMessageDialog(null,isExpanded(me),cTarget.getName(),1,null);
                 Retract(cTarget,me);
                 UpdateStatus(cTarget,me);
               }else  if(getStatus(cTarget,me)==strKeyRet){
                 //JOptionPane.showMessageDialog(null,isExpanded(me),cTarget.getName(),1,null);
                 Expand(cTarget,me);
                 UpdateStatus(cTarget,me);
               }
          
            }  
           
        });
     }
    
    private  String getStatus(Component varComp,MouseEvent me){
        defaultH=60;
        
       varComp=(Component) me.getSource();
        String strStatus="";
        if(varComp.getHeight()>defaultH){
            strStatus=strKeyExP;
        }
        if(!(varComp.getHeight()>defaultH)){
            strStatus=strKeyRet;
        }
        return strStatus;
    }
    
    private String UpdateStatus(Component cTarget, MouseEvent me){
       String strKey="";
        cTarget=(Component)me.getSource();
         if(getStatus(cTarget,me)==strKeyExP){
             strKey=strKeyExP;
            
         }else if(getStatus(cTarget,me)==strKeyRet){
               strKey=strKeyRet;
                
               }
         
        return strKey;
    }
    
    private int getStatus(){
        int statusKey=0;
        return statusKey;
    }
public boolean isExpanded(MouseEvent me){
    /**
     * Avalia se o componente foi espandido.
     * O valor boliniano retorna true se foi espandido 
     */
     boolean value=false;
       Component c;
       c=(Component)me.getSource();
       if(c.getHeight()>defaultH){
           value=true;
       } else if(!(c.getHeight()>defaultH)){
           value=value;
       }
     
    return value;
}



public boolean isRetracted(MouseEvent me){
  boolean value=false;
       Component c;
       c=(Component)me.getSource();
       if(c.getHeight()==defaultH){
           value=true;
       }else if(!(c.getHeight()==defaultH)){
           value=value;
       }
    return value;
}

 /*desenvolver método para obter automaticamente o intervalo entre botões
      desenvolver método para restringir os objectos aos quais deve ser adaptado 
      o size.:
      O retract será para envolver a area de ocupação dos botões.
      O expand serã para mostrar a ajuda do comand sector e deverá sim ocupar 
      a area de todos os componentes
      */
public void Expand(Component cmpTarget ,MouseEvent me){
      Component cObjCh;
     
      cmpTarget=(Component)me.getSource();
          for(x=0;x<getComponentCount();x++){
                    cObjCh=getComponent(x);
                    expandedHeight=getHeight()+cObjCh.getHeight()+5;
                }
      if(getStatus(cmpTarget,me)==strKeyRet){
            cmpTarget.setSize(cmpTarget.getWidth(),expandedHeight); 
      }

  }

private void getComponentInParent(){
    
}

   public  void Retract(Component cmpTarget,MouseEvent me){
        
         cmpTarget=(Component)me.getSource();
       
      if(getStatus(cmpTarget,me)==strKeyExP){
          cmpTarget.setSize(cmpTarget.getWidth(),60);
        }
         //updatestatus
    }
   
  

   public int DefaultHSize(){
      // Component c=getParent();
       int i;
        
          hSize= new startsystem.Structure().objRecorded;
          String strH=""+hSize;
          JOptionPane.showMessageDialog(null,strH,getClass().getCanonicalName(),1,null); 
       return hSize;
   }
   
   private int DefaultWSize(){
       
       wSize=getParent().getWidth()-10;
       String strW="o w predefinido :" + wSize ;
        JOptionPane.showMessageDialog(null,strW,getClass().getCanonicalName(),1,null); 
       return wSize;
   }
   private void DefaultSize(){
       String strSize="W:"+wSize+"\n"+"H:"+hSize;
        JOptionPane.showMessageDialog(null,strSize,getClass().getCanonicalName(),1,null); 
       setSize(wSize,hSize);
       
   }
   
   public Dimension DefaultDimension(){
       Dimension dim=null;
       dim.setSize(wSize, hSize);
       return dim;
   }
  public void setWorkMessage(){
      
      DisplayCurrentWork.setWorkText(getCmdText());
      DisplayCurrentWork.width=this.getTextWidth();
       DisplayCurrentWork.height=this.getTextHeight();
     CenterMessage();

  }

   public void CenterMessage(){

       fontMessageText=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
       fontMetrics=getFontMetrics(fontMessageText);
       fontMetrics.stringWidth(getCmdText());//o comprimento do texto definido
       DialogInSets.displayMsg.setSize(fontMetrics.stringWidth(getCmdText()),fontMetrics.getHeight());// o tamanho da Label que contem o texto
       workMsg.lblText.setLocation(DialogInSets.displayMsg.Width()/2-getMessageWidth()/2,DialogInSets.displayMsg.Height()/2-getMessageHeight()/2);//centra a label(com  o texto ) no espa�o do bot�o
       DialogInSets.displayMsg.setFont(fontMessageText);//atribui a fonte ao texto do Label

   }
   public int getMessageWidth(){
        return formWindow.appwindow.iwBody.displayMsg.Width();
   }
   public int getMessageHeight(){
     return formWindow.appwindow.iwBody.displayMsg.Height();
   }
  /**
   * acções inerentes a este componente: alteração do cursor no efeito roll-over ;
   alteração da cor de fundo, quando o mouse for pressionado, largado.
   */

  public Color setColor(int R,int G,int B){
    Color color=new Color(R,G,B);
    return color;
  }
  public Color getColor(){
    return this.getBackground();
  }
  public Color getParentColor(){
//    return formWindow.pnlActivity.getBackground();
      return new startsystem.LoadSettings().readTabBorderColor();
  }
  

  
  public int numItem(){
    int numItem=0;
    return numItem;
  }

   public String setMessage(String formato){

       return formato;
   }

   /**
    * Desloca o tabbed Pane
    Ainda em desenvolvimento
    */


  public void addMenuItem(){

  }
  
  /**
   * Retorna um objecto do Item Menu CommandContext
   */

   public CommandContext scnObject(){
      for(int i=0;i<sideMenu.menuItems.size();i++){
         itemScn=sideMenu.menuItems.get(i);

        if(itemScn.getClass().getCanonicalName().toString().equals(sideMenu.getObjectClass())){
          objScn=sideMenu.menuItems.get(i);
        }
       }
     return objScn;
   }
   
// Regista efeitos de roll-over, altera a cor quando � pressionado
// e retorna a cor quando sai do componente.


 private void setInHostClass(){
      sideMenu.menuItems.add(this);
 }

public void setPack(ContextPlaceHolder sideMenu) {
  CommandContext.sideMenu = sideMenu;
}

public static ContextPlaceHolder getSideMenu() {
  return sideMenu;
}
  // end methods
private class HandleCommand implements MouseListener{

      
        public  void mouseClicked(MouseEvent me) {
         
        }

     
        public void mousePressed(MouseEvent me) {
        
        }

      
        public void mouseReleased(MouseEvent me) {
          
        }

      
        public void mouseEntered(MouseEvent me) {
         
        }

    
        public void mouseExited(MouseEvent me) {
       
        }
    }
}
        
 //end clas
