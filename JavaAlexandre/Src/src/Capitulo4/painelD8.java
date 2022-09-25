package Capitulo4;
import java.text.Collator;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.*;

public class painelD8 extends JPanel{
    //declara os atributos do painel
    private int Id_P;
    private int Largura, Altura;
    private Color CorDeFundo;
    
    //Identifica qual painel est� sendo criado
    painelD8(int Id_painel){
        this.Id_P = Id_painel;
        if(Id_painel == 1) {
            //atribui valores para os atributos
            Largura = 500; Altura = 400;
            CorDeFundo = Color.green;
        }else {
            Largura = 500; Altura = 100;
            CorDeFundo = Color.black;
        }
        //define as propriedades do painel
        this.setPreferredSize(new Dimension(Largura, Altura));
        this.setBackground(CorDeFundo);
    }

    public void paintComponent(Graphics desenho) {
        Graphics2D desenho2D = (Graphics2D) desenho;
        int X = 0, Y = 0, L = this.getWidth(), A = this.getHeight();
        
        desenho.setColor(this.getBackground());
        desenho.fillRect(X, Y, L, A);
        
        
        if(this.Id_P == 1) {
            
            //Desenha Quadrado Vermelho
            desenho.setColor(Color.red);
            desenho.fillRect(100, 100, 130, 130);
            desenho.setColor(Color.black);
            desenho.drawOval(100, 100, 130, 130);
            
            //Desenha Circulo Azul Com A Marca��o Quadrada Laranja
            desenho.setColor(Color.blue);
            desenho.fillOval(0, 0, 30, 30);
            desenho.setColor(Color.orange);
            desenho.drawRect(0, 0, 30, 30);
            
            //Desenha Poligono
            desenho.setColor(Color.black);
            int[] pontosX_T1 = {100,170,135};
            int[] pontosY_T1 = {280,280,360};
            
            int[] pontosX_T2 = {400,350,455};
            int[] pontosY_T2 = {80,310,310};
            
            desenho.fillPolygon(pontosX_T1, pontosY_T1, 3);
            desenho.fillPolygon(pontosX_T2, pontosY_T2, 3);

            //desenha arco
            desenho.drawArc(0, 0, 70, 50, 0, 180);
            desenho.drawArc(220, 250, 60, 100, 0, -180);
            desenho.drawArc(220, 250, 60, 100, 0, -180);
            desenho.drawArc(0, 100, 60, 100, 90, 180);
            desenho.drawArc(0, 250, 60, 100, 90, -180);

            //arcos do desafio 08
            //Arco1
            desenho.setColor(Color.pink);
            desenho.fillArc(100, 0, 70, 50, 0, 180);
            desenho.setColor(Color.black);
            desenho.drawArc(100, 0, 70, 50, 0, 180);
            desenho.drawLine(100, 25, 170, 25);
            //Arco2
            desenho.setColor(Color.blue);
            desenho.fillArc(200, 0, 70, 50, 0, 180);
            desenho.setColor(Color.orange);
            desenho.drawArc(200, 0, 70, 50, 0, 180);
            desenho.drawLine(200, 25, 270, 25);


            desenho2D.setStroke(new BasicStroke(3));
            desenho2D.setColor(Color.red);
            desenho2D.fillRect(250, 250, 120, 120);
            desenho2D.setColor(Color.blue);
            desenho2D.drawRect(250, 250, 120, 120);
        }
        else {
            desenho.setColor(Color.white);
            desenho.drawRect(10, 10, 50, 70);
            
            //Desenha Circulo Amarelo
            desenho.setColor(Color.yellow);
            desenho.fillOval(250, -25, 50, 50);
            
            //Experimento
            desenho.setColor(Color.magenta);
            desenho.fillOval(300,  25,  70, 50);
            
            //Triangulo
            desenho.setColor(Color.yellow);
            int[] pontosX_T1 = {35,10,60};
            int[] pontosY_T1 = {45,80,80};
            
            desenho.fillPolygon(pontosX_T1, pontosY_T1, 3);

            //Triangulo2
            desenho.setColor(Color.yellow);
            int[] pontosX_T2 = {35,10,60};
            int[] pontosY_T2 = {45,10,10};
            
            desenho.drawPolygon(pontosX_T2, pontosY_T2, 3);
            
            //desenha linha
            desenho.drawLine(0, 0, this.getWidth(), this.getHeight());

            //desenha linha2
            desenho.setColor(Color.green);
            desenho.drawLine(0, this.getHeight(), this.getWidth(), 0);
        }
    }
}
