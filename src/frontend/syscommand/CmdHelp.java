/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.syscommand;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author nuno
 */
public class CmdHelp extends JLabel {
    
    public CmdHelp(){
        super("Ajuda");
        this.setFont(new Font("Segoe Ui Light", Font.PLAIN,10));
    }
    public CmdHelp(String strTxt){
        super(strTxt);
        
        this.setFont(new Font("Segoe Ui Light", Font.PLAIN,10));
    }
    private class HandleCmdHelp implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
