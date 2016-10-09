/**
 *   Esta classe escreve automaticamente arquivos de lote dependendo do
sistema operativo onde estiver a ser executada a aplicação:
windows, linux, mac

A sua utilidade revela-se para o caso de ficarem corrompidos ou de serem
eliminados os respectivos executáveis desde que o jar permaneça no seu 
directorio, os scripts pretendem usar o jre que acompanha a aplicação
e executarem-no.

É também a forma de ultrapassar algumas limitações que possam estar a ser 
impostas à execução directa do jar da aplicação
 */
package system.scripts;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
/**

 * @author nuno
 */
public class SetScripts {
    
    Properties  properties = System.getProperties();
         
    public  void setScriptForWindowsSO() throws IOException{
        /**
         * Se a máquina for windows
         */
        System.out.println("Propriedades: " + properties.toString());
     
        System.out.println(System.getProperty("file.separator"));
        if(System.getProperty("os.name").toString().startsWith("Windows",0)){
           
        try {
            String outConsole = System.getProperty("user.dir");
            System.out.println(outConsole);
            FileOutputStream fileOutputStream = null;
               try {
                   
                    fileOutputStream = new FileOutputStream(outConsole.toString().concat("\\".concat("OutPutMarkit.txt")));
                    System.setOut(new PrintStream(fileOutputStream, true));
                    System.out.println("Este pc:"+ ""+System.getProperty("os.name"));
                    System.out.println("/  -> " + new File("/").getCanonicalPath()+'\n');
		    System.out.println(".. -> " + new File("..").getCanonicalPath()+'\n');
		    System.out.println(".  -> " + new File(".").getCanonicalPath()+'\n');
                   } catch (FileNotFoundException e) 
                         {
                            e.printStackTrace();
                          }
			
		} catch (IOException io) {
			io.printStackTrace();
		}
      //  Runtime.getRuntime().exec("aplicação.exe"); // pode ainda referir-se a outro jar
       }
    }
    public  void setScriptForLinuxSO(){
        
        /**
         * Se a máquina for Linux
         */
        System.out.println("Propriedades: " + properties.toString());
     
        System.out.println(System.getProperty("file.separator"));
        if(System.getProperty("os.name").toString().startsWith("Linux",0)){
           
        try {
            String outConsole = System.getProperty("user.dir");
            System.out.println(outConsole);
            FileOutputStream fileOutputStream = null;
               try {
                   
                    fileOutputStream = new FileOutputStream(outConsole.toString().concat("\\".concat("OutPutMarkit.txt")));
                    System.setOut(new PrintStream(fileOutputStream, true));
                    System.out.println("Este pc:"+ ""+System.getProperty("os.name"));
                    System.out.println("/  -> " + new File("/").getCanonicalPath()+'\n');
		    System.out.println(".. -> " + new File("..").getCanonicalPath()+'\n');
		    System.out.println(".  -> " + new File(".").getCanonicalPath()+'\n');
                   } catch (FileNotFoundException e) 
                         {
                            e.printStackTrace();
                          }
			
		} catch (IOException io) {
			io.printStackTrace();
		}
      //  Runtime.getRuntime().exec("aplicação.exe"); // pode ainda referir-se a outro jar
       }
        
    }
    public  void setScriptForMacSO(){
        /**
         * Se a máquina for Mac
         */
        System.out.println("Propriedades: " + properties.toString());
     
        System.out.println(System.getProperty("file.separator"));
        if(System.getProperty("os.name").toString().startsWith("Macintosh",0)){
           
        try {
            String outConsole = System.getProperty("user.dir");
            System.out.println(outConsole);
            FileOutputStream fileOutputStream = null;
               try {
                   
                    fileOutputStream = new FileOutputStream(outConsole.toString().concat("\\".concat("OutPutMarkit.txt")));
                    System.setOut(new PrintStream(fileOutputStream, true));
                    System.out.println("Este pc:"+ ""+System.getProperty("os.name"));
                    System.out.println("/  -> " + new File("/").getCanonicalPath()+'\n');
		    System.out.println(".. -> " + new File("..").getCanonicalPath()+'\n');
		    System.out.println(".  -> " + new File(".").getCanonicalPath()+'\n');
                   } catch (FileNotFoundException e) 
                         {
                            e.printStackTrace();
                          }
			
		} catch (IOException io) {
			io.printStackTrace();
		}
      //  Runtime.getRuntime().exec("aplicação.exe"); // pode ainda referir-se a outro jar
       }
    }
    private class SetPrintOut{
        /**
         * Para criar formatação do arquivo a escrever
         */
        
        public SetPrintOut(){
            
        }
        
        
    }
}

