/*
Classe onde se vai realizar todos os trabalhos
Pertence à construção do Book. 
 */
package frontend.system;

import frontend.system.MainWindow;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author pd-sta-mkt
 */
public class SystemIcon extends JPanel {
    public static int x,y,w,h;
    public static Image img;
    private static String strImgPath;
    private static BufferedImage bfdImg;
       
       private static String baseDir=System.getProperty("user.dir");
       private static String strPath=baseDir.concat("\\resource\\images\\icons\\markit.png");
       
    public SystemIcon(int varCordX, int varCordY,int varSizeW, int varSizeH){
         super();
        x=varCordX;
        y=varCordY;
        w=varSizeW;
        h=varSizeH;
        //strImgPath=varImgPath;
        setLocation(x,y); 
       
        setOpaque(true);
        setSize(w,h);
        setLayout(null);
        setOpaque(false);
      
       setImageIcon(strPath);
      
    }
    private static void setImageIcon(String strPathImg){
            //atribuir uma imagem de fundo
        try {
           bfdImg = ImageIO.read(new File(strPathImg));
       } catch (IOException e) {
       }
         
     }
     public void paint(Graphics g) {
         
         int cordX=this.getLocation().x;
         int cordY=this.getLocation().y;
         int imgW =this.getWidth();//100%
         int imgH= this.getHeight();//100%
         int wPerc= Ratio(60,imgW);//percentagem de 60% do tamanho do hospedeiro
         int hPerc= Ratio(60,imgH);//percentagem de 60% do tamanho do hospedeiro
         
       //  g.drawImage(bfdImg,cordX+imgW/4,cordY+imgH/4,imgW/2,imgH/2, null);
         
        //atribuir o tamanho da imagem com valores percentuais do painel que a contem
        g.drawImage(bfdImg,cordX+wPerc/2,cordY+imgW/2-hPerc/2,wPerc,hPerc, null);
    }
     private int Ratio(int varVal,int varPerc){
         int val= varVal; // o valor percentual a atribuir
         int valPercComp=varPerc; // correspondente ao 100 %
         int varRatio= val * varPerc / 100; //o valor métrico da percentagem atribuida
         return varRatio;
     }
}