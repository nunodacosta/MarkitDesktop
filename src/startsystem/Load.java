package startsystem;


import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.HWND;
import frontend.system.MainWindow;
import startsystem.Structure;
import frontend.workbook.Tab;
import settings.Settings;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.net.*;


import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.ImageIcon;
 import java.awt.*;
import java.util.Map;
import java.util.Properties;
import javax.swing.*;
import settings.Instance;

import frontend.system.MainWindow;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import startsystem.status.InstanceLog;
import log.JLog;

  public class Load {
      
      public static  Process winStarter;
      static int port=1010;
      
      public Load() throws IOException{
          
        new startsystem.status.InstanceLog();    
        
     // Serial da máquina
        new system.scripts.GetID();
      
         new Instance().SaveOnExit();
       new Instance().ReadOnLoad();
        
          String user=System.getProperty("user.name");
          String strJreDir="jre";
          String strSep=System.getProperty(("file.separator"));
          String sysDir=System.getProperty("user.home",".");
          String name="Marketing";
          String strEscrit="system";
          String JVersion = System.getProperty("java.version");
          String baseDir=System.getProperty("user.dir");
          String strJre = baseDir.concat(strSep).concat(strJreDir);
          String strSelfJre = System.setProperty("mjrun.self",strJre);// jre da aplicação
          String strSOJre=System.getProperty("java.home"); // Jre da máquina
         
          // IfRunning();
          System.out.println(" O JRE embebido :"+" "+strJre);
          System.out.println("O Jre detectado:"+" "+strSOJre);
          SystemEnvironment();

          System.out.println(JVersion+"\n");
          System.out.println("Todas as propriedades do S.O\n");
          Properties prop = System.getProperties();
          prop.list(System.out);
          System.out.println(System.getProperty("mjrun.self"));
          System.out.println("HomeDir:"+" "+sysDir);
      
      
       new Settings().Save();
       
  //    ImageIcon imgIcon = new ImageIcon(baseDir.concat("\\resource\\images\\icons\\markit.png"));
 //    new MainWindow(name.concat(" ").concat(" - ").concat(user).concat(" - ")).setIconImage(imgIcon.getImage());
   
       Tab.onLoadStatus();
       system.SetUpSystemOffice.setSystem();
       int escrit=system.LoadSystemOffice.getOfficeCount(strEscrit);
       System.out.println("Escritorios:"+" "+escrit);
       Structure.class.getMethods().toString();
       System.out.println("Métodos:"+" "+Structure.class.getMethods().length);
       Structure.SystemBaseDir();
          // loadSkin();
       ListPlatformFonts();
        
          // new Settings().Load();
          //new SaveSettings();
      new LoadSettings();
      //new LoadSettings().readTabBackColor();
      
       new system.scripts.SetScripts().setScriptForWindowsSO();
       new system.scripts.SetScripts().setScriptForLinuxSO();
       new system.scripts.SetScripts().setScriptForMacSO();
       new settings.systemplatform.SetUpSystemPlatform().setOut();
       
       new Instance().SaveOnExit();
       new Instance().ReadOnLoad();
      }
      
    public static void main(String[] args) {
        
         try{
             ServerSocket start=new ServerSocket(port);
             if(start.getLocalPort()==port){
               new InstanceServer().StartLog(port);
               new Load();
            } 
         }
         catch ( IOException exp ){
              
            String strService="Instancia do serviço já foi criada:\n";
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, exp);
            JOptionPane.showMessageDialog(null,strService+exp.getMessage()+"\n", "Markit",1, null);
         }
         
    }
 
    public static void Stop() throws IOException{
       
        InstanceLog.cliente.close();
        InstanceServer.Exit();
        
    }
   
     private static void SystemEnvironment(){
       
           for (String env:System.getenv().values()) {
            String value = System.getenv(env);
            if (value != null) {
                System.out.format("Variavel de Ambiente:\n"+"%s=%s%n", env, value+"\n");
            } else {
                System.out.format("Variavel de Ambiente:%n"+"%s is not assigned.%n", env);
            }
        }
     }
    
      /**
         * le da base de dados
         */
    private static void loadSkin(){
      //Skin.inputColor();
         
    }
   
    private static void inSets(){
        new frontend.inoutdialog.SettingsDialog();
    }
      public static void ListPlatformFonts() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts
        for (Font f : fonts) {
          System.out.println(f.getFontName());
        }
      }

 
  
   private static class InstanceServer{
          static  JLog service=new JLog();
      public static void StartLog(int port) throws IOException {
       /*
        String cmdBatchStart="java -jar ";
        final String strServer="jstarter.jar";
        String userHomeDir = System.getProperty("user.dir");
        winStarter=Runtime.getRuntime().exec(cmdBatchStart+userHomeDir+strServer);
       */
          
          /*uso da biblioteca jlogservice.jar criada para o efeito de controlar 
          o numero de instancias do programa
          */
        service.WinStart();
        }
    
    public static void Exit() throws IOException{
       
        service.End();
       
    }
        
   /**
 * Checks to see if a specific port is available.
 *
 * @param port the port to check for availability
 */
public static boolean isRuning(int port) {
    
    ServerSocket instance = null;
    DatagramSocket ds = null;
    try {
        instance = new ServerSocket(port);
        instance.setReuseAddress(true);
        ds = new DatagramSocket(port);
        ds.setReuseAddress(true);
        
       
        
    } catch (IOException e) {
        System.out.println(e);
    } finally {
      System.out.println("Jabela de mensagem");
    }

   return true;
}
       }
}

  

      






