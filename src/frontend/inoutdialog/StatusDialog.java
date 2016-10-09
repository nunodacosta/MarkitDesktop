/*
Classe para mostrar que uma tarefa se encontra em execução.
Depenedendo da necessidade pode ou não ter uma barra de progresso.
Quando ocorrer e sempre que for detectada uma falha na atribuição do WaitCursor
será disparada a execução deste dialog com a mensagem " Aguarde, por favor!
Quando a tarefa estiver concluida esta janela será desligada."
 */
package frontend.inoutdialog;

import frontend.syscommand.CommandContext;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author nuno
 */
public class StatusDialog extends JDialog implements Runnable{
     public String strMsg;
     
  
  
    
   
     private void Settings(){
          //Caracterizar o dialog  
                //dialogInit();
               setUndecorated(true);  
	       setSize(250,70);
	       setLocationRelativeTo(null);
               setAlwaysOnTop(true);
	       setVisible(true);
              
              addMouseListener(new HandleStatusDialog());
              addWindowListener(new HandleStatusDialog());
     }
     
     public void DisplayOnWaitCursorError(){
         /**
          * Evento a ser disparado quando o cursor Wait não for atribuido
          * Vai verificar o cursor actual
          */
     }
   
     
    
   
    public void run() {
        
             Settings();
             dispose();
             

    }
    private  class HandleStatusDialog implements MouseListener,WindowListener{

      
        public void mouseClicked(MouseEvent me) {
           dispose();
           
        }

      
        public void mousePressed(MouseEvent me) {

        }

    
        public void mouseReleased(MouseEvent me) {
          
        }

       
        public void mouseEntered(MouseEvent me) {
         
        }

     
        public void mouseExited(MouseEvent me) {
     
        }

        
        public void windowOpened(WindowEvent we) {
         
        }

     
        public void windowClosing(WindowEvent we) {
            dispose();
        }

    
        public void windowClosed(WindowEvent we) {
          
        }

       
        public void windowIconified(WindowEvent we) {
           
        }

      
        public void windowDeiconified(WindowEvent we) {
         
        }

    
        public void windowActivated(WindowEvent we) {
           
        }

      
        public void windowDeactivated(WindowEvent we) {
           
        }
    
}
    
    
}
