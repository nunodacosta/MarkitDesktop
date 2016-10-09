/*
Estrutura do sistema.
A estrutura do sistema mantem a integridade dos ficheiros no directorio correspondente
garantindo portanto o bom funcionamento da aplicação mediante a preseverança da sua estrutura
 gere as classes da aplicação
permite verifica os directorios da aplicação e as classes que neles existam
comunica essa lista de classes co a classe skin para que esta possa ober os 
objectos sobre os quais deverá agir
Na falta de uma classe é esta que tem por função informar o user do ficheiro em falta
através de dialog box adequada

o directorio de backup da aplicação tem todas as classes finais d programa
Esta classe permite recolocar o ficheiro classe em falta por cópia.
Tem deste que saber a que packge pertence cada classe

Faz a leitura no directorio do sistema de todos os packages( directorios) e dentro
destes as classes, guardando os seus nomes em respectivas pilhas

Em cada classe lida recolhe os objectos ou instancias de outras classes e informa
estas dos objectos que lhes pertencem
 */

package startsystem;

/**
 *
 * @author pd-sta-mkt
 */
import java.io.*;
public class StructSystem {
    private static String baseDir = System.getProperty("user.dir");
    int mainDir; //numero de directorios principais no directorio da aplicação
    int fileClass;//numero de classes existentes na aplicação
    
    
    /*
     * Directorio base do sistema
     */
    public static void SystemBaseDir(){
        System.out.println("Directorio base do Sistema:"+" "+baseDir); 
        File sysDir;
          File fileDirSystem=null;
          sysDir=new File(baseDir);
        int count=0;
        File dirSystem[]=sysDir.listFiles();
        for(int i=0; i < dirSystem.length;i ++)
           fileDirSystem = dirSystem[i];
           if(fileDirSystem.isDirectory()){
               count=count+1;
               System.out.println(fileDirSystem.getName());
              System.out.println(sysDir.getName());
                System.out.println(count);
                System.out.println(sysDir.getParentFile().getName()+ " "+":directorio acima");
           }
           
    }
      public String BaseDir(){
        System.out.println("Directorio base do Sistema:"+" "+baseDir); 
        File sysDir;
          File fileDirSystem=null;
          sysDir=new File(baseDir);
        int count=0;
        File dirSystem[]=sysDir.listFiles();
        for(int i=0; i < dirSystem.length;i ++)
           fileDirSystem = dirSystem[i];
           if(fileDirSystem.isDirectory()){
               count=count+1;
               System.out.println(fileDirSystem.getName());
              System.out.println(sysDir.getName());
                System.out.println(count);
                System.out.println(sysDir.getParentFile().getName()+ " "+":directorio acima");
           }
           return baseDir;
     }
      
      private void getInnerStructure(){
          /**
           * Recebe o jar e desmonta-o. Procura em toda a estrutura do jar
           * os directorios e subdirectorios para listar todas os packages,
           * classes e nome de classes bem como os componentes que cada classe
           * contem.
           * Agrega estes componentes a listas adequadas para serem acessadas
           * 
           */
      }
      public void getInnerObjects(){
          
      }
}