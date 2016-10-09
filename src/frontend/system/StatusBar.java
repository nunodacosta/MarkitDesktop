/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.system;


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
public class StatusBar extends JPanel {

    private int x, y, w, h,hC,wP,cXP,cYP,minW,minH;
    private String strTxt, strHolderText;
    private int width, height, cordX, cordY;
    private JLabel lblText;
    private Font fText;
    private Component actualC,previousC,hostC;
    private FontMetrics fontMetrics;

    public StatusBar() {
      
       
       // StartComponents();
      
     //   AddComponents();
    }
   
   public StatusBar(int varX,int varY, int varW, int varH){
       x=varX;
       y=varY;
       w=varW;
       h=varH;
       Settings();
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
        if (x==0 & y==0 & w==0 & h==0){
            w=setWidthByParent();
            h=setHeighByParent();
            setSize(w,h);
            x=setCordXByParent();
            y=setCordYByParent();
        }else {
            setSize(w,h);
            setLocation(x, y);
        }
        setVisible(true);
        setLayout(null);
        setBackground(BackColor());
        addMouseListener(new HandleStatusBar());
        addMouseMotionListener(new HandleStatusBar());
    }

    private Color BackColor() {
        return new  startsystem.LoadSettings().readBoundColor();
    }

    private Color BorderColor() {
        return new Color(100, 100, 100);
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
        /**
         * Verifica o componente onde se fará o outprint do texto.
         * Nesse componente ser+a detectado se existe JLabel para centrar
         * a fonte
         */
        
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
    
    private int setCordXByParent(){
        
         for (int i=0;i<getParent().getComponentCount();i++){
            if(i==0){
                //A cordenada X do primeiro componente em MainWindow
                actualC=getParent().getComponent(i);
                cordX=actualC.getLocationOnScreen().x;
            }
        }
        return cordX; 
    }
    private int setCordYByParent(){
        /**
         * A cordenada y é obtida com a soma das alturas dos componentes
         * em MainWindow
         */
        for (int i=0;i<getParent().getComponentCount();i++){
            if(i==0){
                // Desenvolver Exception (tem de ser fornecidos parametros)
                 actualC=getParent().getComponent(i);
                 cordY=actualC.getHeight();
            }else if(i>0){
                //A cordenada X do primeiro componente em MainWindow
                actualC=getParent().getComponent(i);
                previousC=getParent().getComponent(i-1);
                cordY=getParent().getHeight()-(previousC.getHeight()+previousC.getHeight());
            }
        }
        return cordY;
    }
    private int setWidthByParent(){
        /**
         * Obetenção do comprimento
         * O método deverá prever o alinhamento em comprimento com os
         * componentes existentes no hospedeiro
         */
        
         for (int i=0;i<getParent().getComponentCount();i++){
            if(i==0){
                // Desenvolver Exception (tem de ser fornecidos parametros)
                actualC=getParent().getComponent(i);
                wP=getParent().getWidth()-(actualC.getLocationOnScreen().x + actualC.getWidth());
            }else if(i>0){
                actualC=getParent().getComponent(i);
                previousC=getParent().getComponent(i-1);
                wP=getParent().getWidth()-(previousC.getLocationOnScreen().x + previousC.getWidth()+ actualC.getWidth());
                
            }
           
        }
      
        
     return wP;   
    }
    
    private int setHeighByParent(){
        /**
         * Obtenção da altura
         * verifica todos os componentes existentes no componente onde se vai
         * alojar (MainWindow). Faz a soma das alturas de todos esses componenets
         * mais o intervalo entre eles. Este é o valor Y para este componente
         * A altura será determinada pela diferença entre a altura total do
         * componente hospedeiro e a soma anterior, determinando-se desse
         * modo o espaço disponivel para defenir a altura deste componente
         * 
         * Object obj=getParent().getClass().getSimpleName().hashCode();
            if (obj.equals(getParent().getClass().getSimpleName().hashCode())){
            JOptionPane.showMessageDialog(null,getParent().getName()+"\n",getClass().getSimpleName().toString(),1,null); 
         */
        
        for (int i=0;i<getParent().getComponentCount();i++){
            if(i==0){
                // Desenvolver Exception (tem de ser fornecidos parametros)
                 actualC=getParent().getComponent(i);
                 hC=getParent().getHeight()-actualC.getHeight();
            }else if(i>0){
                actualC=getParent().getComponent(i);
                previousC=getParent().getComponent(i-1);
                if(previousC.getSize().height==actualC.getSize().height){
                     hC=getParent().getHeight()-(actualC.getHeight()+previousC.getHeight());
                }
               
                
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

    private class HandleStatusBar implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {
            Object obj=getParent().getClass().getSimpleName().hashCode();
            if (obj.equals(getParent().getClass().getSimpleName().hashCode())){
            JOptionPane.showMessageDialog(null,getParent().getName()+"\n",getClass().getSimpleName().toString(),1,null); 
            }
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
    
    
}
