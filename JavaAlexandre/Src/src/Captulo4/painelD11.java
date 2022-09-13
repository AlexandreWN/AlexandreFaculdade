package Captulo4;

import javax.swing.JPanel;
import java.text.Collator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;

public class painelD11 extends JPanel{
    //declara os atributos do painel
    private int Largura, Altura;
    private Color CorDeFundo;
    
    //Identifica qual painel est� sendo criado
    painelD11(){
        //atribui valores para os atributos
        Largura = 650; Altura = 400;
        CorDeFundo = Color.cyan;
        //define as propriedades do painel
        this.setPreferredSize(new Dimension(Largura, Altura));
        this.setBackground(CorDeFundo);
    }

    public void paintComponent(Graphics desenho) {
        Graphics2D desenho2D = (Graphics2D) desenho;
        Font fonte = new Font ("Arial", Font.ITALIC, 20);

        int X = 0, Y = 0, L = this.getWidth(), A = this.getHeight();
		
		desenho.setColor(this.getBackground());
		desenho.fillRect(X, Y, L, A);

        //Grama
        desenho.setColor(Color.green);
        desenho.fillRect(0,getHeight() -20,getWidth(), getHeight() -20);

        //VasoDeFlor com flor
        int[] pontosX = {10,40,30,20};
        int[] pontosY = {getHeight() -40,getHeight() -40,getHeight() -20,getHeight() -20};
        desenho.setColor(Color.gray);
        desenho.fillPolygon(pontosX, pontosY, 4);

        desenho.setColor(Color.green);
        desenho.drawLine(25, getHeight() -41, 25, getHeight() -70);
        
        int[] folha1X = {23,25,21};
        int[] folha1Y = {getHeight() -60,getHeight() -50,getHeight() -50};
        desenho.fillPolygon(folha1X, folha1Y, 3);

        int[] folha2X = {25,25,27};
        int[] folha2Y = {getHeight() -60,getHeight() -50,getHeight() -50};
        desenho.fillPolygon(folha2X, folha2Y, 3);

        desenho.setColor(Color.pink);
        int[] florX = {15,20,20,25,30,30,35};
        int[] florY = {getHeight() -70,getHeight() -75, getHeight() -80, getHeight() -75, getHeight() -80,getHeight() -75, getHeight() -70};
        desenho.fillPolygon(florX, florY, 7);
        desenho.fillOval(20, getHeight() -75, 10, 10);

        //Arvore
        desenho.setColor(Color.green);
        int[] arvoreX = {getWidth() -80, getWidth() -20, getWidth() -40, getWidth() -20, getWidth() -140, getWidth() -120, getWidth() -140};
        int[] arvoreY = {getHeight() -200, getHeight() -130, getHeight() -130, getHeight() -70, getHeight() -70, getHeight() -130, getHeight() -130};
        desenho.fillPolygon(arvoreX, arvoreY, 7);

        desenho.setColor(new Color(92,64,51));
        desenho.fillRect(getWidth() -95, getHeight() -70, 30, 50);
    }
}
