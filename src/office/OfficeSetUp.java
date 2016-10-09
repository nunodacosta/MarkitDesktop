/**
 * cria o escritorio (campanha)caso não exista
 * verifica se já existe, com base na leitura dos directorios no directorio
 *  do sistema. Se isto se verificar informa e solicita a eliminação daquele
 * escritorio  ou a criação de outro com nome diferente.
 * cria novas tabelas (?)
 */

package office;

import frontend.syscommand.CommandContext;
import static frontend.syscommand.CommandContext.status;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import org.apache.derby.tools.ij;
/*
Criação e gestão da base de dados 
*/
/**
 *
 * @author Nuno
 */
public class OfficeSetUp {
 
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    
    private static String strDbName="Usuario";
    private static String dbName=strDbName.concat(";");
      
     private static String method="databaseName=nameOfDatabase";
     private static  String CreateMethod=";create=true";
     private static String StopMethod=";shutdown=true";
     private static String RegistryMethod=";deregister=false";
    
      
   public OfficeSetUp(){
       
   }
   /**
    * Verifica a existencia das base de dados. Ao ser invocada a criação de
    * nova base de dados, é este método que vai fazer a verificação se a
    * nova base de dados já existe.
    * O processo é feito verificando se o directório já existe.
    * Recebe como parametro o nome da base de dados.
    * @return 
    */
   
    public static boolean IsOfficeCreated(File db){
     
        return db.exists();
    }
  
    /**
     * Gravações na base de dados
     */
    public static void CreateSystem(){
        
    }

    private static void Create(){
        
         Connection conn = null;
       //  String strTable="ARTIGO";
         
       try {
           
            String url_Create = protocol.concat(dbName).concat(CreateMethod);
            conn = DriverManager.getConnection(url_Create);
              
            if (conn != null) {
                 //JOptionPane.showMessageDialog(null,"Escritório:"+" "+ dbName+ " "+" "+"criado com sucesso","Markit-Office",1,null);
                System.out.println("Escritório:"+" "+ dbName+ " "+" "+"criado com sucesso" );
               // s = conn.createStatement();
              // s.executeUpdate("CREATE TABLE "+strTable+" (ID INTEGER NOT NULL \n" +
              // "PRIMARY KEY GENERATED ALWAYS AS IDENTITY, Nome varchar (200), cod_int INTEGER)");
                
               
            }
            // s.close();
           
             conn.close();
           
          } catch (SQLException ex) {
            ex.printStackTrace();
        } 
       
    }
  
  
    public static class CreateOffice implements Runnable{

        public CreateOffice() {
                if (!(IsOfficeCreated(new File(strDbName)))){
                    System.out.println("Vai ser criado o escritório"+ " "+strDbName);
                    Create();
                   
          }else {
                System.out.println("Já existe o escritório"+ " "+strDbName);
            // CloseOffice("office");
            }
        }

       
        public void run() {
            
             synchronized(CommandContext.status){
                if (!(IsOfficeCreated(new File(strDbName)))){
                    System.out.println("Vai ser criado o escritório"+ " "+strDbName);
                    Create();
                     }else {
                  
                        System.out.println("Já existe o escritório"+ " "+strDbName);
                         // CloseOffice("office");
                        }  
                 
             } 
            try {
                finalize();
            } catch (Throwable ex) {
                
            }finally{
               // JOptionPane.showMessageDialog(null,status.getState().toString(),"Markit-CreateOffice",1,null);
                if(CommandContext.buildOffice.getState().toString().equals("TERMINATED")){
                    CommandContext.status.interrupt();
   
                }
            }
        }

       
       
    } 
    public static class OfficeSwich{
         /**
     * Desliga o sistema de todos os escritórios criados
     * 
     * NOTA:
     * No caso das desinstalações de escritórios se fôr
     * adotado a utilização deste método para libertar 
     * os directórios, é necessário fazer reload às outras
     * ligações para continuar a trabalhar nos outros 
     * escritórios ainda instalados
     */
    public static void StopSystem(){
        
        try {
           Connection stopAll=null;
 
            String url_Stop=protocol.concat(StopMethod);
           stopAll = DriverManager.getConnection(url_Stop);
            
          } catch (SQLException ex) {
           // ex.printStackTrace();
        }
        
    }
    
    /**
     * Desconecta do escritório de dados
     * recebe como parametro o nome (String)
     * do escritório. Isto não remove o directorio 
     * do escritório mas liberta-o para ser manipulado.
     * É o procedimento necessário e que antecede à
     * desinstalação do escritório.
     * 
     * @param strOffice 
     */
    public static void CloseOffice(String strOffice){
            try {
               Connection close=null;

                String url_Stop=protocol.concat(strOffice).concat(StopMethod).concat(RegistryMethod);
                close = DriverManager.getConnection(url_Stop);

              } catch (SQLException ex) {
               // ex.printStackTrace();
            }   
        } 

        }

}