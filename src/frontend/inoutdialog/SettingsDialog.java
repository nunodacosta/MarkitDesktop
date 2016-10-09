/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.inoutdialog;

import frontend.syscommand.CommandContext;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author nuno
 */
public class SettingsDialog extends JDialog {
       private static MouseEvent getLocal;
       private Component comp;
       private static Point local;
       private static CommandContext cmdFechar;
       private final static String strTitle="Definições";
       private static JLabel lblTitle=new JLabel(strTitle);
       private static Font fTitle;
       private static FontMetrics fontMetrics;
       private static JPanel pnlHandleBar; 
       private static Container ctnCompn;
       public static String strDisplay;
       public static String strJob="-a definir";
       public static Border barBorder;
        public static Border bodyBorder;
       public static Color borderColor;
        public static JPanel pnlMain;
       public SettingsDialog(){
           
        ctnCompn=getContentPane();
        ctnCompn.setBackground(new Color(119, 136, 153));
        ctnCompn.setLayout(null);
     //Caracterizar o frame  
                 borderColor=setColor(130,130,130);
                 barBorder = BorderFactory.createMatteBorder(1,1,0,1,borderColor);
                bodyBorder = BorderFactory.createMatteBorder(0,1,1,1,borderColor);
                //borderColor=setColor(66, 76, 85);
		setUndecorated(true);     
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseListener(new HandleSettingsDialog());//atribui acçao do mouse quando percorre o corpo da janela
		pnlHandleBar=new JPanel();
                pnlHandleBar.setBorder( barBorder);
                pnlHandleBar.setBackground(Color.black);
                pnlHandleBar.setSize(500,30);
                pnlHandleBar.setLayout(null);
                
                pnlMain=new JPanel();
                pnlMain.setBounds(0, pnlHandleBar.getHeight(),this.getWidth(),this.getHeight()-pnlHandleBar.getHeight());
                //pnlMain.setBackground(Color.CYAN);
                pnlMain.setBorder(bodyBorder);

                add(pnlHandleBar);
                add(pnlMain);
		
	 //Permitir que a janela possa ser arrastada pelo mouse    
        pnlHandleBar.addMouseListener( new HandleSettingsDialog() );
        pnlHandleBar.addMouseMotionListener( new HandleSettingsDialog() );	
//        cmdFechar.addActionListener(this);
        
            CenterTitle();
       }
        public Color setColor(int R,int G,int B){
           Color color=new Color(R,G,B);
           return color;
        }
        private void CenterTitle(){
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
     
        public static String updateTitle(){
        /* 
        Método para atribuir o titulo mostrado na barra de titulo
        Útil para mostrar o trabalho em curso quando ocupar várias 
        fases ex. " SinInput- trbalho a decorrer"
        */
        return lblTitle.getText().concat(strJob);
    }
         public int getTextWidth(){
         return lblTitle.getSize().width;
  }
  
    public int getTextHeight(){
     return lblTitle.getSize().height;
  }
    class HandleSettingsDialog implements MouseListener, MouseMotionListener,ActionListener{
        public void mouseEntered(MouseEvent e){
             for(int i=0; i<getContentPane().getComponents().length;i++){
              comp=getContentPane().getComponent(i);
              if(e.getSource().hashCode()==comp.hashCode()){
                  setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
               } 
             }
        }
        public void mouseExited(MouseEvent evento) {
           
            setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
          
        }	
        public void mouseMoved(MouseEvent e){}
        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent evento) {}
        //acção a adicionar ao botão
        public void actionPerformed(ActionEvent evento){
                    if(evento.getSource()==cmdFechar){
                            System.exit(0);
                    }	
            }
        public void mousePressed(MouseEvent evento){ 
           //posiçao do mouse                                  
              getLocal = evento;
        }
        public void mouseDragged(MouseEvent evento){
          //deslocação da janela
                 local = getLocation(local);
                 int x = local.x - getLocal.getX() + evento.getX();
                 int y = local.y - getLocal.getY() + evento.getY();
                 setLocation(x, y);
        }
     }
}
