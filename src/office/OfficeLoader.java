/**
 * Liga e faz a leitura nos escritorio .
 * Carrega as tabelas  da base de dados já existente (campanha)
 *
 */

package office;


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
import javax.swing.JOptionPane;
import java.sql.ResultSetMetaData;
//import org.apache.derby.tools.ij;
/*
Criação e gestão da base de dados 
*/
/**
 *
 * @author Nuno
 */
public class OfficeLoader {
 
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    
    private static String strDbName="sistema";
    private static String dbName=strDbName.concat(";");
      
     private static String Loadmethod="databaseName=nameOfDatabase";
    
   public OfficeLoader(){
       
   }
   /**
    * Verifica a existencia dos escritorios. Ao ser invocada a criação de
    * novo escritorio, é este método que vai fazer a verificação se já existe 
    * um escritório com o nome fornecido
    * O processo é feito verificando a existencia do respectivo directorio.
    * Recebe como parametro o nome do escritorio (directório).
    * @return true se o escritorio exister o que impede a criação de outro
    * directorio com o mesmo nome. Se tal acontecesse o seu o conteudo do 
    * directorio já existente poderia ser adulterado.
    */
    public static boolean IsOfficeReady(File db){
       
        return db.exists();
    }
     
    
    /**
     * Gravações na base de dados
     */
    public static void CreateSystem(){
        
    }
    
    private static void Load() {
                Statement s = null;
                Statement verTabela;
                Statement insert=null;
                Statement show=null;
                Statement select;
                ResultSet rs = null;
                ResultSet rsTables = null;
                Connection conn = null;
                String TABLE_NAME = "TABLE_NAME";
                String TABLE_SCHEMA = "TABLE_SCHEM";
                String[] TABLE_TYPES = {"TABLE"};
        
       try {
       
            String url_Load=protocol.concat(dbName).concat(Loadmethod);
            conn = DriverManager.getConnection(url_Load);
            DatabaseMetaData dbmd = conn.getMetaData();
             DatabaseMetaData mtdt = conn.getMetaData();//da lista conteudo
               if (conn != null) {
                   
                  select = conn.createStatement();
                 rsTables=dbmd.getTables(null,null, null, null);
                 select.executeQuery("SELECT * FROM ARTIGO");
        
//****Lista tabelas         
                 ResultSet tables = dbmd.getTables(null, null, null, TABLE_TYPES);
                 while (tables.next()) {
                    System.out.println(tables.getString(TABLE_NAME));
                   // System.out.println(tables.getString(TABLE_SCHEMA));
                    
       //**** Fim Lista tabelas

//****lista conteudo
    

    // list catalogs managed by this dbms
    System.out.println("Catalog Term de lista conteudo: "+mtdt.getCatalogTerm());

    ResultSet rsCont = mtdt.getCatalogs();

    ResultSetMetaData rsmd = rsCont.getMetaData();
    int numCols = rsmd.getColumnCount();
    for (int i = 1; i <= numCols; i++) {
      if (i > 1)
        System.out.print(", ");
      System.out.print("Column Label da lista de conteudo:"+rsmd.getColumnLabel(i));
    }
    System.out.println("");
    while (rsCont.next()) {
      for (int i = 1; i <= numCols; i++) {
        if (i > 1)
          System.out.print(", ");
        System.out.print("resultSet:"+rsCont.getString(i));
      }
      System.out.println("");
    }
        //***** Fim Lista Conteudo            
                }
               
               select.close(); 
            }
           
           conn.close();
           
          } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }

    public static class LoadOffice {

        public LoadOffice() {
                if (IsOfficeReady(new File(strDbName))){
             
               Load();
       }else 
               System.out.println("Não existe base dados");
           
        }
    }
}

  

 
