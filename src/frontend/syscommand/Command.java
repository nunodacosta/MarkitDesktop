
package frontend.syscommand;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author pd-sta-mkt
 */
public class Command extends JButton{
   private String strFrontLabel;
   private int w,h,x,y,sW,sH;
   private final String strID="";
   
    public Command(){
        
        super.setUI(new frontend.syscommand.CmdTrigerUI());
        setDefaultSize();
    }
      public Command(String varStrFrontLabel, int varW,int varH){
        super.setUI(new frontend.syscommand.CmdTrigerUI());
        strFrontLabel=varStrFrontLabel;
        setFrontLabel();
        w=varW;
        h=varH;
        setSize(w,h);
    }
    public Command(String varStrFrontLabel, int varW,int varH,int varX,int varY){
        super.setUI(new frontend.syscommand.CmdTrigerUI());
        strFrontLabel=varStrFrontLabel;
        setFrontLabel();
        w=varW;
        h=varH;
        x=varX;
        y=varY;
        setLocation(x,y);
        setSize(w,h);
    }
    public Command(String varStrFrontLabel){
        super.setUI(new frontend.syscommand.CmdTrigerUI());
        strFrontLabel=varStrFrontLabel;
        setFrontLabel();
    }
    
    private void setFrontLabel(){
        super.setText(strFrontLabel);
    } 
    private int setDefaultWidth(){
        return w=getParent().getSize().width/2;
    }
    
     private int setDefaultHeight(){
        return h=getParent().getSize().height/2;
    }
     private void setDefaultSize(){
         super.setSize(setDefaultWidth(),setDefaultHeight());
     }
     
  
    
     private void setDefaultName(){
         /**
          * em Parent averigua se há componentes provenientes
          * desta classe.Se houver numera-os e atribui o nome
          * juntando o nome desta classe mais o numero de ordem
          * na classe parente
          * Terá de agrupar as classes parentes em array bem  como
          * os componentes dessas classes que provenham desta
          */
     }
     private void setID(){
         /*
         String ID será o nome da classe parente mais o
          nome deste componente com o numero de ordem
         e este é inalteravel -> é final
         */
     }
     /*
     private final String getID(){
     }
     */
     private class HandleCmd implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
    
}
