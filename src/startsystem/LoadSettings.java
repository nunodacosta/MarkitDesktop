/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startsystem;

import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import settings.Settings;
/**
 *
 * @author nuno
 */
public class LoadSettings {
     private String sep=System.getProperty("file.separator");
    private String fileSet=sep.concat(sep).concat("settings"); // directorio de definições
    private String extArqSet=".ms";// extenção do arquivo (markit settings)
    private String arqSet=sep.concat(sep).concat("skin").concat(extArqSet);// nome do arquivo (settings)
    public String userHomeDir = System.getProperty("user.dir"); // directorio do sistema
    private File dirSet = new File(userHomeDir.concat(fileSet)); // onde será guardado o arquivo
    FileInputStream fin,finf,finCmdF,finBound,finMBack,fisBColor,finClickTabColor,finCmdStartColor;
    ObjectInputStream ois,oisf,oisCmdF,oisBound,oisMBack,oinBColor,oisClickTabColor,oisCmdStartColor;
    private static Color flatColor,backColor,boundColor,mainBColor,bookBColor,stdTabColor,onClickTabColor,cmdStartColor;
    private int R,G,B,cR,cG,cB,Rf,Gf,Bf;
    private Settings ms,msf,msCmdF,msBound,msMBack,msetBColor,msClickTabColor,msCmdStartColor;
    
    public LoadSettings(){
        readTabBorderColor();
        readTabBackColor();
        readCmdPkColor();
     //   readBookBackColor();
        readBoundColor();
        readMainBackColor();
    }
           public Color readTabBorderColor(){
            try{
                fin=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                ois=new ObjectInputStream(fin);
                ms=(Settings)ois.readObject();
       
                 R=ms.R;
                 G=ms.G;
                 B=ms.B;
             
            }
            catch( Exception e){
                e.printStackTrace();
            }
          return new Color(R,G,B);
          
        }
              
        public Color readTabBackColor(){
            try{
                finf=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisf=new ObjectInputStream(finf);
                msf=(Settings)oisf.readObject();
       
               //  Rf=msf.Rflat;
               //  Gf=msf.Gflat;
               //  Bf=msf.Bflat;
                stdTabColor=msf.StandTabColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          //return new Color(Rf,Gf,Bf);
            return stdTabColor;
        }
         public Color readCmdPkColor(){
            try{
                finCmdF=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisCmdF=new ObjectInputStream(finCmdF);
                msCmdF=(Settings)oisCmdF.readObject();
       
                 flatColor=msCmdF.FlatColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return flatColor;
        }
         
            public Color readBoundColor(){
            try{
                finBound=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisBound=new ObjectInputStream(finBound);
                msBound=(Settings)oisBound.readObject();
       
                 boundColor=msBound.BoundColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return boundColor;
        }
            
        public Color readMainBackColor(){
            try{
                finMBack=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisMBack=new ObjectInputStream(finMBack);
               msMBack=(Settings)oisMBack.readObject();
       
                mainBColor=msMBack.MainBackColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return mainBColor;
        }
        
         public Color readBookColor(){
            try{
                fisBColor=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oinBColor=new ObjectInputStream(fisBColor);
               msetBColor=(Settings)oinBColor.readObject();
       
                //bookBColor=msetBColor.WorkBookColor();
              bookBColor=msetBColor.StandBookColor();
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return bookBColor;
        }
         
          public Color readClickTabColor(){
            try{
                finClickTabColor=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisClickTabColor=new ObjectInputStream(finClickTabColor);
                msClickTabColor=(Settings)oisClickTabColor.readObject();
       
                 flatColor=msClickTabColor.OnClickTabColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return flatColor;
        }
          
            public Color readCmdStartColor(){
            try{
                finCmdStartColor=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                oisCmdStartColor=new ObjectInputStream(finCmdStartColor);
                msCmdStartColor=(Settings)oisCmdStartColor.readObject();
       
                 cmdStartColor=msCmdStartColor.CmdStartColor();
              
            }
            catch( Exception e){
                e.printStackTrace();
            } 
          return cmdStartColor;
        } 

}
