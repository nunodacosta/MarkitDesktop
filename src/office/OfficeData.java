/**
 * Insere uma nova tabela no escritorio indicado, caso exista.
 * Se o escritorio não existir, informa e solicita a sua criação.
 * Caso o escritório exista , verifica se já contem uma tabela
 * com o  nome indicado. Se a tabela existir informa e solicita
 * alteração do nome.
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

public class OfficeData {
    
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    private static String strDbName="Usuario";
    private static String strTable="ARTIGO";
    private static String dbName=strDbName.concat(";");
    private static String Loadmethod="databaseName=nameOfDatabase";
    
    /**
     * Aceita dois parametros: 
     * o nome do ficheiro correspondente ao escritório e o nome da tabela.
     * Ambos fornecidos por Strings.
     * O nome do escritório é necessario para averiguar se o escritório
     * existe. 
     * No caso de já existir uma ligação prévia por selecção ao escritorio
     * o fornecimento do seu nome a este método será automatizado no momento
     * da selecção
     */
  public static void InsertDataTable() {
  
        if(IsTableInserted(strTable)){
            System.out.println("Já existe uma tabela "+ " "+strTable);
        }
        else 
            System.out.println("Vai ser inserida a tabela"+" "+strTable);
     
    }
  /**
   * verifica a existencia da tabela no escritorio indicado
   * @param strTable
   * @return 
   */
  public static boolean IsTableInserted(String strTable){
           Connection conn = null;
           boolean inserted= false;
      try{
            String url_Load=protocol.concat(dbName).concat(Loadmethod);
            conn = DriverManager.getConnection(url_Load);
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null,strTable, null);
            
            if (rs.next()) {
                
              return true;
            }
            conn.close();
        }catch (SQLException ex) {
                 // ex.printStackTrace(); 
            }
   
      return inserted;
  }
}


                  
                 
                    
           
        