package frontend.system;



import frontend.syscommand.CommandContext;
import frontend.system.StatusBar;
import frontend.inoutdialog.DataBoard;
import frontend.display.DisplayCurrentWork;
import frontend.workbook.Book;
import frontend.syscommand.ContextPlaceHolder;
import frontend.syscommand.CommandContext;
import frontend.workbook.TabSet;
import frontend.system.HandleCommand;
import frontend.system.FrontendMainWindowHandleBar;
import frontend.inoutdialog.InDialog;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import startsystem.status.InstanceLog;
  /*
  para redimencionar os componentes tentar o seguinte:
  fazer update as dimens�es do form, apos este ser redimencionado.
  colocar o tamanho do componente igual ao novo tamnho do form
  */
public class MainWindow extends JFrame implements MouseMotionListener, MouseListener {

  //Variaveis
  private static PopupMainWindowCmdPack ppp;   
  public static InDialog appwindow;
  public static JPanel pnlControlForm;

  public  static JTextField txtSearch;
  public static JLabel lblPosterName;
 
   public static JPanel pnlMsg;


  public static HandleCommand closeButton;
  public static HandleCommand minimizeButton;
  public static HandleCommand maximizeButton;
  public static MouseEvent me;
  public static Container board;
  public static ContextPlaceHolder cmdPack;
  //public static JSeparator lineSeparator;
  public static Point targetLocal ; //o ponto no frame onde a barra ser� colocada
  public static Point pLocalHeight, pLocalWidth; // pontos de localisa��o do form
  public static int posX, posY;
  public static Border formBorder;
  public static Border displayActivity;
  public static FrontendMainWindowHandleBar  logoBar;
  public static String nameApp, templateName;
  public static int width, height, targetPointX, targetPointY;
  public static  Point local;
  public static  Point startLocal;
  public static  Point startReLocal;
  public static  Point formLocal;
  public static Point formDefinedLocal;
  public static Point formOldLocal;
  public static Point newFormLocal;
  public static Dimension screenSize;
  public static MouseEvent getLocal;
  
  public static FontMetrics fontMetrics;
  public static Font fontMsg;
  
  public static  int componentStartHeight;
  public static int componentStartWidth;
  public static int componentReStartWidth;
  public static int formOldWidth;
  public static int formOldHeight;
  public static  int minHeight = 80 ; //a menor altura do form
  public static int minWidth = 350 ; // o menor comprimento do form
  public static int nextWidth; // o novo comprimento do form quando arrasta o mouse
  public static JPanel pnlTxt;
  public static int nextHeight; // a nova altura do form  quando arrasta o mouse
  public static int compWidth; // o comprimento actua do form
  public static int compHeight; // a altura actual do form
  public static  int xWidth;
  public static  int reSizeWidth;
  private static int topMargin,rightMargin,downMargin,leftMargin,margin;
  public static Point pLbl;
  public static Color colorMsg;
  public static Color colorPnlModelBorder;
  public static Color colorBkGrdPnlModel;
  public static Color colorBkGrdPnlData;
  public static Color colorPnlDataText;
  public static Color colorPnlDataBorder;
  public static DataBoard pnlData;
  public static Border displayTxtBorder;
  public static StatusBar status;
  public static Book bookIn;
  public static DisplayCurrentWork displayMsg;
  public static Point plToMsg;
  public SystemIcon sicon;
  //********* Da private class PopupMainWindowCmdPack
    
  // Icon
  // \Markit\dist\resource\images\icons
  //userHomeDir.concat(sep).concat(sep).resource.concat(sep).concat(sep).concat(images).concat(sep).concat(sep).concat(icons).concat
    private String sep=System.getProperty("file.separator");
    private String arqIconSet=sep.concat(sep).concat("icons"); // directorio de definições
  // private String resourceDir=
    private String extIconImg=".png";
    private String arqImgIconName="markit";
    private String arqSet=sep.concat(sep).concat("skin").concat(arqIconSet);// nome do arquivo (settings)
    public String systemDir = System.getProperty("user.dir"); // directorio do sistema - markit
   //private File dirSet = new File(userHomeDir.concat(fileSet)); // onde será guardado o arquivo
   //private String arqIconPath=userHomeDir
  String baseDir=System.getProperty("user.dir");
  public static Image img;
  BufferedImage bfdImg;
  
  public MainWindow() {
     super();
  }
   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.   /**
    * Construtor simples que necessita apenas do nome
    da form. Isto implica que o tamanho da form
    � predefinido 800x600.
    � este o construtor o que define a janela principal
    da aplica��o.
    */

  public MainWindow(String varNameApp) {
    super(nameApp);
    this.nameApp = varNameApp; //O titulo da aplica��o
    Settings();
    setSearchArea();
    
  }
 
  public MainWindow(String varNameApp, ImageIcon varImg) {
      /*
      explorar a criação desta app seguindo este construtor que
      pretende colocar automaticamente o icon da aplicação - ver método 
      setWindowIcon definido nesta classe
      */
    super(nameApp);
    this.nameApp = varNameApp; //O titulo da aplica��o
    ImageIcon img= varImg;
    Settings();
    setSearchArea();
  }
/**
 * Construtor que recebe o nome da form e o tamanho
 a definir. Este construtor vai ser usado internamente
 para definir outras forms e, externamente para a cria��o de
 templates.
 */
  public MainWindow(String varTemplateName, int varWidth, int varHeight) {
      super(templateName);
      this.templateName=varTemplateName;
      this.width=varWidth;
      this.height=varHeight;
  }
  
 public String getTaskName(){
     /*
     Retorna o nome o titulo da janela
     A desenvolver método par aretornar o nome da 
     task perante o valor do seu PID 
     
     Isto pode estar desenvolvido numa classe separada
     */
      return super.getTitle();
  }
  

  public void setTaskName(String varStrName){
      varStrName=nameApp;
    this.setName(nameApp);
    super.setTitle(nameApp);
  }
  public String getFormName(){
    return this.getName();
  }
 

  public int setTargetPointX(){
    targetPointX=0;
    return targetPointX;
  }
  public int setTargetPointY(){
    targetPointY=0;
    return targetPointY;
  }
 public Point setAsTargetLocal(int targetPointX,int targetPointY){
  targetLocal=new Point(targetPointX,targetPointY);
  return targetLocal;
 }
 
 private void StartComponents(){
    // inicia todos os componentes existentes  
 }
 private void PackComponents(){
   // junta todos os componentes  
 }
  /** 
   * As propriedades pre-definidas do form, como tamnho, localiza��o, cor de fundo,
     menu lateral,barra de titulo e bot�es de controlo(maximizar, minimizar, fechar)
   */
  private void setStatus(){
   
      topMargin=0;
      rightMargin=getWidth()-leftMargin + cmdPack.getWidth()+margin + bookIn.getWidth();
      downMargin=0;
      leftMargin=cmdPack.getLocation().x;
      margin=bookIn.getLocation().x-leftMargin - cmdPack.getWidth();
      int statusW= cmdPack.getSize().width + margin + bookIn.getSize().width;
      status=new StatusBar(cmdPack.getLocation().x,cmdPack.getHeight()+cmdPack.getLocation().y + margin,
      statusW,getHeight() - bookIn.getHeight()- bookIn.getLocation().y);
      board.add(status);
  }
  
  private void setIconBar(){
      //a barra de titulo e de icon
      logoBar=new FrontendMainWindowHandleBar(nameApp,this);
      logoBar.setLocation(this.setAsTargetLocal(targetPointX,targetPointY));
      logoBar.setSize(this.getWidth(),50);
  }
  public void Settings(){

    setDefaultSize();
    setWindowCommand();
     
    setSideMenu();
    setTaskName(nameApp);
    board=getContentPane();
    board.setName("content");
    setGlassPane(pnlControlForm);
    setSize(width,height);
    setUndecorated(true);
 
     //Colocar a barra de titulo e um bordo em torno da window
    setIconBar();
    formBorder=BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    getRootPane().setBorder(formBorder);
    
    //Colocar o Icon na barra
     setWindowIcon();
     
     //Painel de comandos
     /*
     Setar o comprimento para um valor percentual do total da janela
     */
     
     int ttW=getWidth();// o comprimento da janela
     int percW=10; // valor percentual a atribuir ao componente
     int cmdPackW= 18 * ttW / 100; // calculo do comprimento do componente ( regra 3 simples) 
   
     cmdPack=new ContextPlaceHolder(this,3,logoBar.getDefinedHeight(),cmdPackW,getHeight()-100);
    cmdPack.setVisible(true);
    board.add(cmdPack);


    bookIn=new Book(cmdPack.getWidth()+5,logoBar.getHeight(),getWidth()-cmdPack.getWidth()-12,getHeight()-100);
    bookIn.setVisible(true);
    bookIn.setLayout(null);

       
 // bookIn.setBackground(new Color(85,94,102));
    appwindow=new InDialog("introdução de dados",600,400);
    appwindow.isDraggable(true);
    
    bookIn.bookset.add(appwindow);
    board.add(bookIn);
   
    board.setLayout(null);
    board.add(logoBar);
    board.setBackground(MainBackColor());
    
   //barra de status
     setStatus();
    this.setDefaultLookAndFeelDecorated(false);
    this.setLocationRelativeTo(null);
    this.closeButton.addMouseListener(this);
    this.minimizeButton.addMouseListener(this);
    this.maximizeButton.addMouseListener(this);
    addMouseMotionListener(this); 
    addMouseListener(this); 
    this.setVisible(true);
   
  }

private Color MainBackColor(){
     return new startsystem.LoadSettings().readMainBackColor();
}

    public int getMsgWidth(){
     return DisplayCurrentWork.lblText.getSize().width;
    }

  public int getMsgHeight(){
     return DisplayCurrentWork.lblText.getSize().height;
  }

  public void setDefaultSize(){
     screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    this.width=screenSize.width;
    this.height=screenSize.height-30;
  }
  
  public void setWindowCommand(){
    closeButton=new HandleCommand("X",this.width()-45,0,40,18);
    maximizeButton=new HandleCommand("+",this.width()-70,0,25,18);
    minimizeButton=new HandleCommand("-",this.width()-95,0,25,18);
    pnlControlForm=new JPanel();
    pnlControlForm.setOpaque(false);
    pnlControlForm.setLayout(null);
    pnlControlForm.add(closeButton);
    pnlControlForm.add(maximizeButton);
    pnlControlForm.add(minimizeButton);

    getGlassPane().setVisible(true);
  }
public void setWindowIcon(){
 //adicionar listener da private class HandleIcon
   sicon = new SystemIcon(logoBar.getX(),logoBar.getY(),this.logoBar.getSize().height,this.logoBar.getSize().height);
   sicon.addMouseListener(new HandleIcon());
   pnlControlForm.add(sicon);
   }

 


 public void setInDriveCmd(){
     /**
      * Comando de instalação
      */
    // new frontend.syscommand.CommandContext("Instalar", this.width()-95, posY, minWidth, minHeight)
 }
  public void setSideMenu(){

  }
  
  public void setSearchArea(){
  }
  
  public void setTemplateProperties(){
  }
  
  public String setNameApp(){
        return nameApp;
  }
  
  public String getNameApp(){
        return this.getName();
  }
  
  public String setTemplateName(){
          return templateName;
  }
  
  public String getTemplateName(){
        return this.getName();
  }
  
  public int width(){
       return width;
  }
  
  public int height(){
        return height;
  }
  
  public int getDefinedWidth(){
    return this.getWidth();
  }
  
  public int getDefinedHight(){
    return this.getHeight();
  }
  
//Fechar a aplica��o
  public  void Close() throws IOException{
    startsystem.Load.Stop();
    System.exit(0);
  }
  
  /**
   * Minimizar a aplica��o: a aplica��o torna-se invisivel,
     no entanto ainda se encontra activa. Usa o m�todo
     getExtendedState() para averiguar o estado de aparencia
     do MainWindow. Se este for diferente de 1 o MainWindow n�o esta minimizado.
     Ap�s esta avalia��o usa-se o metodo setExtendedState(MainWindow.ICONIFIED),
     para minimizar a aplica��o
   */
  public void Minimize(){
        if(super.getExtendedState()!=1){
           setExtendedState(Frame.ICONIFIED );
        }
  }
  
  /**
   * Maximizar a aplica��o:Para este m�todo averigua-se primeiro
   qual o tamnho corrente do MainWindow. A aplica��o maximizada, usaria
   o m�todo getExtendedState(MainWindow.MAXIMIZED_BOTH), o que ocuparia todo
   o ecran, tapando a barra de estado do Sistem Operativo. Para contornar este
   problema, � necess�rio descontar ao tamanmho do ecran, o tamanho da barra de estado
   do sistema operativo. Isto � conseguido carregando o package java.awt.Toolkit, e usando o metodo
   Toolkit.getDefaultToolkit().getScreenSize(), para determinar as dimen��es do ecran. A estas
   dimen��es s�o retiradas a altura da barra de estado do sistema operativo e o resultado �
   aplicado �s dimen��es do MainWindow. Mas como o MainWindow pode ser redimencionado, estas dimen��es
   podem ser alteradas em tempo de execu��o pelo user.
   Se a verifica��o das dimen��es do form n�o corresponder �s que est�o definidas inicialmente,
   ent�o o MainWindow, n�o esta Maximizado.Nesse caso atribui o tamnho predefinido.
   */

  public void Maximize(){

    if(!((getWidth()==screenSize.width)&&(getHeight()==screenSize.height-30))){
        setSize(screenSize.width,screenSize.height-30);
        setLocationRelativeTo(null);
        logoBar.setSize(getWidth(),logoBar.getHeight());
//        pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
        closeButton.setLocation(getWidth()-45,0);
        maximizeButton.setLocation(getWidth()-70,0);
        minimizeButton.setLocation(getWidth()-95,0);
        cmdPack.setSize(cmdPack.getWidth(),getHeight());
    }
    else if((formOldWidth!=0) && (formOldHeight !=0)){
        Restore();
    }
  }
  
   /**
    * Restaura as dimen��es do form para o tamanho que o user atribuiu em tempo de execu��o.
    Para executar este m�todo, � necessario guardar as dimen��es do form, sempre que o user
    as altera. Isto s� acontece quando o cursor predefinido � alterado para os cursores de redimencionamento.
    Neste m�todo n�o � feita nenhuma verifica��o. O m�todo � usado dentro do m�todo de Maximiza��o,
    como resultado de verifica��o das dimen��es do form.Sempre que o form esta Maximizado, quando se clica no
    bot�o de Maximizar, � feita esta verifica��o: se as dimen��es forem as predefinidas o clic resulta na
    atribui��o das dimen��es anteriores do form.
    */
  
  public void Restore(){


            width=formOldWidth;
            height=formOldHeight;
            setSize(width,height);

            setLocation(formOldLocal);
//            pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
            closeButton.setLocation(getWidth()-45,0);
            maximizeButton.setLocation(getWidth()-70,0);
            minimizeButton.setLocation(getWidth()-95,0);
  }

   /**
    * Redimenciona o form por arrastamento do Mouse
    */
 public void mouseMoved(MouseEvent me){
 //Redimencionar o form
    /*
    Altera o cursor em conformidade com o ponto onde passa o mouse
    A cordenada y desse ponto devera estar entre o valor da altura
    e esse valor -5. O valor 5 � arbitrario.
    Do mesmo modo a cordenada x do ponto devera estar entre o valor do
    comprimento  e esse valor -5. O valor 5 tamb�m � arbitrario
    */
     pLocalHeight = me.getPoint();
     pLocalWidth = me.getPoint();
    if (pLocalHeight.y > me.getComponent().getSize().height - 5){
      setCursor( Cursor.getPredefinedCursor( Cursor.S_RESIZE_CURSOR ));
    }
    else if(pLocalWidth.x > me.getComponent().getSize().width - 5){
          setCursor( Cursor.getPredefinedCursor( Cursor.E_RESIZE_CURSOR ));
    }
    else if(pLocalWidth.x <5){
           setCursor( Cursor.getPredefinedCursor( Cursor.W_RESIZE_CURSOR ));
    }
    else if(pLocalHeight.y <5){
         setCursor( Cursor.getPredefinedCursor( Cursor.N_RESIZE_CURSOR ));
    }
    else{
      setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
    }
  }
      /**
      Obtido o local para alterar o cursor, verifica-se qual o novo tipo de
      cursor corrente. O redimencionamento  do form � feito num dos sentidos
      em conformidade com o cursor actual.
      */
  public void mouseDragged(MouseEvent me) {
     pLocalHeight = me.getPoint();// O mesmo que local
     
     pLocalWidth = me.getPoint();
     compWidth = getSize().width;
     compHeight = getSize().height;
     startReLocal =getLocation(startReLocal);


    //redimenciona de baixo para cima
    if (getCursor().getType() == Cursor.S_RESIZE_CURSOR){
       nextHeight = componentStartHeight+pLocalHeight.y-local.y;
        if (nextHeight > minHeight){
            setSize(compWidth,nextHeight);
            formOldWidth=getWidth();
            formOldHeight=getHeight();
            formOldLocal=getLocation();
            cmdPack.setSize(cmdPack.Width(),nextHeight);
//            pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
            setVisible(true);
        }
    } // fim
    // redimenciona da direita para a esquerda
    else if(getCursor().getType() == Cursor.E_RESIZE_CURSOR){
            nextWidth = componentStartWidth+pLocalWidth.x-local.x;
                if(nextWidth > minWidth){
                    setSize(nextWidth,compHeight);
                    formOldWidth=getWidth();
                    formOldHeight=getHeight();
                    formOldLocal=getLocation();
                    //Vai redimencionar a barra de titulo (so ocomprimento)
                    logoBar.setSize(nextWidth,logoBar.getHeight());
                    //pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
                    closeButton.setLocation(nextWidth-45,0);//posiciona o componente
                    maximizeButton.setLocation(nextWidth-70,0);
                    minimizeButton.setLocation(nextWidth-95,0);
                    setVisible(true);
                }
      }
      else if(getCursor().getType() == Cursor.N_RESIZE_CURSOR){
              int yHeight = startReLocal.y - getLocal.getY() + me.getY();
              int reSizeHeight=startLocal.y-startReLocal.y;
              nextHeight = componentStartHeight+pLocalHeight.y-local.y+reSizeHeight;
              setLocation(getX(),yHeight);
                     if(nextHeight > minHeight){
                       setSize(compWidth,nextHeight);
                       formOldWidth=getWidth();
                       formOldHeight=getHeight();
                       formOldLocal=getLocation();
//                       pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
                       setVisible(true);
                     }

      }
      else if(getCursor().getType() == Cursor.W_RESIZE_CURSOR){

           xWidth = startReLocal.x - getLocal.getX() + me.getX();
           reSizeWidth=startLocal.x-startReLocal.x;
           nextWidth = componentStartWidth+pLocalWidth.x-local.x+reSizeWidth;
           setLocation(xWidth,getY());
              if(nextWidth>minWidth){
                 setSize(nextWidth,compHeight);
                 logoBar.setSize(nextWidth,logoBar.getHeight());
//                 pnlActivity.setSize(getWidth()-cmdPack.getWidth()-8,getHeight()-logoBar.getHeight()-8);
                 closeButton.setLocation(nextWidth-45,0);//posiciona o componente
                 maximizeButton.setLocation(nextWidth-70,0);
                 minimizeButton.setLocation(nextWidth-95,0);
                 formOldWidth=getWidth();
                 formOldHeight=getHeight();
                 formOldLocal=getLocation();
                 setVisible(true);
                  
              }
      }
}

  public void mousePressed(MouseEvent me){
    local = me.getPoint();
    getLocal = me;
    startLocal= getLocation();
    componentStartHeight = getSize().height;
    componentStartWidth = getSize().width;
  }

  public void mouseEntered(MouseEvent me){
        this.requestFocus();
    }

    public void mouseExited(MouseEvent me){
      if (local == null)
      {
        setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
      }

    }
     public boolean isMaximized(){
       return true;
     }
   
    public void mouseClicked(MouseEvent me){
         if(me.getSource()==closeButton){
            ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.WAIT_CURSOR));
           office.OfficeSetUp.OfficeSwich.StopSystem();
             try {
                 Close();
                ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  
             } catch (IOException ex) {
                
             }finally{
                ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
             }
         }
         else if (me.getSource()==minimizeButton){
             Minimize();
         }
         else if(me.getSource()==maximizeButton){
           Maximize();
         }

      }

    public void mouseReleased(MouseEvent me){
      local = null;

    }
 private class HandleIcon implements MouseListener{
        /*
        -Deve detectar o click direito do mouse 
     e implementar o menu suspenso de funções e informações avançadas
     -Implementa ainda o menu de visualisação da ajuda ou tutoriais de execução
     - Pode ainda referenciar a documentação tecnica do programa (requer senha)
     - A alternativa ao menu suspenso ou Dialog, passa por alterar uma pagina 
     no cmdpack, o que implicaria criar um cmdbook no cmdpack
     */
    
        public void mouseClicked(MouseEvent e) {
           //JOptionPane.showMessageDialog(null,"Menu click", "MainWindow Icon",1, null);
            if(e.getButton()==MouseEvent.BUTTON1){
                //  setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
                
                String strC="";
                int nc,n;
                String strCP="";
                nc=MainWindow.super.getComponentCount();
                Component cC,cCP,cCPp;
                for (int i=0;i<nc;i++){
                    cC=MainWindow.super.getComponent(i);
                    strC="No mainWindow:"+" "+nc+" "+cC.getClass().getCanonicalName()+"\n"; //Mostrar
                }
                nc=MainWindow.super.getContentPane().getComponentCount();
                for( n=0;n<nc;n++){
                      
                cCP=MainWindow.super.getContentPane().getComponent(n);
                  JOptionPane.showMessageDialog(null,n+" "+new String(nc+":"+MainWindow.super.getContentPane().getClass().getCanonicalName()+":\n"+
                         cCP.getClass().getCanonicalName()+" -> "+cCP.getClass().getSimpleName()+"\n")+"\n","Contentores",1,null); 
                }
                  
            }
            else if(e.getButton()==MouseEvent.BUTTON2){
               //  setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
            } else if(e.getButton()==MouseEvent.BUTTON3){
                
                /*
                Impedir abertura de segundo popup
                implenetar metodo isVisible()-boolean
                Verificar isVisible() se true o click fecha se false o click abre
                
                Ao arrastar a janela principal este popup deve acompanhar
                o movimento do componente que o chamou mantendo a posição 
                relativa
                */ 
                ppp=new PopupMainWindowCmdPack();   
                ppp.Status();
            }  
        }

       
        public void mousePressed(MouseEvent e) {
           
        }

       
        public void mouseReleased(MouseEvent e) {
            setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
        }

        public void mouseEntered(MouseEvent e) {
           // setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
        }

       
        public void mouseExited(MouseEvent e) {
           
        }
     
   }
 public static final class PopupMainWindowCmdPack extends JDialog {
     
    private static int posX,posY;
    private static Container ctnCompn;//contentor de paineis
    private static JPanel pnlHandleBar;
    private static JPanel pnlMain;
    private static Point local;
    private static MouseEvent getLocal;
    private static CommandContext cmdFechar;
    private final static String strTitle="Markit - extras";
    private static JLabel lblTitle=new JLabel(strTitle);
    private static Font fTitle;
    private static FontMetrics fontMetrics;
  
    private static String strDisplay;
   
    private static Component comp;
    
    public PopupMainWindowCmdPack() {
        super();
        
        ctnCompn=getContentPane();
        ctnCompn.setBackground(new Color(119, 136, 153));
        ctnCompn.setLayout(null);
      
        //Caracterizar o dialog  
        setUndecorated(true);     
	setSize(MainWindow.cmdPack.getWidth(),400);
        setLocation(MainWindow.cmdPack.getLocationOnScreen().x,MainWindow.cmdPack.getLocationOnScreen().y);
        //setVisible(true);
                
	addMouseListener(new HandlePopup());//atribui acçao do mouse quando percorre o corpo da janela
	pnlHandleBar=new JPanel();	
        pnlHandleBar.setBackground(Color.black);
        pnlHandleBar.setSize(500,30);
        pnlHandleBar.setLayout(null);
                
        pnlMain=new JPanel();
        pnlMain.setBounds(0, pnlHandleBar.getHeight(),this.getWidth(),this.getHeight()-pnlHandleBar.getHeight());
       
        add(pnlHandleBar);
        add(pnlMain);
                
        // Areas de texto
                
        JTextField hdserialtxt= new JTextField();
	hdserialtxt.setColumns(100);
        hdserialtxt.setBounds(pnlMain.getLocation().x+50,pnlMain.getLocation().y+50, pnlMain.getSize().width/2,50);
        hdserialtxt.setText("serial");
        pnlMain.add(hdserialtxt);
	//Permitir que a janela possa ser arrastada pelo mouse    
        pnlHandleBar.addMouseListener( new HandlePopup() );
        pnlHandleBar.addMouseMotionListener( new HandlePopup() );	
        //cmdFechar.addActionListener(this);
        
        CenterTitle();
    }
    
      public Color setColor(int R,int G,int B){
           Color color=new Color(R,G,B);
           return color;
        }
    private  void getComponentsIn(){
         
    }
    
    public boolean Status(){
        boolean status=false;
        if(!isActive()){
            status=false;
            setVisible(true);
        }else if(isActive()){
            status=true;
            dispose();
        }
        return status;
    }
    
    public void Close(){
        dispose();
    }
    
    public static String updateTitle(){
        /* 
        Método para atribuir o titulo mostrado na barra de titulo
        Útil para mostrar o trabalho em curso quando ocupar várias 
        fases ex. " SinInput- trabalho a decorrer"
        */
        
         return lblTitle.getText(); 
    }
 
      public void CenterTitle(){
         
       lblTitle.setText(updateTitle());
       strDisplay=lblTitle.getText();
       lblTitle.setForeground(Color.WHITE); //cor do texto
       fTitle=new Font("Futura MD BT", Font.BOLD,14);//propriedades da fonte
       fontMetrics=getFontMetrics(fTitle);
       fontMetrics.stringWidth(strDisplay);//o comprimento do texto definido
       lblTitle.setSize(fontMetrics.stringWidth(strDisplay),fontMetrics.getHeight());// o tamanho da Label que contem o texto
       lblTitle.setLocation(10,pnlHandleBar.getSize().height/2-getTextHeight()/2);//centra a label(com  o texto ) no espa�o do bot�o
       lblTitle.setFont(fTitle);//atribui a fonte ao texto do Label
    
       pnlHandleBar.add(lblTitle);
      
   }
         public int getTextWidth(){
         return lblTitle.getSize().width;
  }
  
    public int getTextHeight(){
     return lblTitle.getSize().height;
  }
     private class HandlePopup implements MouseListener, MouseMotionListener,ActionListener{

            
        public void mouseEntered(MouseEvent e){ 
               for(int i=0; i<getContentPane().getComponents().length;i++){
              comp=getContentPane().getComponent(i);
              if(e.getSource().hashCode()==comp.hashCode()){
                  setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
               }  
            }
        }
        public void mouseExited(MouseEvent e) { 
            setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
        }
        
        
        public void mouseMoved(MouseEvent e){
        }
        
        public void mouseReleased(MouseEvent e) {
        }
        
        public void actionPerformed(ActionEvent evento){    
        }
        
        public void mouseClicked(MouseEvent evento) {
             dispose();
             
        }
 
        public void mousePressed(MouseEvent evento){ 
        }
        
        public void mouseDragged(MouseEvent evento){
        }
         
     }
  }
 
 private class Status{
     private final String open="WINDOW_OPEN";
     private final String close="WINDOW_CLOSE";
     public Status(String varStatus){
         
     }
 }
 
 public class WindowManager{
     
 }
}