package frontend.inoutdialog;

import frontend.display.DisplayCurrentWork;
import frontend.inoutdialog.DialogInSets;

import frontend.system.MainWindow;

import static frontend.inoutdialog.DialogInSets.strTitle;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import frontend.system.MainWindow;
import static frontend.system.MainWindow.bookIn;

public class InDialog extends JPanel {

    public static Color borderColor;
    public static String strTitle;
    public static JLabel lblTitle;

    public int width, height, posX, posY;
    public static Border intwinTBorder;
    public static MainWindow mainWindowHost;

    public static MouseEvent me;
    public static Container board;
    public static Point targetLocal;
    public static Point pLocalHeight, pLocalWidth;

    public static String nameApp, templateName;
    public static int targetPointX, targetPointY;
    public static Point local;
    public static Point startLocal;
    public static Point startReLocal;
    public static Point formLocal;
    public static Point formDefinedLocal;
    public static Point formOldLocal;
    public static Point newFormLocal;
    public static MouseEvent getLocal;
    public static Point pLbl;
    public static Border displayTxtBorder;
    public static Point plToMsg;
    public MainWindow mainWindow;
    public static Border intwinBorder;
    public static Font fontTitleText;
    public static Font fontMessageText;
    public static FontMetrics fontMetrics;
    public static DialogBar iwtb;

    public static DisplayCurrentWork displayMsg;
    public static DialogBar handleBar;
    public static DialogInSets iwBody;
    public static String strGetName;
    //variaveis dos construtores
    public static String strWindowName, strWindowTitle;
    public static String strName;
    public static int windowWidth, windowHeight, varAvailableWidth, varAvailableHeight, varComponentsCount;
    public static int fullWidthComponents, componentInterval, fullHeightComponents, availableWidthLandHost;
    public static int allComponentsInLandHost, availableHeightLandHost, componentWidth, componentHeight;
    int componentsInterval; //o valor de intervalo dos componentes no hospedeiro
    int componentsIntervalCount;// numero de intervalos entra componentes no hospedeiro
    public static Point sP; // o ponto onde para localisar este objecto
    public static Point compP1;// o ponto de localisa��o de um componente
    public static Point compP2;// o ponto de localisa�a� de um segundo componente
    public static boolean setAsDrag;
    public static JLabel lblWork;
    public static String strWork;
    private final String workTitle = "Area de trabalhos";

    Point location;
    Point leftPos;

    public InDialog() {
        super();
        setProperties();
    }

    public InDialog(String varStrWindowTitle) {
        super();
        strWork = varStrWindowTitle.toUpperCase();
        setWindowSize();
        setProperties();
    }

    public InDialog(int varWindowWidth, int varWindowHeigth) {
        super();
        windowWidth = varWindowWidth;
        windowHeight = varWindowHeigth;
        this.setSize(windowWidth, windowHeight);
        setProperties();
    }

    public InDialog(String varStrWindowTitle, int varWindowWidth, int varWindowHeigth) {
        super();
        strWork = varStrWindowTitle.toUpperCase();
        windowWidth = varWindowWidth;
        windowHeight = varWindowHeigth;
        this.setSize(windowWidth, windowHeight);
        setProperties();
    }

    public void setWindowName(String strTxtName) {
        strName = strTxtName.toUpperCase();
        this.setName(strName);

    }

    public String getWindowName() {
        strGetName = this.getName();
        return strGetName;
    }

    public void setWindowResizeWidth(int varWidth) {
        //redimensiona o comprimento
        this.setSize(varWidth, this.getHeight());
    }

    public void setWindowResizeHeigth(int varHeight) {
        //redimensiona a altura
        this.setSize(this.getWidth(), varHeight);
    }

    public int getAvailableWidth() {
        return varAvailableWidth;
    }

    public int getAvailableHeight() {
        return varAvailableHeight;
    }

    public static void setWindowTitle(String strWork) {
        lblWork.setText(strWork.toUpperCase());
    }

    public static void setDefaultTitle() {

    }

    public boolean isDraggable(boolean drag) {
        setAsDrag = drag;
        if (drag == true) {
            handleBar.addMouseListener(new HandleDialog());
            handleBar.addMouseMotionListener(new HandleDialog());
        }
        return drag == setAsDrag;
    }

    public void setWindowSize() {
        /*
         * Pretende automatizar o tamanho a atribuir
         * Contar os elementos que existem no hospedeiro, para calcular a area ocupada 
         * e determinar a area livre, que sera a disponivel para este componente ocupar
         * tem que chamar o metodo da classe do hospedeiro getComponentsCount() se for zero ocupa a area totaal
         */

        //Contar os componentes
        allComponentsInLandHost = mainWindow.cmdPack.menuItems.size();

        componentWidth = mainWindow.cmdPack.menuItems.get(0).width;
        componentHeight = mainWindow.cmdPack.menuItems.get(0).height;

        // this.setSize(mainWindow.cmdPack.menuItems.get(0).getSize().width,300);//
        this.setSize(mainWindow.bookIn.getSize().width / 2, mainWindow.bookIn.getSize().height / 2);
    }

    public int getWidthAvailableAreaInLandHost() {
        availableWidthLandHost = mainWindow.cmdPack.getSize().width - componentWidth * allComponentsInLandHost;
        return availableWidthLandHost;
    }

    public int getHeightAvailableAreaInLandHost() {
        int fulledArea = mainWindow.cmdPack.menuItems.get(mainWindow.cmdPack.menuItems.size() - 1).getLocation().y + mainWindow.cmdPack.menuItems.get(mainWindow.cmdPack.menuItems.size() - 1).getSize().height;
        availableHeightLandHost = mainWindow.cmdPack.getSize().height - fulledArea;
        return availableHeightLandHost;
    }

    public void setLocationInLandHost() {

        compP1 = mainWindow.cmdPack.menuItems.get(1).getLocation();
        compP2 = mainWindow.cmdPack.menuItems.get(2).getLocation();
        int compPA1 = compP1.y + mainWindow.cmdPack.menuItems.get(1).getSize().height;
        int compPA2 = compP2.y;
        componentsInterval = compPA2 - compPA1;
        componentsIntervalCount = mainWindow.cmdPack.menuItems.size() - 1;
        int lastComponentHeight = mainWindow.cmdPack.menuItems.get(1).height;
       // this.setLocation(5,mainWindow.cmdPack.menuItems.get(mainWindow.cmdPack.menuItems.size()-1).getLocation().y+ lastComponentHeight+componentsInterval+3);
        // this.setLocation(5,mainWindow.cmdPack.menuItems.get(mainWindow.cmdPack.menuItems.size()-1).getLocation().y+ mainWindow.cmdPack.menuItems.get(mainWindow.cmdPack.menuItems.size()-1).getSize().height+5);
        // this.setLocation(mainWindow.pnlActivity.getLocation().x + mainWindow.getWidth()/2 - this.getWidth()/2,5);
        int cordX, cordY;
        cordX = mainWindow.bookIn.bookset.getLocation().x + mainWindow.bookIn.bookset.getWidth() / 2 - this.getWidth() / 2;
        cordY = mainWindow.bookIn.bookset.getLocation().y + mainWindow.bookIn.bookset.getHeight() / 3 - this.getHeight() / 2;
        this.setLocation(cordX, cordY);

    }

    public int getComponentsCount() {
        return varComponentsCount;
    }

    public void setBackgroundColor() {
        this.setBackground(new Color(48, 57, 66));
    }

    public void setProperties() {
        this.setLayout(null);
        borderColor = setColor(66, 76, 85);
        intwinBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        this.setBorder(intwinBorder);
        setBackgroundColor();
        setLocationInLandHost();
        handleBar = new DialogBar();
        this.add(handleBar);
        iwBody = new DialogInSets();
        this.add(iwBody);
        setVisible(true);

    }

    public Color setColor(int R, int G, int B) {
        Color color = new Color(R, G, B);
        return color;
    }

    private class HandleDialog implements MouseListener, MouseMotionListener {

        public void mousePressed(MouseEvent evento) {
            getLocal = evento;
            handleBar.setBackground(new Color(85, 94, 102));
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
            handleBar.setBackground(new Color(125, 132, 139));
        }

        public void mouseDragged(MouseEvent evento) {
            location = getLocation(location);

            int x = location.x - getLocal.getX() + evento.getX();
            int y = location.y - getLocal.getY() + evento.getY();
            if (x >=1
                    && x <= mainWindow.bookIn.bookset.getWidth() - getWidth()-1
                    && y >=1
                    && y <= mainWindow.bookIn.bookset.getHeight() - getHeight()-1){
                setLocation(x, y);
            }
        }

        public void mouseMoved(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {
            handleBar.setBackground(new Color(125, 132, 139));
        }

    }

    private class DialogBar extends JPanel {

        public DialogBar() {
            super();
            setProperties();
        }

        public void setProperties() {
            // this.setBackground(new Color(125, 132, 139));
            this.setBackground(new Color(85, 94, 102));

            this.setVisible(true);
            this.setOpaque(true);
            this.setLayout(null);
            this.setSize(598, mainWindowHost.cmdPack.menuItems.get(1).height);
            this.setLocation(1, 1);
            lblWork = new JLabel(strWork.toUpperCase());
            lblWork.setVisible(true);
            lblWork.setForeground(Color.WHITE); //cor do texto
            fontTitleText = new Font("Futura MD BT", Font.BOLD, 14);//propriedades da fonte
            fontMetrics = getFontMetrics(fontTitleText);
            fontMetrics.stringWidth(strWork);//o comprimento do texto definido
            lblWork.setSize(fontMetrics.stringWidth(strWork), fontMetrics.getHeight());// o tamanho da Label que contem o texto
            lblWork.setFont(fontTitleText);//atribui a fonte ao texto do Label
            lblWork.setLocation(10, this.getSize().height / 2 - lblWork.getSize().height / 2);
            // lblWork.setLocation(this.getSize().width/2-lblWork.getSize().width/2,this.getSize().height/2-lblWork.getSize().height/2);
            add(lblWork);
        }

    }

}
