/*
Irá receber objectos de commandpack
Cria objectos de commandset na mainwindow
*/

package frontend.syscommand;


import frontend.syscommand.CmdTriger;
import frontend.system.HandleBar;
import frontend.system.MainWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;



public class CmdSet extends JPanel{
  // start attributes
    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static int i,c,d,j,k,n,y,m,l,o,p;
    public static Color darkGradient;
    public static Color lightGradient;
    public static MainWindow formWindow;
    public static HandleBar logoBar;
    public static CmdTriger cmdFileSet;
    public static CmdTriger cmdArticleSet;
    public static CmdTriger cmdManageSet;
    public static CmdTriger cmdImport;
   // public static CommandTriger cmdImport;
    public static CmdTriger cmdExport;
 
    public static CmdTriger cmdJoin;
    public static CmdTriger cmdSearch;
 
    public static CmdTriger cmdNWork;
    public static CmdTriger cmdResource;
     public static CmdTriger cmdInDrive;

    public static Component compChield;
    public static Component compValue;//refere qualquer componente do menu, nesta classe
    public static Component compObject;//refere qualquer componente nesta classe
    public static Object objChield;
    public static Object objectMenu;//refere qualquer objecto do menu, nesta classe
    public static Object objectInstance;
    public static String strClassName;
    public static String strChieldName;
    public static ArrayList<String>classes= new ArrayList<String>();
    public static ArrayList<Component>chield= new ArrayList<Component>();
    public static ArrayList<Object> objectItem =new ArrayList<Object>();
    public static ArrayList<CmdTriger> menuItems =new ArrayList<CmdTriger>();
    public static String strClass;
 
   public static CmdHolder holderIOF;
     public static CmdHolder holderIOF2;
  // end attributes

  //Construtor
    public CmdSet(){

    }
    public CmdSet(MainWindow varFormWindow,int varCordX,int varCordY,int varWidth,int varHeight){
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
        setCommands();
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
      public void setCmdStand(){

            /*M�todo: percorrer o vector de objectos e seleccionar os
              que s�o categorias do menu ( o objectivo � n�o ter que escrever o
              nome nem dos objectos nem das categorias)
            */
             /*
            for (y=0;y<chield.size();y++){
                   if(y>0){//se houver objectos na classe
                     CmdTriger compY=category.get(y);
                     CmdTriger compM=category.get(m);

                       for(m=0;m<y;m++){
                           if(compY.getClass().getCanonicalName().equals(compM.getClass().getCanonicalName())){
                               compM.setSize(compM.getWidth(),compM.getHeight()*2);
                               compY.setLocation(compM.getX()+compM.getWidth(),compY.getY());
                               System.out.println(compY.getName());
                               System.out.println("Componente 1:"+compM.getName());//Componente 1, o primeiro do vector
                           }
                       }
                   }
              }
              */
       }


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
     
     /**
     * Define a colec��o de items de Menu
     */
     public void setPack(){

     for(CmdTriger E: menuItems){
        if((E instanceof   CmdTriger)){
          ((CmdTriger) E).getName();
           
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
                         cmdExport.setBackground(CmdTriger.initColor);
                     
                         cmdJoin.setBackground(CmdTriger.initColor);
                         cmdSearch.setBackground(CmdTriger.initColor);
                        
                         cmdNWork.setBackground(CmdTriger.initColor);
                         cmdResource.setBackground(CmdTriger.initColor);
                       
                      
               }

           });
     }
   public void setCommands(){
       

        //CMDSET FICHEIRO
        cmdFileSet=new CmdTriger("FICHEIRO",5,1,Width()-10,60);
        cmdFileSet.setBackground(new Color(66, 78, 85));

        cmdImport=new CmdTriger("IMPORTAR",5,68,Width()-10,30);
        cmdExport=new CmdTriger("EXPORTAR",5,99,Width()-10,30);
        
        //CMDSET ARTIGOS
        cmdArticleSet =new CmdTriger("ARTIGOS",5,135,Width()-10,60);
        cmdArticleSet.setBackground(new Color(66, 78, 85));
        cmdJoin=new CmdTriger("JUNTAR",5,201,Width()-10,30);
        cmdSearch=new CmdTriger("PROCURAR",5,232,Width()-10,30);
        
        //CMDSET MARKETING
         cmdManageSet= new CmdTriger("MARKETING",5,268,Width()-10,60);
         cmdManageSet.setBackground(new Color(66, 76, 85));
         cmdNWork=new CmdTriger("AGENDA",5,334,Width()-10,30);
         cmdResource=new CmdTriger("RCURSOS",5,365,Width()-10,30);
        
         cmdInDrive=new CmdTriger("INSTALAR",5,433,Width()-10,30);
          //  holderIOF=new CmdHolder("set de 2 comd",5,560,Width()-10,60);
         holderIOF=new CmdHolder("set de 2 comd",5,470,Width()-10,60);
         holderIOF.UpdateOutText("updated");
         
          holderIOF2=new CmdHolder("set 2 de 2 comd",5,533,Width()-10,60);
         holderIOF2.UpdateOutText("updated2");

        add(cmdFileSet);
        add(cmdImport);
        add(cmdExport);
      
        add(cmdArticleSet);
        add(cmdJoin);
        add(cmdSearch);
        
        add(cmdManageSet);
        add(cmdNWork);
        add(cmdResource);
        
        add(cmdInDrive); 
        add(holderIOF);
        //add(holderIOF2);
        
        setBackground(BackColor());
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


   }
   
    public Color BackColor() {
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