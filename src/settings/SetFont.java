/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.File;

import java.io.IOException;
import java.io.FileInputStream;
/**
 *
 * @author nuno
 */
public class SetFont {
    
     public static Font fTitle;
     private static String systemDir=System.getProperty("user.dir");
     final static String fontName="FuturaTEE.ttf";
     
     public static Font EmbFont(){
                                      
      try {
          File fontFile= new File(systemDir.concat("\\resource\\fonts\\".concat(fontName)));
          FileInputStream is= new FileInputStream(fontFile);
          GraphicsEnvironment ge;
          ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

          fTitle = Font.createFont(Font.TRUETYPE_FONT, is);
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, is));
         
      
        
      } catch (FontFormatException e) {
      } catch (IOException e) {
      }
     return fTitle.deriveFont(26f);
  }
     
    
}
