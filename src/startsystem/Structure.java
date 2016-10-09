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
import java.util.ArrayList;
import java.awt.Component;
import frontend.*;
import frontend.syscommand.Command;
import frontend.syscommand.CommandContext;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Structure {
    private static String baseDir = System.getProperty("user.dir");
    int mainDir; //numero de directorios principais no directorio da aplicação
    int fileClass;//numero de classes existentes na aplicação
    
    
    /*
     * Directorio base do sistema
     */
    
     public static ArrayList<Object>structObject=new ArrayList<Object>();
    public static ArrayList<Component>structComp=new ArrayList<Component>();
    public static ArrayList<Command>cmdObj=new ArrayList<Command>();
    private final String strClsCommand="Command";
    public int objRecorded;
    
    public void getSystemPackages(){
        
    }
    public void getSystemClasses(){
        
    }
    public int getClassObjects(){
        Component c;
        Object o;
        Class cls=new frontend.syscommand.ContextPlaceHolder().getClass();
                
        int compCount=new frontend.syscommand.ContextPlaceHolder().getComponentCount();//iterator
        objRecorded=0;
        for(int i=0;i<compCount;i++){
            c=getComponent(i);
            structComp.add(c);
             objRecorded=structComp.size();
            String str=""+objRecorded;
           
          // JOptionPane.showMessageDialog(null,str,getClass().getCanonicalName(),1,null); 
        }
        return compCount;
    }

    private Component getComponent(int i) {
       Component comp=null;
       return comp;
    }
    public void RecieveComponent(Component c){
        String compName="";
        structComp.add(c);
        objRecorded=structComp.size();
        for(int i= 0;i< structComp.size();i++){
            c=c;
            int ord=i+1;
            compName=c.getClass().getSimpleName()+"_"+ord+"\n";
           
        }
        //quantos elementos na classe onde existe c provem da classe de c
        // ou seja quantos elementos iguais a c existem na mesma classe
        
        //Quantos componentes existem em c
        
        JOptionPane.showMessageDialog(null,compName+structComp.size(),"Gravar Componentes",1,null); 
        
    }
    
    private void GetCommand(Command cmd){
        String compName="";
        cmdObj.add(cmd);
       
        //quantos elementos na classe onde existe c provem da classe de c
        // ou seja quantos elementos iguais a c existem na mesma classe
        
        //Quantos componentes existem em c
        
        JOptionPane.showMessageDialog(null,compName+structComp.size(),"Gravar Comandos",1,null); 
        
    }
    
    public void UpdateCommandContext(CommandContext cmdCnt){
        /**
         * Trata automaticamente da dimensão de um componente
         * O componente é o pai a ser redimencionado consuante
         * o numero de componentes filhos
         * Este método deve ser chamado após o metodo de instalação de componentes
         * no componente pai comp
         */
        
        Component c;//componente filho
        Command cmd = null;
        int compChield=0; //numero componentes fihos guardados
      
        for(int i=0;i<cmdCnt.getComponentCount();i ++){
           c=cmdCnt.getComponent(i);
           
           if(c.getClass().getSimpleName().equals(strClsCommand)){
               compChield+=1;
              }
         
           if(c.getWidth()>0 && c.getHeight()>0)
            
                 JOptionPane.showMessageDialog(null,"("+cmdCnt.getComponentCount()+")"+""+"\n"+c.getClass().getSimpleName()+"_"
                         + "\n"+"Width do"+c.getName()+":"+c.getWidth()+"\n"+"Heigh do"+c.getName()+":"+c.getHeight(),"Actualizar Contexto",1,null); 
                 cmdCnt.setSize(cmdCnt.getWidth(),cmdCnt.getHeight()+c.getHeight()+5);
                
        }
       
 
    }
    
    public void ConfigComponent(){
        
    }
    
    public void UpdateComponent(Component comp){
        /**
         * Trata automaticamente da dimensão de um componente
         * O componente é o pai a ser redimencionado consuante
         * o numero de componentes filhos
         * Este método deve ser chamado após o metodo de instalação de componentes
         * no componente pai comp
         */
        Component c;//componente filho
     
        int compChield=0; //numero componentes fihos guardados
       
        for(int i=0;i<structComp.size();i ++){
            c=getComponent(i);
           
            //se c for componente filho de comp
            if(c.getParent().getClass().getSimpleName().equals(comp.getClass().getSimpleName())){
                compChield=compChield + 1;
            }
         //  comp.setSize(comp.getWidth(),c.getHeight()*compChield + 10);
             JOptionPane.showMessageDialog(null,comp.getClass().getSimpleName(),"Actualizar Componente",1,null); 
        }
       
        
    }
    
   
    
    public Component ComponentToConfig(){
        Component c=null;
        return c;
    }
    public int ComponentRecordedCount(){
        
        
        return objRecorded;
    }
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