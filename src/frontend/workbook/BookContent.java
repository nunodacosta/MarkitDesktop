/*
Classe onde se vai realizar todos os trabalhos
Pertence à construção do Book. 
 */
package frontend.workbook;


import frontend.syscommand.Command;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author pd-sta-mkt
 */
public class BookContent extends JLayeredPane {
    //public static JLayeredPane jlpInitBook;
    public static int x,y,w,h;
    public static Image img;
    private static BufferedImage bfdImg;
          public static Border bookBorder;
          private static Color borderColor;
          private static  String baseDir=System.getProperty("user.dir");
          private static  String strPath=baseDir.concat("\\resource\\images\\icons\\markit.png");
    public BookContent(int varCordX, int varCordY,int varSizeW, int varSizeH){
         super();
        x=varCordX;//quando termina o comp da box comando ;x para a frente dos comendos e
        y=varCordY;// quando termina h da barra titulo ;y abaixo da barra handler +60
        w=varSizeW;// comp jan princ - comp box comando - 8
        h=varSizeH;//h da janela principal - h da barra titulo - 68
        setLocation(x,y); 
     
        setOpaque(true);
        setSize(w,h);
        setLayout(null);
      //  setOpaque(false);//true ou false caso queiramos ou não imagem de fundo
       setBackground( BoundColor());
       setContent();
         
        //atribuir uma imagem de fundo
     // setImage(strPath);
    }
  
    private void setContent(){
      JPanel pnl1=new JPanel();
      pnl1.setVisible(true);
      pnl1.setBackground(Color.GREEN);
      pnl1.setBounds(getX()+10,getY()+10,getSize().width-20,getSize().height-20);
      pnl1.setLayout(null);

      JPanel pnl2=new JPanel();
      pnl2.setVisible(true);
      pnl2.setBackground(Color.MAGENTA);
      pnl2.setBounds(getX()+10,getY()+10,getSize().width-20,getSize().height-20);
      add(pnl2);
      setLayer(pnl1, 0,0);
      setLayer(pnl2,1,0);
      //MoveToFront();
      setComponentZOrder(pnl1, 0);
     // moveToFront(pnl1);
     
    }
   
    private Color BoundColor(){
     
     // return new startsystem.LoadSettings().readBookColor();
        return Color.PINK;
   }
    private class HandleBookContent{
        
    }
}
