package Captulo4;

import javax.swing.JPanel;
import javax.swing.JPanel;
import java.text.Collator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.*;
public class painelD10 extends JPanel{
    //declara os atributos do painel
    private int Id_P;
    private int Largura, Altura;
    private Color CorDeFundo;
    
    //Identifica qual painel est� sendo criado
    painelD10(){
        //atribui valores para os atributos
        Largura = 650; Altura = 400;
        CorDeFundo = Color.white;
        //define as propriedades do painel
        this.setPreferredSize(new Dimension(Largura, Altura));
        this.setBackground(CorDeFundo);
    }

    public void paintComponent(Graphics desenho) {
        Graphics2D desenho2D = (Graphics2D) desenho;
        Font fonte = new Font ("Arial", Font.ITALIC, 20);
        
        desenho.setColor(this.getBackground());

        //Linhas pretas
        desenho2D.setStroke(new BasicStroke(10));
        desenho2D.setColor(Color.black);
        desenho2D.drawLine(30, 30, 30, 350);
        desenho2D.drawLine(30, 30, 600, 30);

        //Retangulo com a estrela
        desenho2D.setStroke(new BasicStroke(5));
        desenho2D.setColor(Color.cyan);
        desenho.fillRect(60, 60, 140, 280);
        desenho2D.setColor(Color.red);
        desenho.drawRect(60, 60, 140, 280);

        int[] pontosX = {130,140,170,150,160,130,100,110,90,120};
        int[] pontosY = {120,150,150,170,200,180,200,170,150,150};
        
        desenho2D.setColor(Color.white);
        desenho.fillPolygon(pontosX, pontosY, 10);
        desenho2D.setColor(Color.black);
        desenho.drawPolygon(pontosX, pontosY, 10);

        //Figura verde com a seta
        int[] pontosX1 = {400,550,490,310,250};
        int[] pontosY1 = {60,160,340,340,160};
        
        desenho2D.setColor(Color.GREEN);
        desenho.fillPolygon(pontosX1, pontosY1, 5);
        desenho2D.setColor(Color.black);
        desenho.drawPolygon(pontosX1, pontosY1, 5);

        int[] pontosX2 = {420,480,420,420,350,350,420};
        int[] pontosY2 = {160,200,240,220,220,180,180};
        
        desenho2D.setColor(Color.black);
        desenho.fillPolygon(pontosX2, pontosY2, 7);
        desenho2D.setColor(Color.white);
        desenho.drawPolygon(pontosX2, pontosY2, 7);

        //Nome da equipe
        desenho.setFont(fonte);
        desenho.setColor(Color.black);
        desenho.drawString("Equipe:", 520, 300);
        desenho.drawString("Alexandre", 520, 320);
        desenho.drawString("Wyllyan", 520, 340);
    }
}
