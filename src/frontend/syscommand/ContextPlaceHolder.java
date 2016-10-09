/*
Irá receber objectos de commandpack
Cria objectos de commandset na mainwindow
*/

package frontend.syscommand;


import frontend.syscommand.CommandContext;
import frontend.system.FrontendMainWindowHandleBar;
import frontend.system.MainWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;



public class ContextPlaceHolder extends JPanel{
  // start attributes
    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static int i,c,d,j,k,n,y,m,l,o,p,HTarget,HPercSector,HPercLbl,contentCount;
    public static Color darkGradient;
    public static Color lightGradient;
    public static MainWindow formWindow;
    public static FrontendMainWindowHandleBar logoBar;
    public static CommandContext cmdFileSet;
    public static CommandContext cmdArticleSet;
    public static CommandContext cmdManageSet;
    public static JLabel lblCtxt;
    public static Command cmdImport;
    public static Command cmdExport;
     public static Command cmdJoin;
    public static Command cmdSearch;
     public static Command cmdManage;
    public static Command cmdResource;
    public static Component compChield;
    public static Component compValue;//refere qualquer componente do menu, nesta classe
    public static Component compObject;//refere qualquer componente nesta classe
    public static Object objChield;
    public static Object objectMenu;//refere qualquer objecto do menu, nesta classe
    public static Object objectInstance;
    public static String strClassName,strArtHelp,strFileHelp,strChieldName;
   
    public static ArrayList<String>classes= new ArrayList<String>();
    public static ArrayList<Component>chield= new ArrayList<Component>();
    public static ArrayList<Object> objectItem =new ArrayList<Object>();
    public static ArrayList<CommandContext> menuItems =new ArrayList<CommandContext>();
    public static String strClass;
    private static JTextArea txtaFileHelp,txtaArtHelp,txtaMktHelp;
  
    private static FontMetrics fontMetrics;
    private static Font fontText;
  // end attributes

  //Construtor
    public ContextPlaceHolder(){

    }
    public ContextPlaceHolder(MainWindow varFormWindow,int varCordX,int varCordY,int varWidth,int varHeight){
        super();
        this.formWindow=varFormWindow;
        this.cordX=varCordX;
        this.cordY=varCordY;
        this.width=varWidth;
        this.height=varHeight;
        d=0;
        n=1;
        j=0;
        k=0;
        y=0;
        m=0;
        l=0;
        o=0;
        p=0;
        fontText = new Font("Futura LT Pro Book", Font.PLAIN,12);
        InstallCommands();
        
        addMouseMotionListener(new HandleSetByDrag());
        addMouseListener(new HandleSetByDrag());
        
    }

 

  // start methods

    /**
     * Atribui automaticamente um nome predefinido aos objectos componentes
     nesta classe: o nome � o nome da classe mais o numero de ordem do objecto,
     sendo que este numero de ordem � incrementado conforme o numero de objectos
     repetidos e provenientes da mesma classe m�e.
     */
      public void setComponentName(){
      /*
      M�todo:
      Passo 1�:contar todos componentes, obter o nome das classes m�es e guardar
              em vectores respectivos os objectos e os nomes das classes.
      Passo 2�: Percorrer o vector de classes e verificar para cada instancia se no vector de ojectos
              os nomes das suas classes correspondem aquelas que est�o instanciadas.Em caso
              positivo, atribui o nome ao objecto
      Passo 3�:verificar na lista de objectos se existem repeti��es para cada
               indice.Em caso afirmativo a nomea��o dos objectos � feita dando
               o nome da sua classe, concatenado ao valor duma variavel
              incrementada, que faz a nomera�a� do objecto repetido.
      */
            //Passo 1
        for (i=0;i<getComponentCount();i++){
            compChield=getComponent(i);//Conta todos os componentes
            strClassName=compChield.getClass().getCanonicalName();
            chield.add(compChield);// adicina os objectos ao vector
             if(!classes.contains(strClassName)){ //Se o nome da classe ainda � existe na lista
               classes.add(strClassName);// adiciona o nome da classe
            }
        }
            //Passo 2
        for( j=0;j<classes.size();j++){ //percorre o  conjunto de classes
           for(d=0;d<chield.size();d++){
                  //Verifica a coincidencia do nome da classe do objecto com o nome da classe instanciada
               if(chield.get(d).getClass().getCanonicalName().equals(classes.get(j))){
                  c=1;
                  chield.get(d).setName(classes.get(j).concat("_"+c)); //atribui o nome ao  objecto n�o repetido
               }
               //Passo 3 :se houver pelo menos um objecto
             if(d>0){
                for(k=0;k<d;k++){
                   if(chield.get(d).getClass().getCanonicalName().equals(chield.get(k).getClass().getCanonicalName())){ // caso o objecto j� exista
                      if(chield.get(k).getName().equals(classes.get(j).concat("_")+c)){//se o nome do objecto estiver repetido
                        c+=1; // incrementa esta variavel para atribuir o nome ao novo objecto
                        chield.get(d).setName(classes.get(j).concat("_")+c);// o nome do novo objecto � atribuido com o incremento da variavel "c"
                      }
                   }
                   else if(!chield.get(d).getClass().getCanonicalName().equals(chield.get(k).getClass().getCanonicalName())){
                        chield.get(k).getName().equals(classes.get(j).concat("_")+c);
                   }
                }
             }
           }
        }
     }

      /**
       * Reposiciona os items de categoria do menu, automaticamente quando
       � feito um click sobre o componente
       */
    


    /**
     * retorna o valor definido para o comprimento
     */
  public int Width(){
    return width;
  }

  public void setCommandName(){
      this.setName(this.getName());
  }
  public String getMenuName(){
      return this.getName();
  }
   /**
    * Retorna o nome da classe dos bot�es de Menu
    */

   public String getObjectClass(){
    for(int i=0;i<classes.size()-1;i++){
      strClass=classes.get(i).toString();

    }
     
     return strClass;
   }
   /**
    * Retorna o numero de objectos nesta classe
    */
   public int getObjectInstanceSize(){

       return chield.size();
     }
    
     public void setPack(){

     for(CommandContext E: menuItems){
        if((E instanceof   CommandContext)){
          ((CommandContext) E).getName();
           
        }
       }
      

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
   onde o bot�o seja incerido
   */

  public void setWidth(int width) {
    this.setSize(this.Width(),this.getHeight());
  }
  /**
   * Define apenas a altura  sem necessidade de
   alterar o seu comprimento.
   */

  public void setHeight(int height){
   this.setSize(this.getHeight(),this.Height());
  }

  /**
   * define as dimen��es. Este m�todo esta implicito no construtor,
   no entanto vem tornar possivel, a qualquer momento alterar as dimen��es
   do objecto
   */
  public void setResize(int sizeWidth,int sizeHeight){
     this.setSize(sizeWidth,sizeHeight);
  }



  /**
   * retorna a cordenada x, no componente onde o bot�o se vai posicionar
   */
   public int CordX(){
     return cordX;
   }

   /**
    * retorna a cordenada y , no componente, onde o bot�o se vai posicionar
    */
   public int CordY(){
     return cordY;
   }

   /**
    * posiciona o bot�o nas cordenadas x_y do target
    */
   public void setLocalInTarget(){
     this.setLocation(this.CordX(),this.CordY());
   }
   public void relocalInTarget(){
   }
     public void setGraphics(){
       this.addMouseListener(new MouseAdapter(){
               public void mouseEntered(MouseEvent me){
                ((JPanel)(me.getSource())).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
               }
           });
     }
   
   private void InstallCommands(){
   
       
      // HTarget=getHeight()-60;//altura co contentor - uma valor para um label
      // HPercSector=30;//valor percentual do sector
       //valor percentual do label (a label tem a altura definida de 60)
      // HPercLbl=60*100/getHeight();
       
        //CMDSET FICHEIRO
        strFileHelp="\n"+"Clique em \"Importar \"para fazer a importação do TPL em Excell."
                +"\n"+"Isto vai permitir parametrizar o automatismo da montagem"
                + "dos cartazes para campanha."+"\n"
                +"Clique em \"Exportar\" para criar TPL ou ficheiro excel ou ainda"
                + "um pdf com cartaz para partilhar."+"\n"; 
        
        cmdFileSet=new CommandContext("FICHEIRO",5,60,Width()-10,120);
        cmdImport = new Command("abrir/importar",cmdFileSet.getWidth()-10,35,5,25);
        cmdExport = new Command("exportar",cmdFileSet.getWidth()-10,35,5,61);
         cmdFileSet.InstallComponent(cmdImport);
         cmdFileSet.InstallComponent(cmdExport);
          
        //CMDSET ARTIGOS
       
        strArtHelp="\n"+"Clique em \"Juntar Artigo \"para fazer o registo de novo artigo na Markit."
                +"\n"+"Com esse registo, futuramente pode montar um cartaz isolado ou carregá-lo no "
                + "grupo de cartazes de campanha."+"\n"
                +"Clique em \"Procurar Arigo\" para pequisar qualquer artigo registado na Markit "
                + "para montagem de cartaz isolado ou no grupo de cartazes de campanha."+"\n"; 
        fontMetrics = getFontMetrics(fontText);
        cmdArticleSet =new CommandContext("ARTIGOS",5,199,Width()-10,120);
        cmdJoin = new Command("juntar artigo",cmdFileSet.getWidth()-10,35,5,25);
        cmdSearch = new Command("procurar artigo",cmdFileSet.getWidth()-10,35,5,61);
        cmdArticleSet.InstallComponent(cmdJoin);
        cmdArticleSet.InstallComponent(cmdSearch);
        txtaArtHelp=new JTextArea();
        txtaArtHelp.setFont(fontText);
        txtaArtHelp.setText(strArtHelp);
        txtaArtHelp.setCaretPosition(txtaArtHelp.getText().length());
        txtaArtHelp.setLineWrap(true);
        txtaArtHelp.setWrapStyleWord(true);
        txtaArtHelp.setBounds(5,98,cmdFileSet.getWidth()-10,fontMetrics.getHeight()*10+fontMetrics.getHeight()*txtaArtHelp.getLineCount());
        //fontMetrics.getHeight()*txtaArtHelp.getLineCount()+fontMetrics.getHeight()*txtaArtHelp.getRows()
        JOptionPane.showMessageDialog(null,"Metrics : \n"+ fontMetrics.getHeight()
                +"\n"+"LineCount: "+txtaArtHelp.getLineCount()
                +"\n"+"Rows :"+txtaArtHelp.getRows()
                +"\n"+"Metrics x LineCount + Metrics x Rows :"
                +"\n"+fontMetrics.getHeight()*txtaArtHelp.getLineCount()
                +fontMetrics.getHeight()*txtaArtHelp.getRows(),null,1,null);
        txtaArtHelp.setBackground(Color.darkGray);
        txtaArtHelp.setForeground(Color.lightGray);
        txtaArtHelp.setEditable(false);
        cmdArticleSet.add( txtaArtHelp);
        
        //CMDSET MARKETING
        new CmdHelp("Expandir ajuda");
       cmdManageSet= new CommandContext("MARKETING",5,336,Width()-10,120);
        cmdManage = new Command("gerir",cmdFileSet.getWidth()-10,35,5,25);
        cmdResource = new Command("recursos",cmdFileSet.getWidth()-10,35,5,61);
        cmdManageSet.InstallComponent(cmdManage);
        cmdManageSet.InstallComponent(cmdResource);
       
       
        InstallComponent(cmdFileSet);
        InstallComponent(cmdArticleSet);
        InstallComponent(cmdManageSet);
       
           //PROBLEMA:
            new startsystem.Structure().UpdateCommandContext(cmdManageSet);
        
        setBackground(BackgroundColor());
        setComponentName();
        getObjectInstanceSize();
        setPack();
        getObjectClass();
        setGraphics();
        setResize(width,height);
        setLocalInTarget();
        setOpaque(true);
        setLayout(null);
        setVisible(true);
       // StructComponent();
          
      //cmdFileSet.DefaultHSize();
        
     
   }
   private void InstallComponent(Component c){
       add(c);
     new startsystem.Structure().RecieveComponent(c);
      
       
   }
   
   private void StructComponent(){
         for(int i=0;i<getComponentCount();i++){
            Component c=getComponent(i);
           new startsystem.Structure().RecieveComponent(c);
             
        }
       
   }
   
  
   public int getContent(){
        /**
        * Adiciona os elementos nesta classe ao array
        */
       contentCount=getComponentCount();
       return contentCount;
   }
   private int TxtH(){
       int  h=0;
               return h;
   }
    public Color BackgroundColor() {
        return new startsystem.LoadSettings().readCmdPkColor();
    }
  private class HandleSetByDrag implements MouseMotionListener,MouseListener {
          
           /*
      Para permitir o redimencionamento do componente por arrastamento do 
      mouse.
      Necessita saber o posicionamento do component adjacente.
      Terá que o importar para fazer também o seu reposicionamento
      uma vez que ao arrastar este componente obriga a arrastar o componente
      adjacente. Terá que fazer uma listagem dos componentes existentes na 
      MainWindow e verificar se têm origem nalguma das classes do programa .
      Verificada a classe procura saber qual a localisação do posicionamento do componente
      adjacente (esquerda ,direita, acima, em baixo) . Ao fazer o reposicionamento deste 
      imprlica o reposicionamento de qualquer um que esteja naquelas posições
      */
      
       private Point  pLocalHeight,pLocalWidth,startReLocal,local,startLocal,previousLocal;
       private int compWidth,nextWidth,objPreviousWidth,xWidth,reSizeWidth;
       private int minWidth; //tem de ser convertido do valor percentual
       private int compHeight;
       private int nextHeight;
       private int minHeight;
       private int objPreviousHeight;
       private int  objWidth;
       private int  objHeight;
       private MouseEvent getLocal;
       
//componene seguinte
        private Point pIComp,p; //ponto inicial da posição do componente
        private Point pIHComp;//ponto inicial no fim da altura
        private Point pFWComp; // ponto no final do comprimento
        private Point pFHComp; // ponto no final da altura e comp
        private int compPreviousWidth; // comprimento inicial do componente
        private int wF; // comprimento final do componente
        private int x;
        
        public void mouseDragged(MouseEvent evento) {
            
            pLocalHeight = evento.getPoint();// O mesmo que local
            pLocalWidth = evento.getPoint();
            compWidth = getSize().width;
            compHeight = getSize().height;
            startReLocal =getLocation(startReLocal);
           
            
    //redimenciona de baixo para cima
    if (getCursor().getType() == Cursor.S_RESIZE_CURSOR){
          
            
         }
    
     else if(getCursor().getType() == Cursor.N_RESIZE_CURSOR){
               
     }
   
    }
        
        public void AddToStructure(){
            new startsystem.Structure().getClassObjects();
        }
        public void mouseMoved(MouseEvent me) {
            
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
            else if(pLocalHeight.y <5){
                 setCursor( Cursor.getPredefinedCursor( Cursor.N_RESIZE_CURSOR ));
            }
            else{
              setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
            }
           
        }

       
        public void mouseClicked(MouseEvent e) {
           
        }

        public void mousePressed(MouseEvent evento) {
            local = evento.getPoint();//sim
            getLocal = evento;
          //  startLocal= getLocation();
            objPreviousHeight = getSize().height;
            objPreviousWidth = getSize().width;
           
            
        }
           
        public void mouseReleased(MouseEvent e) {
            
        }

     
        public void mouseEntered(MouseEvent e) {
         }

       
        public void mouseExited(MouseEvent e) {
           
        }
  }
  
  // end methods
  }
 //end class