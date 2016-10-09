/*
É aqui que o display de toda a informação se vai concentrar
 */
package frontend.workbook;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author pd-sta-mkt
 */
public class BookSetPack extends JPanel{
        public static int x,y,w,h;
          public static Border bookBorder;
          private static Color borderColor;
          public BookContent work;
         
       public BookSetPack(int varCordX, int varCordY,int varSizeW, int varSizeH){
        super();
        x=varCordX;//quando termina o comp da box comando ;x para a frente dos comendos e
        y=varCordY;// quando termina h da barra titulo ;y abaixo da barra handler +60
        w=varSizeW;// comp jan princ - comp box comando - 8
        h=varSizeH;//h da janela principal - h da barra titulo - 68
        setLocation(x,y); 
       
        setOpaque(true);
        setSize(w,h);
        borderColor = defaultColor();
        bookBorder=BorderFactory.createMatteBorder(0,1,1,1,borderColor); //topo,esquerda,baixo,direita
        setBorder(bookBorder);
        setLayout(null);
        setBackground(defaultColor());
        
        // Entra o painel de trabalhos
        work = new BookContent(5,5,getSize().width-10,getSize().height-73);
        
        add(work);
    }
   private Color defaultColor(){
  
     return new startsystem.LoadSettings().readBoundColor(); 
  }
}
