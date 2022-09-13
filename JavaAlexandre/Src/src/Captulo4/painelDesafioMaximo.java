package Captulo4;

import javax.swing.JPanel;
import java.text.Collator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class painelDesafioMaximo extends JPanel{
    //declara os atributos do painel
    private int Largura, Altura;
    private Color CorDeFundo;
    
    //Identifica qual painel est� sendo criado
    painelDesafioMaximo(){
        //atribui valores para os atributos
        Largura = 500; Altura = 500;
        CorDeFundo = Color.blue;
        //define as propriedades do painel
        this.setPreferredSize(new Dimension(Largura, Altura));
        this.setBackground(CorDeFundo);
    }

    private void nuvem(Graphics g, int x, int y){
        g.setColor(Color.gray);
        g.fillArc(x+20, y, 60, 50, 0, 180);
        g.fillArc(x-5, y+20, 60, 50, 90, 180);
        g.fillArc(x+45, y+20, 60, 50, -90, 180);

        g.fillRect(x+25, y+25, 50, 45);

        g.setColor(Color.black);
        g.drawArc(x+20, y, 60, 50, 0, 180);
        g.drawArc(x-5, y+20, 60, 50, 90, 180);
        g.drawArc(x+45, y+20, 60, 50, -90, 180);

        g.drawLine(x+25, y+70, x+80, y+70);
    }

    private void estrela(Graphics g, int x, int y){
        int[] pontosX = {x+60,x+70,x+90,x+75,x+85,x+60,x+35,x+45,x+30,x+50};
        int[] pontosY = {y+00,y+20,y+20,y+30,y+50,y+40,y+50,y+30,y+20,y+20};
        
        g.setColor(Color.white);
        g.fillPolygon(pontosX, pontosY, 10);
        g.setColor(Color.black);
        g.drawPolygon(pontosX, pontosY, 10);
    }

    private void arvore(Graphics g, int x, int y){
        
    }
     
    public void paintComponent(Graphics desenho) {
        Graphics2D desenho2D = (Graphics2D) desenho;
        Font fonte = new Font ("Arial", Font.ITALIC, 20);

        int X = 0, Y = 0, L = this.getWidth(), A = this.getHeight();
        
        desenho.setColor(this.getBackground());
        desenho.fillRect(X, Y, L, A);

        nuvem(desenho, 50, 50);
        estrela(desenho, 0,0);
        arvore(desenho, 100, 100);

    }
}
