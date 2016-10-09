/*
 Classe para gerir as cores e toda a aparencia do programa
deve permitir alteração da cor, mantendo a coerencia entre os varios componentes
por coerencia entenda-se também as varias cores possiveis mas com atributo a uma mesma
palete.

Estas definições podem estar associadas aos varios utilizadores possiveis
a interagir com a aplicação

Forte possibilidade de se guardar as definições de visualização definidas pelo
user numa base de dados, com leitura no arranque. Se o registo do user for eliminado
essas definições também serão eliminadas, sendo então substituidas pelas default

CORES SEM ACÇÃO
        1 FUNDO JANELA MÃE -> MAINBACKGROUND
        2 CORES PARA BARRA TITULOS
        1 COR BARRA INPUTDIALOG / MSGDIALOG /ETC ..
        1 COR BACKGROUND DIALOG
        1 COR CONTAINERS -> CONTENTBACKGROUND
        1 COR BORDER ->
 */

package settings;

import frontend.inoutdialog.InputDialog;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Settings implements Serializable{
  public int R,Rflat;
  public int G,Gflat;
  public int B,Bflat;
  public Color color = setPlainColor(R, G, B);
  public static String strName;
  private String sep = System.getProperty("file.separator");
  private String fileSet = sep.concat(sep).concat("settings");
  private String extArqSet = ".ms";
  private String arqSet = sep.concat(sep).concat("skin").concat(extArqSet);
  public String userHomeDir = System.getProperty("user.dir");
  private File dirSet = new File(userHomeDir.concat(fileSet));
  public String strNome;
  public String corR;
  public String corG;
  public String corB;
 
  public Settings(){
      
  }
  public void Save() {
    new Out().Save();
  }
 

  public String setName(){
    return strName;
  }

  public int R() {
    for (int r = 0; r <= 255; r++) {
      this.R = r;
    }
    return this.R;
  }
  
  public int G() {
    for (int g = 0; g <= 255; g++) {
      this.G = g;
    }
    return this.G;
  }

  public int B() {
    for (int b = 0; b <= 255; b++) {
      this.B = b;
    }
    return this.B;
  }

//Cor flat
    public int Rflat() {
    for (int r = 0; r <= 255; r++) {
      this.Rflat = r;
    }
    return this.Rflat;
  }
  
  public int Gflat() {
    for (int g = 0; g <= 255; g++) {
      this.Gflat = g;
    }
    return this.Gflat;
  }

  public int Bflat() {
    for (int b = 0; b <= 255; b++) {
      this.Bflat = b;
    }
    return this.Bflat;
  }
  // fim

  private Color setPlainColor(int R, int G, int B)
  {
    Color color = new Color(R, G, B);
    return color;
  }
  public Color FlatColor() {
    Color flat = setPlainColor(220,220,220);
    return flat;
  }
  // cor standar das abas
  public Color StandTabColor(){
      Color tabColor=setPlainColor(135,170,222);
      return tabColor;
  }
  // Cor das abas quando activadas
  public Color OnClickTabColor(){
      Color tabClickColor=setPlainColor(212,223,221);
      return tabClickColor;
  }
  //cor da pagina de trabalho da aba inicio
  public Color StandBookColor(){
      //Color standBookColor=setPlainColor(247,247,247);
      Color standBookColor=setPlainColor(47,47,47);
      return standBookColor;
  }
  public Color BoundColor(){
     //Color boundColor = setPlainColor(47,47,47);
     Color boundColor =OnClickTabColor();
    return boundColor;
  }
  public Color CmdStartColor(){
      return setPlainColor(130,166,172);
  }
  public Color MainBackColor(){
     return setPlainColor(48,57,66);
   
  }
  public Color WorkBookColor(){
   
     Color bookcolor= OnClickTabColor();
      return bookcolor;
  }
  public void setDuoPlainColor(){
  }
  public void setGradColor(){
      
  }
  public void onOverColor(){
  }

  public void pressColor(){
  }

  public void releaseColor(){
  }



  public void cmdBorderColor(){
  }

  public void borderColor(){
  }

  public void onWorkColor(){
  }

  public void ErrorInputColor()
  {
  }

  public static void inputColor(){
    new InputDialog();
  }

  private class ReadIn{
      
    private ReadIn(){
        
    }

   
  }

  private class Out{
      
    private Out() {
    }

    private void Save(){
       
      if (!dirSet.exists()) {
        boolean isDirectoryCreated =dirSet.mkdir();
        if (isDirectoryCreated) {
            
          }
      }
      Settings set = new Settings();
      set.strNome = "Default";
      set.R = 200;
      set.G = 200;
      set.B = 200;
      set.Rflat = 85;
      set.Gflat = 94;
      set.Bflat = 102;
      set.setPlainColor(220, 220, 220);
       //alterações inicio
      set.BoundColor();
      set.cmdBorderColor();
      set.MainBackColor();
      set.WorkBookColor();
      set.StandTabColor();
      set.OnClickTabColor();
      set.StandBookColor();
         //alterações fim
      try {
        FileOutputStream fos = new FileOutputStream(userHomeDir.concat(fileSet).concat(arqSet));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(set);

        oos.flush();
        oos.close();
      
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}