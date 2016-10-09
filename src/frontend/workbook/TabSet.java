/**
 * Esta classe vai criar os objectos Tab ( ou instancias da classe Tab)
 */
package frontend.workbook;

import frontend.syscommand.CommandContext;
import frontend.workbook.Tab;
import frontend.system.MainWindow;
import static frontend.system.MainWindow.minHeight;
import static frontend.system.MainWindow.minWidth;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class TabSet extends JPanel {

    private Component comp;
    public static int posX, posY, width, height;
    public static Border pagerBorder;
    public static Color borderColor;
    public static Tab tabInicio;
    public static Tab tabCampanha;
    public static Tab tabMatriz;
    public static Tab tabRegArtigo;
    public static MainWindow form;
    public static Font fTabText;
    public static FontMetrics fTabMetrics;
    public static JLabel lblTabModels;
    public static JLabel lblTabQuery;
    public static JLabel lblTabSetNew;
    public static ArrayList<String> classes = new ArrayList<String>();
    public static ArrayList<Component> componentTabs = new ArrayList<Component>();
    public static ArrayList<String> tabCollect = new ArrayList<String>();
    public static ArrayList<Object> objectAdded = new ArrayList<Object>();
    public static ArrayList<Tab> objTab = new ArrayList<Tab>();
    private int  wPerc,btwPercObjTab, btwObjTab, wObjTab,nObjTab,nBtwObjTab,wObjMatrix, wTT,wDif;
       
     
  //Strings para as novas abas
    // public static String iniTab="Inicio";

    public TabSet(int varPosX, int varPosY, int varWidth, int varHeight) {
        super();
        posX = varPosX;
        posY = varPosY;
        width = varWidth;
        height = varHeight;
        NObjTab();
        Settings();
        InitBookTabs();
        Pack();
         JOptionPane.showMessageDialog(null, "Classe: " +NObjTab() + ")", getClass().getSimpleName().toString(), 1, null);
    }

    public void InitBookTabs() {

        /*
         Calculo da percentagem para o comprimento das Tab. Este valor tem por
         matriz o comprimento do componente que contem as Tab (this)
         */
         //wPerc valor percentual da Tab
        //diferença entre os 100% e a soma  das percentagens das Tab
        // se a soma for 85% então este valor ser 100% - 85% =15%
        //  valor percentual para  o intervalo entre tab btwObjTab é 5%:
        // btwPercObjTab intervalo percentual entre object
        // btwObjTab intervalo entre objectos Tab
        //wObjTab comprimento das Tab
        wPerc = 24;
        nObjTab =4;//numero de tab
        nBtwObjTab = nObjTab - 1;// numero de intervalos
        wObjMatrix = getWidth();//o valor matriz para o comprimento (100%)
        //Update

        wObjTab = wPerc * wObjMatrix / 100;
        btwPercObjTab = (100 - (wPerc * nObjTab)) / nBtwObjTab;
        btwObjTab = btwPercObjTab * wObjMatrix / 100;
        wTT = (wObjTab * nObjTab) + (btwObjTab * nBtwObjTab);
        wDif = (wObjMatrix - wTT) / nBtwObjTab;

        tabInicio = new Tab("inicio", 0, 0, wObjTab, 60);
        tabCampanha = new Tab("CAMPANHA", wObjTab + btwObjTab + wDif, 0, wObjTab, 60);
        tabRegArtigo = new Tab("CARTAZ", (wObjTab * 2) + btwObjTab * 2 + wDif * 2, 0, wObjTab, 60);
        tabMatriz = new Tab("MATRIZ", (wObjTab * 3) + btwObjTab * 3 + wDif * 3, 0, wObjTab, 60);
        

    }

    private void Settings() {
        setSize(width, height);
        setLocation(this.posX, this.posY);
        setOpaque(false);
        setLayout(null);
    }

    public void RemoveTab() {
        /**
         * remover uma tab (indicada) e recolocar todas as outras
         * automaticamente
         */
    }

    public void CreateTab(String varStr, int varX, int varY, int varW, int varH) {
        /**
         * o objectivo é criar e alojar automaticamente novas abas
         */

        new Tab(getClass().getSimpleName() + objTab.size() + 1, 0, 0, 0, 0).setName(getClass().getSimpleName() + objTab.size() + 1);

    }

    private int NObjTab() {
        int nTab;
        for (Component C : getComponents()) {
            if (C.getClass().getSimpleName().equals("Tab")) {
                objTab.add((Tab) C);
            }
        }
        return nTab = objTab.size();
    }

    private void PackToAccess() {
        Component cp = null;
        for (Component C : getComponents()) {
            if (C.getClass().getSimpleName().equals("Tab")) {
                cp = C;
                objTab.add((Tab) C);
            }
        }
        JOptionPane.showMessageDialog(null, "Classe: " + cp.getClass().getSimpleName() + "(" + objTab.size() + ")", getClass().getSimpleName().toString(), 1, null);
    }

    private void Pack() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        add(tabInicio);
        add(tabCampanha);
        add(tabRegArtigo);
        add(tabMatriz);
       
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public int PosX() {
        return posX;
    }

    public int PosY() {
        return posY;
    }

    public int Width() {
        return width;
    }

    public int Height() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth() {
        return this.width;
    }

}
