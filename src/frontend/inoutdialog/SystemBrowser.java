/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frontend.inoutdialog;

import javax.swing.JFileChooser;

public class SystemBrowser {
    
   
    public static void BrowseTo(){
    JFileChooser arquivo = new JFileChooser();
    arquivo.showOpenDialog(null);
    }
   
}

