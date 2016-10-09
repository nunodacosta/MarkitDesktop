/**
 * Faz a leitura do directorio de  onde residem os escritorios.
 * Conta os escritorios para informar o usuario
 */
package system;

import java.io.File;

/**
 *
 * @author pd-sta-mkt
 */
public class SetUpSystemOffice {
    public static File sysDir;
    public static String systemDir;
    /**
     * Define onde será feita a instalação do sistema base da aplicação.
     * O sistema será composto pelo que internamente na aplicação está 
     * designado por escritorio.
     * 
     * O ustilisador vai definir os escritorios que necessitar
     */
    
    public static void setSystem(){ 
    /*
     * Define como directorio corrente, aquele em que a aplicação está a ser
     * executada
     */
    String userHomeDir = System.getProperty("user.dir");
    
    System.out.println("Directorio da APP:"+" "+userHomeDir);
    /*
     * Defene o directório onde serão instalados os escritórios do sistem
     */
    systemDir = userHomeDir + "\\system";
    System.out.println("Directorio de Escritorios:"+" "+systemDir);
    // Set the db system directory.
    System.setProperty("derby.system.home", systemDir);
    
    
    }
    
   
}
