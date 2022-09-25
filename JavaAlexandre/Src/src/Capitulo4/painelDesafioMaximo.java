package Capitulo4;

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
    	int[] pontosX = {x,x+20,x+40};
        int[] pontosY = {y+30,y+0,y+30};
        
        g.setColor(new Color(0,128,0));
        g.fillPolygon(pontosX, pontosY, 3);
        
        g.setColor(new Color(150,75,0));
        g.fillRect(x+15, y+30, 10, 30);
    }
    
    private void carro(Graphics g, int x, int y) {
    	int[] pontosX = {x,x+20,x+20,x+50,x+50,x};
    	int[] pontosX1 = {x,x+30,x+30,x+50,x+50,x};
        int[] pontosY = {y,y,y+10,y+10,y+30,y+30};
        
        g.setColor(new Color(70,70,70));
        g.fillPolygon(pontosX, pontosY, 6);
        g.setColor(Color.black);
        g.drawPolygon(pontosX1, pontosY, 6);
        g.fillOval(x+5, y+30, 10, 10);
        g.fillOval(x+35, y+30, 10, 10);
    }
    
    private void predio(Graphics g , int x, int y) {
    	g.setColor(new Color(30,30,30));
    	g.fillRect(x, y, 60, 130);
    	
    	g.setColor(new Color(0,0,0));
    	g.fillRect(x+5, y+10, 10, 10);
    	g.fillRect(x+25, y+10, 10, 10);
    	g.fillRect(x+45, y+10, 10, 10);
    	
    	g.fillRect(x+5, y+30, 10, 10);
    	g.setColor(new Color(255,255,0));
    	g.fillRect(x+25, y+30, 10, 10);
    	g.setColor(new Color(0,0,0));
    	g.fillRect(x+45, y+30, 10, 10);
    	
    	g.setColor(new Color(255,255,0));
    	g.fillRect(x+5, y+50, 10, 10);
    	g.setColor(new Color(0,0,0));
    	g.fillRect(x+25, y+50, 10, 10);
    	g.fillRect(x+45, y+50, 10, 10);
    	
    	g.setColor(new Color(255,255,0));
    	g.fillRect(x+5, y+70, 10, 10);
    	g.fillRect(x+25, y+70, 10, 10);
    	g.setColor(new Color(0,0,0));
    	g.fillRect(x+45, y+70, 10, 10);
    	
    	g.fillRect(x+5, y+90, 10, 10);
    	g.fillRect(x+25, y+90, 10, 10);
    	g.fillRect(x+45, y+90, 10, 10);
    }
     
    public void paintComponent(Graphics desenho) {
        Graphics2D desenho2D = (Graphics2D) desenho;
        Font fonte = new Font ("Arial", Font.ITALIC, 20);

        int X = 0, Y = 0, L = this.getWidth(), A = this.getHeight();
        
        desenho.setColor(this.getBackground());
        desenho.fillRect(X, Y, L, A);

        
        desenho.setColor(Color.green);
        desenho.fillArc(-40,getHeight()-180,getWidth()+80,400,0,180);
        desenho.setColor(Color.black);
        desenho.drawArc(-40,getHeight()-180,getWidth()+80,400,0,180);
        
        desenho.setColor(Color.white);
        desenho.drawLine(0, getHeight()-60, getWidth(), getHeight()-60);
        desenho.drawLine(0, getHeight()-30, getWidth(), getHeight()-30);
        
        carro(desenho,30,getHeight()-80);
        carro(desenho,250,getHeight()-75);
        
        arvore(desenho,370,getHeight()-140);
        arvore(desenho,200,getHeight()-70);
        arvore(desenho,50,getHeight()-180);
        
        predio(desenho,110,getHeight()-270);
        predio(desenho,420,getHeight()-200);
        predio(desenho,240,getHeight()-300);
        
        estrela(desenho,30,30);
        estrela(desenho,300,200);
        estrela(desenho,250,60);
        
        nuvem(desenho,80,60);
        nuvem(desenho,350,100);
    }
}
