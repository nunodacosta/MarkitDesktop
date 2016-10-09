package frontend.inoutdialog;


import frontend.display.DisplayCurrentWork;
import frontend.system.MainWindow;
import frontend.system.MainWindow;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DialogInSets extends JPanel {
    public InDialog window;
    public static Color borderColor;
    public static Color bodyBorderColor;
    public static String strTitle;
    public static JLabel lblTitle;
 public static DisplayCurrentWork displayMsg;
    public int width,height,posX,posY;
    public static Border intwinTBorder;
    public static Border intwinBodyBorder;
    public static MainWindow mainWindowHost;
    public static JPanel componentContainer;
    public static DataBoard pnlData;
        
    public DialogInSets(InDialog varWindow, String varStrTitle) {
        super();
        strTitle=varStrTitle;
        window=varWindow;
        setProperties();
    }
    public DialogInSets(){
        super();
        setProperties();
       
        pnlData= new DataBoard(5,20,getWidth()-10,getHeight()-100);
       
       displayMsg=new DisplayCurrentWork("DADOS DO CARTAZ");
        displayMsg.setSizeAsText(displayMsg.setWidthForText(),displayMsg.setHeightForText());
        displayMsg.setLocation(this.pnlData.getCordX()+7,this.pnlData.getCordY()-displayMsg.fontMetrics.getHeight()/2);
        displayMsg.setVisible(true);
      // this.add(displayMsg);
       this.add(pnlData);
     
    }
    public void setWindowTitle(String title){
        strTitle=title;
            lblTitle.setText(strTitle);
    }
    

    public void setProperties(){
       
       bodyBorderColor= new Color(66, 76, 85);
    // intwinBodyBorder=BorderFactory.createMatteBorder(1,1,1,1,bodyBorderColor);
      
       this.setBackground(new Color(240,240,240));
     
       this.setBorder(intwinBodyBorder);
        this.setVisible(true);
        this.setOpaque(true);
        this.setLayout(null);
        this.setSize(598,368);
        this.setLocation(1, 31);
   
    }
}
