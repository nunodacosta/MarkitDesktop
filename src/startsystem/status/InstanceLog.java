/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package startsystem.status;

import frontend.system.MainWindow;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import frontend.system.MainWindow;

/**
 *
 * @author pd-sta-mkt
 */
public class InstanceLog{
        static MainWindow markitWindow;
        static  String user=System.getProperty("user.name");
        static  String  strJreDir="jre";
        static  String strSep=System.getProperty(("file.separator"));
        static  String sysDir=System.getProperty("user.home",".");
        //static  String name="Marketing";
        static String name ="Markit";
        static  String strEscrit="system";
        static  String JVersion = System.getProperty("java.version");
        static  String baseDir=System.getProperty("user.dir");
        static  String strJre = baseDir.concat(strSep).concat(strJreDir);
        static  String strSelfJre = System.setProperty("mjrun.self",strJre);// jre da aplicação
        static  String strSOJre=System.getProperty("java.home"); // Jre da máquina
 public static  Socket cliente;
    public InstanceLog() throws UnknownHostException{
        IP();
        Start(); 
       
        
    }
   private static void Start()throws UnknownHostException{
       InetAddress IP=InetAddress.getLocalHost();
      
       
       System.out.println("Markit:"+" "+IP.getHostAddress());
       // System.out.println(IP.getCanonicalHostName());
       System.out.println("Markit:"+" "+IP.getHostName());
    try {
        int cPort=LogPort(1010);
        cliente = new Socket(IP,cPort);
        String strCliService="LocalSocketAdress: "+
             cliente.getLocalSocketAddress().toString()+"\n"+ 
             "Local Port: "+cliente.getLocalPort()+"\n" + 
             "Serviço Atribuido: "+
             cliente.getPort()+"\n"+
             "Nome do processo: "+
             cliente.getInetAddress().getHostName()+"\n"+
             "Nome Canonico do Processo: "+   
             cliente.getInetAddress().getCanonicalHostName();
          
        
            ImageIcon imgIcon = new ImageIcon(baseDir.concat("\\resource\\images\\icons\\markit.png"));
            //new MainWindow(name.concat(" ").concat(" - ").concat(user).concat(" - ")).setIconImage(imgIcon.getImage());
            markitWindow=new MainWindow(name);
            markitWindow.setIconImage(imgIcon.getImage());
            JOptionPane.showMessageDialog(null,strCliService,markitWindow.getTaskName(),1,null); 
           
          
    }
    catch(Exception e) {
        
      JOptionPane.showMessageDialog(null,"Esta aplicação não pode \n"+"ser executada em modo autónomo.\n","Markit",1,null); 
     
    }   finally {
        
          
        }
    }
 
  private static void IP(){
      Enumeration nis = null;
try {
	nis = NetworkInterface.getNetworkInterfaces();
} catch (SocketException e) {
	e.printStackTrace();
}  
while (nis.hasMoreElements()) {  
	NetworkInterface ni = (NetworkInterface) nis.nextElement();  
	Enumeration ias = ni.getInetAddresses();  
	while (ias.hasMoreElements()) {  
		InetAddress ia = (InetAddress) ias.nextElement();  
		
	}  
}
  }
  private static int LogPort(int varPort){
      int port=varPort;
      return port;
  }
  private static String StringLog(String varStrLog){
      String strLog=varStrLog;
      return strLog;
  }
}