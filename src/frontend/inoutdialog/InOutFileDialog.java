/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.inoutdialog;

/**
 *
 * @author pd-sta-mkt
 */

import java.awt.Color;
import java.io.File;
import javax.swing.JDialog;
//from  w  w  w  . j  av a  2  s.co m
import javax.swing.JFileChooser;
public class InOutFileDialog extends JFileChooser{
    public InOutFileDialog(){
        
    JDialog fileBrowser = new JDialog();
    fileBrowser.setUndecorated(true);
    }
  public static void FileDialog() {
    // Display an open file chooser

  
  //  fileChooser.setOpaque(false);
    
   // int returnValue = fileChooser.showOpenDialog(null);

  //  if (returnValue == JFileChooser.APPROVE_OPTION) {
    //  File selectedFile = fileChooser.getSelectedFile();
    //  System.out.println("we selected: " + selectedFile);
      
    }

  }
