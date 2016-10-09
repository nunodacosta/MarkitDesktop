/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.io.File;

/**
 *
 * @author Nuno
 */
public class LoadSystemOffice {
     public static File sysDir;
     public static String systemDir=system.SetUpSystemOffice.systemDir; 
      /**
     * Contagem dos escritorios existentes num directorio do sistema ou subsistema
     * se existir.
     * 
     * Para que um user leia a contagem de escritório do sistema privado (subsistema),
     * precisa estar registado
     * (Esse login é providenciado no arranque da aplicação)
     * Com utilizadores registados será possivel, indicar no systema um subsistema
     * privado ao registo de cada utilisador.
     * 
     * A desenvolver e ainda não implementado:
     * 
     * solução 1: O utilisador informa as suas credenciais no login e na base de dados correspondente
     * fica automaticamente ligado a um subsistema privado porque irá fazer parte
     * das credenciais o nome do subsistema privado ao utilisador.
     * 
     * O recurso a este método neste contexto, permite que ao utilisador seja 
     * informado o numero de escritorios do seu subsistema mediante a indicação
     * desse directorio e da sua senha.
     *  
     * solução 2:O mesmo que na solução 1 automaticamente , apenas com a 
     * indicação da senha.
     * 
     * Nota final às soluções anteriores.
     *   Se na altura de fornecimento das credenciais o utilisador não indicou
     * (ou desmarcou a opção) o nome do subsistema, então os escritorios que 
     * criar irão ser instalados na pasta do sistema predefinida, não sendo
     * portanto privados. Neste contexto o recurso a este método não se justifica
     * sendo usado o método seguinte que faz a leitura dos escritórios existentes
     * na pasta predefinida
     * 
     * @param sysDir
     * @return 
     */
    public static int getOfficeCount(File sysDir){
        int count=0;
        File fileOffice=null;
        sysDir=new File(systemDir);
        
        File officeSystem[]=sysDir.listFiles();
        for(int i=0; i < officeSystem.length;i ++)
           fileOffice = officeSystem[i];
           if(fileOffice.isDirectory()){
               count=count +1;
           }
       // System.out.println(count);
        
        return count;
    }
     public static int getOfficeCount(String strDir){
        int count=0;
        File fileOffice=null;
        sysDir=new File(strDir);
        
        File officeSystem[]=sysDir.listFiles();
        for(int i=0; i < officeSystem.length;i ++)
           fileOffice = officeSystem[i];
           if(fileOffice.isDirectory()){
               count=count +1;
           }
       // System.out.println(count);
        
        return count;
    }
    /**
     *  Contagem dos escritorios existentes no sistema
     */
    private static void getOfficeCount(){
        
    }
}
