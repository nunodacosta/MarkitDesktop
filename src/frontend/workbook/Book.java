/*

 vai conter BookSetPack 
 vai conter Tab

 Desenvolver método para adicionar nova tab
 */
package frontend.workbook;

import javax.swing.*;
import frontend.workbook.TabSet;
import frontend.workbook.BookSetPack;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author pd-sta-mkt
 */
public class Book extends JPanel {
    // background Transparente ? setOpaque(false) para adquirir a cor de fundo da janela
    // adicionar as tabs por cima do bookinsets
    // adicinar o bookinsets ( pnlactivity em mainWindow)
    // o setSize() ficará definido para booinsets + tab
    // o setLocal sera o x de pnlactiviry em mainwindow e o y de tabset em mainwindow

    public static int x, y, w, h;
    private static TabSet tabset;
    public static BookSetPack bookset;
   

    public Book(int varCordX, int varCordY, int varSizeW, int varSizeH) {
        super();
        x = varCordX;//quando termina o comp da box comando ;x para a frente dos comendos e
        y = varCordY;// quando termina h da barra titulo ;y abaixo da barra handler +60
        w = varSizeW;// comp jan princ - comp box comando - 8
        h = varSizeH;//h da janela principal - h da barra titulo - 68
        setLocation(x, y);
        setOpaque(false);
        setSize(w, h);
        setLayout(null);
        setTabPack();
        setBookIn();
        setBackground(BackColor());
    }

    private void setTabPack() {
        tabset = new TabSet(0, getLocation().y - 50, getSize().width, 60);

        tabset.setVisible(true);
        tabset.setLayout(null);

        // tabset.setBackground(this.getBackground());
        add(tabset);
    }
    
    private Color BackColor(){
        // return new startsystem.LoadSettings().readBookColor();
        return Color.MAGENTA;
        }
    
    public void setBookIn() {
        bookset = new BookSetPack(0, tabset.getSize().height, getSize().width, getSize().height);
        bookset.setVisible(true);
        bookset.setLayout(null);
      
        add(bookset);
       
    }
    
    private void setPageInit(){
        new frontend.workbook.BookInit().setBounds(100, 100, 10, 10);
    }
    
    private void setPageMkt(){
        new frontend.workbook.BookMkt().setBounds(100, 100, 10, 10);
    }
    
    private class HandleSetByDrag implements MouseMotionListener, MouseListener {

        /*
         * Redimenciona o componente por arrastamento do mouse- movimento esquerda 
         direita e direita esquerda.
         O movimento será feito para este componente unicamente partindo do lado 
         esquerdo. Se for para a direita, além da redimensão deste componente
         faz a redimencão do componente adjacente (cmdpack) e simultaneamente 
         é reposicionado na janela. Aumenta tanto no cmdpack como diminui este
         componente. Se for da direita para a a esquerda: faz o redposionamento 
         na janela e aumenta tanto o seu tamanho quanto dominui o tamanho de
         cmdpack. 
         Todos os componentes que este possa conter são detectados  automatica-
         mente e reposicionados em conformidade.
         Os automatismos de reposição deverão ser feitos por valore percentuais.
      
         */
        private Point pLocalHeight;
        private Point pLocalWidth;
        private int compWidth, nextWidth, componentStartWidth, xWidth, reSizeWidth;
        private int minWidth; //tem de ser convertido do valor percentual
        private int compHeight;
        private Point startReLocal;
        private int nextHeight;
        private int minHeight;
        private int componentStartHeight;
        private Point local, startLocal;
        private int previousWidth;
        private int previousHeight;
        private Point previousLocal;
        private MouseEvent getLocal;
        
        public void mouseDragged(MouseEvent me) {

            pLocalHeight = me.getPoint();// O mesmo que local
            pLocalWidth = me.getPoint();
            compWidth = getSize().width;
            compHeight = getSize().height;
            startReLocal = getLocation(startReLocal);

             if (getCursor().getType() == Cursor.W_RESIZE_CURSOR) {
                xWidth = startReLocal.x - getLocal.getX() + me.getX();
                reSizeWidth = startLocal.x - startReLocal.x;
                nextWidth = componentStartWidth + pLocalWidth.x - local.x + reSizeWidth;
            }
        }

        public void mouseMoved(MouseEvent me) {
            /*
             Altera o cursor em conformidade com o ponto onde passa o mouse
             A cordenada y desse ponto devera estar entre o valor da altura
             e esse valor -5. O valor 5 � arbitrario.
             Do mesmo modo a cordenada x do ponto devera estar entre o valor do
             comprimento  e esse valor -5. O valor 5 tamb�m � arbitrario
             */
            pLocalHeight = me.getPoint();
            pLocalWidth = me.getPoint();
           if (pLocalWidth.x < 5) {
                setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
           } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }

        public void mouseClicked(MouseEvent me) {

        }

        public void mousePressed(MouseEvent me) {
            local = me.getPoint();//sim
            getLocal = me;
            //  startLocal= getLocation();
            componentStartHeight = getSize().height;
            componentStartWidth = getSize().width;
        }

        public void mouseReleased(MouseEvent me) {

        }

        public void mouseEntered(MouseEvent me) {

        }

        public void mouseExited(MouseEvent me) {

        }

    }
    
}
