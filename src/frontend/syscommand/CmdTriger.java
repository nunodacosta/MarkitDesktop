package frontend.syscommand;



import frontend.display.DisplayCurrentWork;
import frontend.MenuItem;
import frontend.inoutdialog.DialogInSets;
import frontend.inoutdialog.StatusDialog;
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


public  class CmdTriger extends JPanel{

// start attributes

    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static int R;
    public static int G;
    public static int B;

   public static  CmdTriger objScn;
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
    public static Border cmdBorder;
    public static Border buttonLineBorder;
     public static Border separatorBorder;
    public static JLabel lblCmdText;
    public static Point midleFont;
    public static Point midleButton;
    public static MainWindow formWindow;
    private static CmdSet sideMenu;
    public static FontMetrics fontMetrics;
    public static Font fButtonText;
    public static Font fontMessageText;
    public static MenuItem itemNovo;
    public static Component sideMenuComp;
     public static Component btnMenuItem;
      public static Component itemScn;
    public static int i;
    public static String btnText;
    public static String formato;

     public static  DisplayCurrentWork workMsg;
//    public static ArrayList<JLabel>menuItem= new ArrayList<JLabel>();
     public static ArrayList<String>categoryItem= new ArrayList<String>();
     public static ArrayList<Object>cmdObject=new ArrayList<Object>();
     public static  Thread status,buildOffice;
    public static StatusDialog sttDialog;
  // end attributes

  //Cocnstrutor
    public CmdTriger(String varCategoryText,int varCordX,int varCordY,int varWidth,int varHeight){
        super();
       
        this.cmdText=varCategoryText;
        this.cordX=varCordX;
        this.cordY=varCordY;
        this.width=varWidth;
        this.height=varHeight;

        formWindow=new MainWindow();
        setPack(new CmdSet());
        Settings();
        addMouseListener(new HandleCommand());


        /*Atributos para identificar a classe (o nome desta classe) por acesso
        aos objectos componentes que em outras classes
        */



    }
    
    public CmdTriger(){
        super();
        formWindow=new MainWindow();
        setPack(new CmdSet());
        Settings();
       addMouseListener(new HandleCommand());


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
  
  public String getCategoryName(){
      return this.getName();
  }
  
  /**
   * Atribui o texto a ser mostrado no objecto criado por esta classe. Esse texto
   é o que identifica visualmente uma categoria definida par o menu
   */
  public String setCategoryText(String strText){
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
   this.setSize(this.getHeight(),this.Height());
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

       lblCmdText=new JLabel(cmdText);
      
       lblCmdText.setForeground(Color.WHITE); //cor do texto
       fButtonText=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
       fontMetrics=getFontMetrics(fButtonText);
       fontMetrics.stringWidth(getCmdText());//o comprimento do texto definido
       lblCmdText.setSize(fontMetrics.stringWidth(getCmdText()),fontMetrics.getHeight());// o tamanho da Label que contem o texto
       lblCmdText.setLocation(Width()/2-getTextWidth()/2,Height()/2-getTextHeight()/2);//centra a label(com  o texto ) no espa�o do bot�o
       lblCmdText.setFont(fButtonText);//atribui a fonte ao texto do Label

   }

   
   /**
    * As propriedades gerais do componente:
    carrega os metodos para que o componente seja possivel no target de destino
    */
   public void Settings(){
        initColor=setColor(85,94,102);
        pressedColor=setColor(40,40,50);
        onOverColor=setColor(48,57,66);
        initLineColor=setColor(176,196,222);
        onClickColor=getParentColor();
        borderColor=setColor(66, 76, 85);
        setBackground(initColor);
        //buttonLineBorder=BorderFactory.createLineBorder(initLineColor,1);
        cmdBorder=BorderFactory.createMatteBorder(1,1,1,1,borderColor);

        CenterFont();
        setBorder(cmdBorder);
        setResize(this.width,this.height);
        setLocalInTarget();
        add(lblCmdText);
        setOpaque(true);
        setLayout(null);
        setVisible(true);
        setInHostClass();

   }


   
   public int getInstances(){
      int d=sideMenu.getObjectInstanceSize();
       for(i=0;i<d;i++){
            System.out.println(d);
        }

     return d;
   }

   /**
    * Este metodo vai permitir a activa��o de items de menu, por meio
      do teclado e bot�es de navega��o
    */

  public void activeItem(){
    int order=0;
    int ordClass;
    int it;
    for(it=0;it<sideMenu.menuItems.size()-1;it++){
        order=it+1;
      for(ordClass=0;ordClass<sideMenu.classes.size()-1;ordClass ++){
          if(sideMenu.menuItems.get(it).getCategoryName().equals(sideMenu.classes.get(ordClass).concat("_"+order))){
          

          }
      }
    }
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
   * Retorna um objecto do Item Menu CmdTriger
   */

   public CmdTriger scnObject(){
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

public void setPack(CmdSet sideMenu) {
  CmdTriger.sideMenu = sideMenu;
}

public static CmdSet getSideMenu() {
  return sideMenu;
}
  // end methods
private class HandleCommand implements MouseListener{

      
        public  void mouseClicked(MouseEvent me) {
            
                    if(me.getSource().equals(sideMenu.cmdImport)){
                       setCategoryText("IMPORTAR");
                       setBackground(pressedColor);
                       setWorkMessage(); 
                 
                     sttDialog=new frontend.inoutdialog.StatusDialog();
                      status=new Thread(sttDialog);
                      status.start();
                      if(status.getState().toString().equals("RUNNABLE")){
                 
                        buildOffice= new Thread(new office.OfficeSetUp.CreateOffice());
                        buildOffice.start();
                   
                        sttDialog.dispose();
                    }  

                    }
                    else if(me.getSource()==CmdSet.cmdExport){
                      setCategoryText("EXPORTAR");
                      setBackground(pressedColor);
                       setWorkMessage();
                       setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                       new office.OfficeLoader.LoadOffice();
                        setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
                    }
                      
                 
                       else if(me.getSource()==CmdSet.cmdJoin){
                      setCategoryText("JUNTAR");
                      setBackground(pressedColor);
                      setWorkMessage();
                     setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                      String strFile="system\\Usuario";
                      office.OfficeSetUp.OfficeSwich.CloseOffice(strFile);
                      office.OfficeSetUp.OfficeSwich.StopSystem();
                      office.OfficeUninstall.RemoveFromSystem(new File (strFile));
                     setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
                    }
                       else if(me.getSource()==CmdSet.cmdSearch){
                        setCategoryText("PROCURAR");
                        setBackground(pressedColor);
                       setWorkMessage();
                       String strData="ARTIGO";
                       String strOffice="Usuario";
                         setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                     office.OfficeData.InsertDataTable();
                     setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
                    }
                   
                      else if(me.getSource()==CmdSet.cmdNWork){
                      setCategoryText("AGENDA");
                      setBackground(pressedColor);
                      setWorkMessage();
                       setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                       
                     System.out.println(system.LoadSystemOffice.getOfficeCount(system.SetUpSystemOffice.sysDir));
                      setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ));
                    }
                
                      else if(me.getSource()==CmdSet.cmdResource){
                      setCategoryText("RECURSOS");
                      setBackground(pressedColor);
                      setWorkMessage();
                      setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                     //new frontend.inoutdialog.SystemBrowser().BrowseTo();
                     new frontend.inoutdialog.InputDialog();
                     setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
                    }
                        else if(me.getSource()==CmdSet.cmdInDrive){
                      setCategoryText("INSTALAR");
                      setBackground(pressedColor);
                      setWorkMessage();
                      setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ));
                    // new frontend.inoutdialog.SystemBrowser().BrowseTo();
                   new jdesktop.app.ShortCut();
                    setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
                    }
                    
        }

     
        public void mousePressed(MouseEvent me) {
                if(me.getSource()==CmdSet.cmdImport){
                       ((JPanel)(me.getSource())).setBackground(pressedColor);

                    }
                    else if(me.getSource()==CmdSet.cmdExport){
                         ((JPanel)(me.getSource())).setBackground(pressedColor);

                    }
                   
                    
                       else if(me.getSource()==CmdSet.cmdJoin){
                          ((JPanel)(me.getSource())).setBackground(pressedColor);

                    }
                       else if(me.getSource()==CmdSet.cmdSearch){
                           ((JPanel)(me.getSource())).setBackground(pressedColor);

                    }
                     
                      else if(me.getSource()==CmdSet.cmdNWork){
                               ((JPanel)(me.getSource())).setBackground(pressedColor);
                    }
                   
                      else if(me.getSource()==CmdSet.cmdResource){
                                  ((JPanel)(me.getSource())).setBackground(pressedColor);
                    }
                  else if(me.getSource()==CmdSet.cmdInDrive){
                                  ((JPanel)(me.getSource())).setBackground(pressedColor);
                    }
                 
        }

      
        public void mouseReleased(MouseEvent me) {
                 if(me.getSource()==CmdSet.cmdImport){
                       ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                    else if(me.getSource()==CmdSet.cmdExport){
                         ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                      
                   
                       else if(me.getSource()==CmdSet.cmdJoin){
                          ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                       else if(me.getSource()==CmdSet.cmdSearch){
                           ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                 
                      else if(me.getSource()==CmdSet.cmdNWork){
                               ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                     
                      else if(me.getSource()==CmdSet.cmdResource){
                                  ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                 else if(me.getSource()==CmdSet.cmdInDrive){
                                  ((JPanel)(me.getSource())).setBackground(initColor);
                    }


        }

      
        public void mouseEntered(MouseEvent me) {
            ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.HAND_CURSOR));
                     if(me.getSource()==CmdSet.cmdFileSet){
                         ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }

                     if(me.getSource()==CmdSet.cmdImport){
                       ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdExport.setBackground(initColor);
                         
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdSearch.setBackground(initColor);
                         
                         sideMenu.cmdNWork.setBackground(initColor);
                         sideMenu.cmdResource.setBackground(initColor);
                         sideMenu.cmdInDrive.setBackground(initColor);
                        frontend.inoutdialog.InDialog.setWindowTitle("importar");


                    }
                    
                    else if(me.getSource()==CmdSet.cmdExport){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                        
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdSearch.setBackground(initColor);
                        
                         sideMenu.cmdNWork.setBackground(initColor);
                         sideMenu.cmdResource.setBackground(initColor);
                         sideMenu.cmdInDrive.setBackground(initColor);
                         frontend.inoutdialog.InDialog.setWindowTitle("exportar");

                    }
                      
                    else if(me.getSource()==CmdSet.cmdArticleSet){
                         ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                    else if(me.getSource()==CmdSet.cmdJoin){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                         sideMenu.cmdExport.setBackground(initColor);
                        
                         sideMenu.cmdSearch.setBackground(initColor);
                     
                         sideMenu.cmdNWork.setBackground(initColor);
                         sideMenu.cmdResource.setBackground(initColor);
                         sideMenu.cmdInDrive.setBackground(initColor);
                   frontend.inoutdialog.InDialog.setWindowTitle("juntar artigo");
                    }
                       else if(me.getSource()==CmdSet.cmdSearch){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                         sideMenu.cmdExport.setBackground(initColor);
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdNWork.setBackground(initColor);
                         sideMenu.cmdResource.setBackground(initColor);
                         sideMenu.cmdInDrive.setBackground(initColor);
                    frontend.inoutdialog.InDialog.setWindowTitle("pesquisar artigo");
                    }
                    else if(me.getSource()==CmdSet.cmdManageSet){
                         ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                      else if(me.getSource()==CmdSet.cmdNWork){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                         sideMenu.cmdExport.setBackground(initColor);
                    
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdSearch.setBackground(initColor);
                        
                         sideMenu.cmdResource.setBackground(initColor);
                        sideMenu.cmdInDrive.setBackground(initColor);
                        frontend.inoutdialog.InDialog.setWindowTitle("recursos web");
                    }

                      else if(me.getSource()==CmdSet.cmdResource){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                         sideMenu.cmdExport.setBackground(initColor);
                      
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdSearch.setBackground(initColor);
                    
                         sideMenu.cmdNWork.setBackground(initColor);
                        sideMenu.cmdInDrive.setBackground(initColor);
                       frontend.inoutdialog.InDialog.setWindowTitle("gerir recursos");
                    }
                   else if(me.getSource()==CmdSet.cmdInDrive){
                         ((JPanel)(me.getSource())).setBackground(onOverColor);
                         sideMenu.cmdImport.setBackground(initColor);
                         sideMenu.cmdExport.setBackground(initColor);
                      
                         sideMenu.cmdJoin.setBackground(initColor);
                         sideMenu.cmdSearch.setBackground(initColor);
                    
                         sideMenu.cmdNWork.setBackground(initColor);
                       frontend.inoutdialog.InDialog.setWindowTitle("instalar");
                    }
                     
        }

    
        public void mouseExited(MouseEvent me) {
                    if(me.getSource()==MainWindow.bookIn){
                         sideMenu.cmdExport.setBackground(initColor);
                    }
                    else if(me.getSource()==CmdSet.cmdImport){
                         ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                    else if(me.getSource()==CmdSet.cmdExport){
                         ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                     
                    
                       else if(me.getSource()==CmdSet.cmdJoin){
                          ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                       else if(me.getSource()==CmdSet.cmdSearch){
                           ((JPanel)(me.getSource())).setBackground(initColor);

                    }
                 
                      else if(me.getSource()==CmdSet.cmdNWork){
                               ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                    
                      else if(me.getSource()==CmdSet.cmdResource){
                                  ((JPanel)(me.getSource())).setBackground(initColor);
                    }
                     else if(me.getSource()==CmdSet.cmdInDrive){
                                  ((JPanel)(me.getSource())).setBackground(initColor);
                    }
        }
    }
}
        
 //end clas
