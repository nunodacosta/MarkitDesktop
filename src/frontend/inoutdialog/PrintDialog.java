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
 * @author pd-sta-mkt
 */
public class PrintDialog extends JDialog {
    
    public static int posX,posY;
    public static Container ctnCompn;//contentor de paineis
    public static JPanel pnlHandleBar;
    public static Point local;
    public static MouseEvent getLocal;
    public static CommandContext cmdFechar;
    private final static String strTitle="Input";
    public static JLabel lblTitle=new JLabel(strTitle);
    public static Font fTitle;
    public static FontMetrics fontMetrics;
    public static String strJob="- trabalho a realisar";
    public static String strDisplay;
    private Component comp;
    public PrintDialog() {
    	

        ctnCompn=getContentPane();
        ctnCompn.setBackground(new Color(119, 136, 153));
        ctnCompn.setLayout(null);
     //Caracterizar o frame  
		setUndecorated(true);     
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseListener(new HandlePrintDialog());//atribui acçao do mouse quando percorre o corpo da janela
		pnlHandleBar=new JPanel();
                pnlHandleBar.setBackground(Color.black);
                pnlHandleBar.setSize(500,30);
                pnlHandleBar.setLayout(null);
                
                add(pnlHandleBar);

		
	 //Permitir que a janela possa ser arrastada pelo mouse    
        pnlHandleBar.addMouseListener( new HandlePrintDialog() );
        pnlHandleBar.addMouseMotionListener( new HandlePrintDialog() );	
//        cmdFechar.addActionListener(this);
        
            CenterTitle();

    }
    private  void getComponentsIn(){
         
    }
    public static String updateTitle(){
        /* 
        Método para atribuir o titulo mostrado na barra de titulo
        Útil para mostrar o trabalho em curso quando ocupar várias 
        fases ex. " SinInput- trbalho a decorrer"
        */
        return lblTitle.getText().concat(strJob);
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

    class HandlePrintDialog implements MouseListener, MouseMotionListener,ActionListener{
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


