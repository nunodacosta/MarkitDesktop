
package settings;


import java.io.*;

/**
 * Esta classe será implementada numa biblioteca
 * 
 * Protocolar o ficheiro do seguinte modo
 * [instance]-> significa inicio da [instance]
 * >status> inicio
 * ->open=true // ou ->close=true  (desenvolver método boleano para receber estes parametros
 * <satus< fim do status
 * <[instance] fim da instancia
 * 
 * @author pd-sta-mkt
 */
public class Instance implements Serializable{
    /*
    "[instance.close]" procurar estabelecer na classe o método
    por forma a obter esta designação. Desse modo
    obter o [nome-da-classe.nome-do-metodo]. toString e colocar 
    na constante strExit, para comparação com o objecto lido
    
    */
   
    private  String onExit;
    private  String onLoad;
    public static String strName;
    private String sep=System.getProperty("file.separator");
    private String fileSet=sep.concat(sep).concat("settings"); // directorio de definições
    private String extArqSet=".dat";// extenção do arquivo (markit settings)
    private String arqSet=sep.concat(sep).concat("load").concat(extArqSet);// nome do arquivo (settings)
    public String userHomeDir = System.getProperty("user.dir"); // directorio do sistema
    private File dirSet = new File(userHomeDir.concat(fileSet)); // onde será guardado o arquivo
    


    public Instance(){
        
    }
    
    public void SaveOnExit(){
        // escreve "close" no ficheiro 
        /**
         * Close é o termo a ler antes da construção da gui
         * para determinar se a aplicação foi devidamente encerrada
         */
       //  new SaveOut().saveSettings();
        new SaveOutStatus().saveStatus();
    }
    
    public void ReadOnLoad(){
        // procura o termo "open" e "close"
        /**
         * O termo open tenta evitar uma segunda instancia. Se existir
         * fecha a segunda ins
         */
        // caso open
        // caso close
           new ReadInStatus().loadStatus();
    }
    
      public void SaveOnLoad(){
        // escreve  "open" no ficheiro
        /**
         * O termo open tenta evitar uma segunda instancia. Se existir
         * fecha a segunda instancia
         */
          // new ReadInStatus().loadStatus();
    }
  
  
   
    private class SaveOutStatus {
      
        
       public void saveStatus(){
            
           if(!dirSet.exists()){
               boolean isDirectoryCreated = dirSet.mkdir();
                 if (isDirectoryCreated) {
                    System.out.println("directorio de definições está criado");
                 } 
           }
        Instance checkstatus=new Instance();
       
        checkstatus.onExit="[instance.close]";
        checkstatus.onLoad="[instance.open]";
       
       
        try {
        FileOutputStream fos =new FileOutputStream(userHomeDir.concat(fileSet).concat(arqSet));
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(checkstatus);
     
       
        oos.flush();
        oos.close();
        System.out.println("STatus protocolado");
             }
        catch (Exception e){
            System.out.println(e);
            
        }
       }     
    }
      private class ReadInStatus{
          
         private final String strExit="[instance.close]";
         private final String strLoad="open";
         
        public void loadStatus(){
            try{
                FileInputStream fin=new FileInputStream(userHomeDir.concat(fileSet).concat(arqSet));
                ObjectInputStream ois=new ObjectInputStream(fin);
                Instance inst=(Instance)ois.readObject();
               
               if (strExit.equals(inst.onExit)){
                    System.out.println("confere");
               }else {
                   System.out.println("não confere");
               }
                  
                System.out.println(inst.onExit);
                System.out.println(inst.onLoad);
            }
            catch( Exception e){
                e.printStackTrace();
            }
        }
    }
} 
