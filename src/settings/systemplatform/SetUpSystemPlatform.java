/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings.systemplatform;

/**
 *
 * @author pd-sta-mkt
 */
/**
 * Define os directorios onde são escritos ficheiros de saida
 * para : erros ; comunicação user; temporarios; definições
 * vai definir as propriedades do sistema para esta aplicação.
 * Variaveis de ambiente
 * Directorio do java (jre)
 * Define nas propriedades a identificação da máquina
 * Para essa máquina, antes de definir o directorio do jre
 * vai averiguar se existe um jre instalado. Se existir averigua
 * a versão e compara com o jre embebido. 
 * Lançça Dialog a informar por forma a caber a o user definir
 * qual jre será usado. Esta opção fica gravada nas properties
 * para adequada a cada máquina onde a aplicaçõa seja executada
 * @author pd-sta-mkt
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SetUpSystemPlatform {
    
    /*
    Os testes seguintes referem-se á formatação de texto no 
    output com escrita direccionada para ficheiro e sua leitura 
    e carregamento em Dialog
    
    */
    
    Properties  properties = System.getProperties();
        
    public void setOut()throws IOException{
        String baseDir=System.getProperty("user.dir");
        String strJreDir="jre";
        String strSep=System.getProperty(("file.separator"));
        String strJre = baseDir.concat(strSep).concat(strJreDir);
        System.out.println("Propriedades: " + properties.toString());
        String strSelfJre = System.setProperty("mjrun.self",strJre);// jre da aplicação
        String strSOJre=System.getProperty("java.home"); // Jre da máquina
  
               try {
                    System.out.println(baseDir);
                    FileOutputStream fos = null;
                    fos = new FileOutputStream(baseDir.toString().concat("\\".concat("MarkitProp.txt")));
                    System.setOut(new PrintStream(fos, true));
                    System.out.println("Este pc:"+ ""+System.getProperty("os.name"));
              
		    System.out.println(" O JRE embebido :"+" "+strJre);
                    System.out.println("O Jre detectado:"+" "+strSOJre);
		   // System.out.println(".  -> " + new File(".").getCanonicalPath()+'\n');
                   } catch (FileNotFoundException e) 
                         {
                            e.printStackTrace();
                          }
			
		
        
    }
}
