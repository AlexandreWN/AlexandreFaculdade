package Captulo4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class painel extends JPanel{
	//DESAFIO02
	//declara os atributos do painel
	private int Id_P;
	private int Largura, Altura;
	private Color CorDeFundo;
	
	//Identifica qual painel está sendo criado
	painel(int Id_painel){
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
		int X = 0, Y = 0, L = this.getWidth(), A = this.getHeight();
		
		desenho.setColor(this.getBackground());
		desenho.fillRect(X, Y, L, A);
		
		
		if(this.Id_P == 1) {
			
			//Desenha Quadrado Vermelho
			desenho.setColor(Color.red);
			desenho.fillRect(100, 100, 130, 130);
			
			//Desenha Circulo Azul Com A Marcação Quadrada Laranja
			desenho.setColor(Color.blue);
			desenho.fillOval(0, 0, 30, 30);
			desenho.setColor(Color.orange);
			desenho.drawRect(0, 0, 30, 30);
		}
		else {
			desenho.setColor(Color.white);
			desenho.drawRect(10, 10, 50, 70);
		}
	}
}
