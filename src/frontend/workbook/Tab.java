package frontend.workbook;

import frontend.syscommand.CommandContext;
import frontend.syscommand.ContextPlaceHolder;
import frontend.MenuItem;
import frontend.system.MainWindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class Tab extends JPanel {

    private final int wSizeAsMin = frontend.system.MainWindow.cmdPack.getWidth() - 10;//tamanho minimo da aba em comprimento 
    private final int hSizeAsMin = 60;//tamanho minimo da aba em altura
// start attributes

    public static int width;
    public static int height;
    public static int cordX;
    public static int cordY;
    public static int R;
    public static int G;
    public static int B;

    public static CommandContext objScn;
    public static Color darkGradient;
    public static Color lightGradient;
    public static Color initColor;
    public static Color onClickColor;
    public static Color pressedColor;
    public static Color onOverColor;
    public static Color initLineColor;
    public static Color borderColor;
    public static Color textColor;
    public static JLabel lblTab;
    public static String strName;
    public static String strChieldClass;
    public static String strClassName;
    public static String strText;
    public static String strChieldReference;
    public static String strChieldName;
    public static Border tabBorder;
    public static Border buttonLineBorder;
    public static Border separatorBorder;
    public static JLabel lblButtonTextModels;
    public static JLabel lblButtonTextQuery;
    public static JLabel lblButtonTextSetNew;
    public static JLabel lblButtonText;

    public static Point midleFont;
    public static Point midleButton;
    public static TabSet pageTaber;
    private static ContextPlaceHolder sideMenu;
    public static FontMetrics fontMetrics;
    public static Font fButtonText;
    public static MenuItem itemNovo;
    public static Component sideMenuComp;
    public static Component btnMenuItem;
    public static Component itemScn;
    public static int i;
    public static String btnText;
    public static MainWindow formWindow;
    public static Event evt;
    public static MouseEvent me;
    public static TabSet pagePanel;
    public static ArrayList<JLabel> menuItem = new ArrayList<JLabel>();
    public static ArrayList<String> categoryItem = new ArrayList<String>();
    public static ArrayList<Object> TabObject = new ArrayList<Object>();
    public String strPageModels;
    public String strPageQuery;
    public String strPageSetNew;
    public String strTabModels;
    public String strTabQuery;
    public String strTabSetNew;
    public JLabel lblOnOver;
    public JLabel lblOnClick;
    public static String strTab;
    public static Font fontTab;
    public static FontMetrics fMetrics;
 public ArrayList<Component> allcomp=new ArrayList <Component>();
 public ArrayList<String> classes=new ArrayList <String>();
private ArrayList <String> strCh=new ArrayList <String>();
  // end attributes
    //Cocnstrutor
    public Tab(String varText, int varCordX, int varCordY, int varWidth, int varHeight) {
        super();
        //  this.setPagePanel(varPageTab);
        strTab = varText.toUpperCase();
        cordX = varCordX;
        cordY = varCordY;
        width = varWidth;
        height = varHeight;
        Settings();
        Pack();
       // getObject();
       // ObjectCount();
        //setObjectName();
        addMouseListener(new HandleTab());
    }
     private Component getObject(){
         Component compobj=null;
         for(int i=0;i<getParent().getComponents().length;i++){
             if(getParent().getComponent(i).getClass().getSimpleName().equals(getClass().getSimpleName()))
               compobj=getParent().getComponent(i);
             
             }
         return  compobj;
     }
     
     private int ObjectCount(){
         int countObj=0;
         Component compobj=null;
         for(int i=0;i<getParent().getComponents().length;i++){
             if(getParent().getComponent(i).getClass().getSimpleName().equals(getClass().getSimpleName()))
              countObj +=1;
             }
         return countObj;
     }
     
     private void setObjectName(){
         if(getObject().getName()==null){
             getObject().setName(getClass().getSimpleName()+ObjectCount());
         }
        
     }
    private void Pack() {
       
        int v, j, k;
        int order=0;
       
        int nobj = 0;
        int strSize;
        String strClass;
        String strOrder;
        String strName;
        String strPrefix="";
        int strSufix;
        char []ch;
        
        Component cp;
        for (Component C : getComponents()) {
            order +=1;
            //adiciona o componente ao array caso nao exista e o mesmo para a classe do componente 
            if (!allcomp.contains(C)) {
                allcomp.add(C);
                strClass = C.getClass().getSimpleName();
                if (!classes.contains(strClass)) {
                    classes.add(strClass);
                }
            } 
            if(C.getName()==null){
                C.setName(C.getClass().getSimpleName()+order);
            }
               
        }
        
    }
    public Tab(String varText) {
        super();
       
        strTab = varText.toUpperCase();

        setSize(width, height);
        setLocation(cordX, cordY);
        InitComponents();
        setFont();
        pressedColor = BorderColor();
        initColor = setColor(85, 94, 102);
        onOverColor = setColor(48, 57, 66);
//        onClickColor=formWindow.pnlModels.getBackground();
        initLineColor = setColor(176, 196, 222);

        tabBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, BorderColor()); //topo,esquerda,baixo,direita

        setTabName();

        setBorder(tabBorder);

        setResize(width,height);

        setLayout(null);
     
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        this.setBackground(MainWindow.pnlModels.getBackground());
        this.setLayout(null);
        this.setVisible(true);
        addMouseListener(new HandleTab());
    }
    
    public Tab(){
        super();
        strTab="";
    }
    
    private void Settings(){
        setSize(width, height);
        setLocation(cordX, cordY);
        InitComponents();
        setFont();
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pressedColor = BorderColor();
        setBackground(BackColor());
        onOverColor = setColor(48, 57, 66);
        initLineColor = setColor(176, 196, 222);
        tabBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, BorderColor()); //topo,esquerda,baixo,direita
        setTabName();
        setBorder(tabBorder);
        setResize(width,height);
        setLayout(null);
        setOpaque(true);
        setLayout(null);
        setVisible(true);
    }
    public Tab(String varText, int varCordX, int varCordY) {
        super();
        strTab = varText.toUpperCase();
        cordX = varCordX;
        cordY = varCordY;
        InitComponents();
        setFont();
        pressedColor = BorderColor();
        initColor = setColor(85, 94, 102);
        onOverColor = setColor(48, 57, 66);
        initLineColor = setColor(176, 196, 222);
        tabBorder = BorderFactory.createMatteBorder(1, 1, 0, 1, BorderColor()); //topo,esquerda,baixo,direita
        setTabName();
        setBorder(tabBorder);
        setResize(width,height);
        setLayout(null);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(null);
        setVisible(true);
        addMouseListener(new HandleTab());
    }

  // start methods
    /**
     * retorna o valor definido para o comprimento
     */
    public int R() {
        for (int r = 0; r <= 255; r++) {
            R = r;
        }
        return R;
    }

    public int G() {
        return G;
    }

    public int B() {
        return B;
    }

    public int Width() {
        return width;
    }

    public void setTabName() {
        this.setName(this.getClass().getSimpleName().concat(lblTab.getText()));
    }

    public String getTabName() {
        return this.getName();
    }

    /**
     * Retorna o texto mostrado identificador da categoria do menu
     */
    public String getTabText() {
        return lblTab.getText();
    }

    /**
     * retorna o valor definido para a altura
     */
    public int Height() {
        return height;
    }

    /**
     * Define apenas o comprimento do botão sem necessidade de alterar a sua
     * altura. Util para o redimencionamento do componente onde o bot�o seja
     * incerido
     */
    public void setWidth(int width) {
        this.setSize(this.Width(), this.getHeight());
    }

    /**
     * Define apenas a altura do botão sem necessidade de alterar o seu
     * comprimento. Util para o redimencionamento do componente onde o botão
     * seja incerido
     */
    public void setHeight(int height) {
        this.setSize(this.getHeight(), this.Height());
    }
  
    /**
     * Define as dimenções do componente. O incremento é feito pela soma das
     * alturas recebidas pelo numero de items existentes dentro do componente
     */
    public void setResize(int sizeWidth, int sizeHeight) {
        this.setSize(sizeWidth, sizeHeight);
    }
    
    private void InitComponents(){
          lblTab = new JLabel(strTab);
          add(lblTab);
      JPanel p=new JPanel();
      add(p);
      JLabel l=new JLabel();
      add(l);
       JLabel l1=new JLabel();
      add(l1);
    }
    public  void setFont() {
        
        lblTab.setVisible(true);
        lblTab.setForeground(Color.WHITE); //cor do texto
        fontTab = new Font("Futura MD BT", Font.PLAIN, 14);//propriedades da fonte
        fontMetrics = getFontMetrics(fontTab);
        fontMetrics.stringWidth(strTab);//o comprimento do texto definido
        lblTab.setSize(fontMetrics.stringWidth(strTab), fontMetrics.getHeight());// o tamanho da Label que contem o texto
        lblTab.setFont(fontTab);//atribui a fonte ao texto do Label

        lblTab.setLocation(getSize().width / 2 - lblTab.getSize().width / 2, this.getSize().height / 2 - lblTab.getSize().height / 2);
        
        
    }

    public static void setTabText(String strTab) {

        lblTab.setText(strTab.toUpperCase());

    }
    
    
    
    public int CordX() {
        return cordX;
    }

    /**
     * retorna a cordenada y , no componente, onde o objecto se vai posicionar
     */
    public int CordY() {
        return cordY;
    }

    /**
     * posiciona o objecto nas cordenadas x_y do target
     */
    public Color getColor(Color color) {
        return color;
    }

    public static void onLoadStatus() { // M�todo a ser chamado pelo metodo Main em FormApp
      /*Para melhorar este m�todo:
         fazer a contagem dos objectos na classe de destino;
         importar essa contagem para esta classe;
         criar um ciclo em que para cada objecto que n�o tenha o nome
         do objecto seleccionado, atribuir o background com a cor initColor;
         Se o nome do objecto corresponder ao nome do objecto seleccionado,
         ent�o atribuir o Background com onClicColor.

         Com este pseudo-codigo permite rapidamente fazer interven��o em um
         numero infinito de objectos criados
         */

    }

    public Color setColor(int R, int G, int B) {
        Color color = new Color(R, G, B);
        return color;
    }

    public Color getColor() {
        return this.getBackground();
    }

    public Color BorderColor() {
        return new startsystem.LoadSettings().readTabBorderColor();
    }

    public Color BackColor() {
        return new startsystem.LoadSettings().readTabBackColor();
    }
    
    public Color OnClickColor(){
        return new startsystem.LoadSettings().readClickTabColor();
    }

    // end methods
    private class HandleTab implements MouseListener {
        private String strClassOwner = getClass().getDeclaringClass().getSimpleName(); // o nome da classe a que esta pertence
        private String strParentName,strTName,strTabText;// o nome simples da classe que contem
        private Component comp,target;// o componente no parent esperado como obejecto desta classe
        private Object obj; // este objecto
        private int iter,x,y,w,h,i,k;
        private Tab tab,srcTab;
        private ArrayList<String> classes = new ArrayList<String>();
        private ArrayList<Component> componentTabs = new ArrayList<Component>();
        private ArrayList<String> tabName = new ArrayList<String>();
         private ArrayList<String> tabText = new ArrayList<String>();
        private ArrayList<Object> objectAdded = new ArrayList<Object>();
        private ArrayList<Tab> objTab = new ArrayList<Tab>();
        private ArrayList<Component> parent = new ArrayList <Component>();
        private ArrayList<Component> compObj=new ArrayList <Component>();
       
        private Component c;
        
       
        private Color reSetBackColor(){
         return new startsystem.LoadSettings().readTabBackColor();
        }
       
        private Color setOnColor(){
         return new startsystem.LoadSettings().readBookColor();
        }
        
     
         
        private void getObjectInParent(){
          
            reSetFont();
            /*
            Recolhe e agrupa para futuro acesso todos os objectos provenientes
            da classe Tab.
            Antes de agrupar avalia se o elemento em causa já existe na lista 
            para acesso
            */
                for (Component C:getParent().getComponents()){
                    if(C.getClass().getSimpleName().equals(getClass().getDeclaringClass().getSimpleName())){
                        tab=(Tab)C;
                        
                        if (!objTab.contains(tab)){
                            objTab.add(tab);
                        }
                        if(!tabName.contains(tab.getTabName())){
                            tabName.add(tab.getName());
                        }
                        if(!tabText.contains(tab.getTabText())){
                           tabText.add(tab.getTabText());
                           
                            
                           
                        }
                        
                    }
                }
        }
         
     public void mouseClicked(MouseEvent me) {
             /*altera o valor y para a tab clicada e reposiciona a 
                     tab tabsetpack todas as outras para valores iniciais
             1-varredura da classe onde existe objecto proveniente da ownerclass
                 1.1 obter todos os componentes da classe anfitriã e verificar se a
                 proveniencia se é da classe owner. 
                Como o aesso á classe dos objectos a agir é a ownerclass desta
                inerclass vamos fazer a comparação das classes de proveniencia:
                expressão: comp.getClass().getSimpleName().equals(getClass().getDeclaringClass().getSimpleName())
               */
            
             // 
           
             //procurar objectos nas classes de destino e compara as suas proveniencias
            getObjectInParent();
            for (int i=0; i<objTab.size();i++){
               srcTab=objTab.get(i);
               strTName=tabName.get(i);
               
//             strTabText=tabText.get(i);
            
  // final int  x=srcTab.getLocation().x;
  // final int  y=srcTab.getLocation().y;
               if(me.getSource().hashCode()==srcTab.hashCode()){
                    
                     if(srcTab.getTabName().equals(strTName)){
                        
                         srcTab.setBackground(OnClickColor());
                         if(srcTab.getTabText().equalsIgnoreCase("inicio")){
                              JOptionPane.showMessageDialog(null,srcTab.getTabName(),null,1,null); 
                           
                           JOptionPane.showMessageDialog(null,srcTab.getTabText(),null,1,null); // resultado é sempre    
                         }
                     }
                    
           
                  //reset a todos os outros tab
               }
               if (! (me.getSource().hashCode()==srcTab.hashCode())){  
                   srcTab.setBackground(new startsystem.LoadSettings().readTabBackColor());
                   
                }
            }
        }

        private void reSetFont(){
            int i=0;
            Component c=null;
            Object o=null;
           for(k=0;k<allcomp.size();k++){
               c=allcomp.get(k);
               o=c;
               /* 
               if(c.getClass().getSimpleName().equals("JLabel")){
                   
               }
              */
                JOptionPane.showMessageDialog(null,c.getName()+"em:"+allcomp.size(),null,1,null); 
           }
          
        }
        public void mousePressed(MouseEvent me) {

        }

        public void mouseReleased(MouseEvent me) {

        }

        public void mouseEntered(MouseEvent me) {
            
            /*altera a apresentação do texto da Tab
             1-varredura da classe onde existe objecto proveniente da ownerclass
                 1.1 obter todos os componentes da classe anfitriã e verificar se a
                 proveniencia é da classe owner. 
                Como o aesso á classe dos objectos a agir é a ownerclass desta
                inerclass vamos fazer a comparação das classes de proveniencia:
                expressão: comp.getClass().getSimpleName().equals(getClass().getDeclaringClass().getSimpleName())
            
               */
         
               for(Tab E: objTab ){
                   for(String S: tabText){
                    if((E instanceof  Tab)&(S instanceof String)){
                     //Se o componente  for o mesmo onde está o mouse
                         if (me.getSource().hashCode()==((Tab) E).hashCode()& S.equals(E.getTabText())){
                             ((Tab) E).lblTab.setText("<html><u><font color='#ffffff'>" + strTab + "</font></u></html>");
                          
                         }
                     }
                   }
               }   
        }
        public void mouseExited(MouseEvent me) {
            lblTab.setText(strTab);
        }

    }
} //end class
