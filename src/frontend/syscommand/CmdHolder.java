/*
 Classe para dividir as categorias dos comandos
 Requere um nome (Ficheiro ; Gerir; Artigos
 Recebe comandos . Para este caso cada holder conterá dois comandos
 Cada holder irá estar contido no cmdset
 */
package frontend.syscommand;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nuno
 */
public class CmdHolder extends JPanel {

    private int x, y, w, h,hC,wP,cXP,cYP,minW,minH;
    private String strTxt, strHolderText;
    private int width, height, cordX, cordY;
    private JLabel lblText;
    private Font fText;
    private Component actualC,previousC,hostC;
    private FontMetrics fontMetrics;

    public CmdHolder(String varStrTxt, int varX, int varY, int varW, int varH) {
        x = varX;
        y = varY;
        w = varW;
        h = varH;
        strTxt = varStrTxt.toUpperCase();
        StartComponents();
        Settings();
        AddComponents();
    }
     public CmdHolder(String varStrTxt) {
       
        strTxt = varStrTxt.toUpperCase();
        StartComponents();
        Settings();
        AddComponents();
    }
    
      public CmdHolder(String varStrTxt,int varW, int varH) {
        w = varW;
        h = varH;
        strTxt = varStrTxt.toUpperCase();
        StartComponents();
        Settings();
        AddComponents();
    }
    
   
     
    public void UpdateHeight(){
        /**
         * Actualiza a altura quando:
         * são adicionados componentes;
         * é reposicionado por junção de outro componente no parent
         * 
         */
    }
    
   
    
    private int setCordXByHost(){
         /* preferencialmente utilizar no construtor que só tem string
        rever !!!
        */
         cXP=getParent().getLocation().x+5;
        return cXP;
    }
    private int setCordYByHost(){
          /* preferencialmente utilizar no construtor que só tem string
        rever !!!
        */
        cYP=getParent().getLocation().y;
        return cYP;
    }
    private void Settings() {
        /*se não houver parametros para w e h serão atribuidos automaticamente
        com valores de w para o width doo componente hospedeiro e para h
        a soma das heigh dos componentes internos
        */
        if (w==0 & h==0 ){
            setSize(setWidthByParent(),setHeighByComponentsIn());
        }else {
              setSize(w, h);
        }
          
        /*
         if(x==0 & y==0){
           setLocation(setCordXByHost(),setCordYByHost());
        }else {
             setLocation(x, y);
        }
        */
       
        setLocation(x, y);
        setVisible(true);
        setLayout(null);
        setBackground(Color.BLACK);
        setOutText();
        setFont();
        addMouseListener(new HandleCmdHolder());
        addMouseMotionListener(new HandleCmdHolder());
    }

    private Color BackColor() {
        return new Color(0, 0, 0);
    }

    private Color BorderColor() {
        return new Color(0, 0, 0);
    }

    public void Retract() {
        /**
         * remove todos os componentes do parent component e limita o espaço
         * ocupado ao seus limites
         */
    }

    public void Expand() {
        /**
         * Adiciona todos os componentes removidos e reposiciona nas suas
         * posições originais No futuro este metodo irá ser desenvolvido para
         * fiuncionar em conjunto com a classe struct
         */
    }

    public String getOutText() {
        return lblText.getText();
    }
    
    public void UpdateOutText(String varStrTxt){
        strTxt=varStrTxt;
        lblText.setText(strTxt.toUpperCase()); 
        setFont();
    }
    
    private void setOutText(){
        lblText.setText(strTxt.toUpperCase()); 
    }
    
    public void setFont() {
        
        fText = new Font("Futura MD BT", Font.BOLD, 14);//propriedades da fonte
        lblText.setForeground(TextColor()); //cor do texto
        fontMetrics = getFontMetrics(fText);
        fontMetrics.stringWidth(getOutText());//o comprimento do texto definido
        lblText.setSize(fontMetrics.stringWidth(getOutText()), fontMetrics.getHeight());// o tamanho da Label que contem o texto
        lblText.setLocation(getWidth() / 2 - getTextWidth() / 2, getHeight() / 2 - getTextHeight() / 2);//centra a label(com  o texto ) no espa�o do bot�o
        lblText.setFont(fText);//atribui a fonte ao texto do Label

    }
    private void StartComponents(){
        lblText=new JLabel();
    }
    private int setWidthByParent(){
        hostC=getParent();
        wP=hostC.getWidth()-10;
        
     return wP;   
    }
    
    private int setHeighByComponentsIn(){
        /**
         * verifica todos os comonentes que contem e retorna o total 
         * calculado para a soma da altura de cada componente mais o intervalo
         * definido entre cada um deles
         * 
         * Criar excepção: se componentes localisados com y inferior
         * a minH -> value=60
         */
         hC=w;
     
        for (int i=0;i<getComponentCount();i++){
            if(i==0){
                 actualC=getComponent(i);
                 setSize(w,actualC.getWidth());
            }else if(i>0){
                actualC=getComponent(i);
                previousC=getComponent(i-1);
                hC=actualC.getHeight()+previousC.getHeight();
                
            }
           
        }
        return hC;
    }
    
   
    private Color TextColor() {
        return new Color(255, 255, 255);
    }

    public int getTextWidth() {
        return lblText.getSize().width;
    }

    public int getTextHeight() {
        return lblText.getSize().height;
    }

    private void AddComponents() {
        add(lblText);
    }

    private class HandleCmdHolder implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {
            JOptionPane.showMessageDialog(null,getParent().getClass().getCanonicalName().toString(),"teste",1,null); 
           
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {
        
        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }

    }
    
    private class HolderBar extends JPanel{
        
    }
}
