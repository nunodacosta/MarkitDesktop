/**
 * Remove um escritorio do sistema
 * O processo é feito através da remoção do seu directorio.
 * Como directórios também são ficheiros, tem de ser feita a verificação
 * se de facto se trata de um directório, uma vez que se for o caso pode 
 * não estar vazio e por consequencia terá que ser eliminado o seu conteúdo.
 * Passo 1 - verifica se o ficheiro existe. Se sim, tenta remover.
 * Se a remoção não for bem sucedida, vai para passo 2
 * Passo 2 - verifica se é directorio. Se for directório e a remoção não 
 * foi bem sucedida, é porque não está vazio. Segue para o passo 3
 * Passo 3 - Lista o conteudo e verifica entre esses ficheiros quais são 
 * directórios. Recolhe os nomes num array de Strings
 * Percorre o array atribuido recebendo o ficheiro com o nome correspondente
 * a cada indice. Para cada instancia remove o ficheiro, até o directorio
 * principal estar vazio.
 * Ultima verificação. Mesmo com o directorio vazio, se a ligação ainda não foi
 * fechada, a remoção não será bem sucedida. 
 * Tem que se indicar que a ligação não foi fechada ou que o sistema está em uso.
 * 
 * Se houver arrays com listagem das base de dados, deverá ser feito 
 * o refresh a todo o sistema por forma a actualisar a informação 
 * em runtime. 
 * Se for vazio, remove. Caso contrário lista o  conteudo

 */
package office;

/**
 *
 * @author Nuno
 */

import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class OfficeUninstall {


    public static File dir; 
    public static File dirName;
      public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
          
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) { 
               boolean deleted = deleteDir(new File(dir, children[i]));
                if (!deleted) {
                    return false;
                }
            }
        }
    
        // Agora o diretório está vazio, restando apenas deletá-lo.
        return dir.delete();
    }



    public static void RemoveFromSystem(File varDir){
           dir=varDir;
           if(varDir.exists()){
               
              // varDir.delete();
              // System.out.println("Systema"+" "+ dir + "eliminado");
              // System.out.println(varDir.getPath());
                // System.out.println(varDir.isDirectory());
                  // System.out.println(varDir.isFile());
                  boolean isRemoved= (varDir.delete());
                  if(!isRemoved){
                      if(varDir.isDirectory()){
                         deleteDir(varDir);
                         if(varDir.exists()){
                             System.out.println("Falha na remoção do escritório"+" "+" ' "+ varDir + " ' ");
                             System.out.println("Verificar se existe ligações activas");
                         }else
                             System.out.println("Escritório removido:"+ " "+ varDir + "\n Necessário reiniciar a aplicação");
                        }
                
              
                    }
            }
    }
    
     public static void RenameSystem(File varNameDir, File varNewName){
           dir=varNameDir;
        
           
           if(varNameDir.exists()){
             String strName;
            
            }
    }
}

