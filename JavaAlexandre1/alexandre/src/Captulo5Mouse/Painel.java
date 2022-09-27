package Captulo5Mouse;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Painel extends JPanel implements MouseListener{

	private String ID_P;
	private int Altura, Largura;
	private Color CorDeFundo;
	private Color CorDeFundoPainelCentral = Color.black;
	private int Player1_PosX = 50, Player1_PosY = 50;
	
	Painel(String Posicao){
		
		this.ID_P = Posicao;
		switch (Posicao) {
		case "centro":
			this.setPreferredSize(new Dimension(800, 500));
			this.setBackground(CorDeFundoPainelCentral);
			this.addMouseListener(this);

			this.setFocusable(true);
			break;
			
		case "sul":
			this.setPreferredSize(new Dimension(800, 100));
			this.setBackground(Color.black);
			break;
		}
	}
	
	public void paintComponent(Graphics desenho) {
		
		Graphics2D desenho2D = (Graphics2D) desenho;//biblioteca com mais recursos
		Font fonte = new Font ("Arial", Font.PLAIN, 25);
		
		if (this.ID_P == "centro") { //caso seja painel 1
			desenho.setColor(this.CorDeFundoPainelCentral);//define a cor de fundo
			desenho.fillRect(0, 0, this.getWidth(), this.getHeight());//cria painel com tamanho do painel
			//cria quadrado

			desenho.setColor(Color.red);//cor do quadrado
			desenho.fillRect(Player1_PosX, Player1_PosY, 50, 50); //desenha retangulo preenchido.
			desenho2D.setStroke(new BasicStroke(3));//cria borda
			desenho.setColor(Color.green);
			desenho.drawRect(Player1_PosX, Player1_PosY, 50, 50); //desenha borda do retangulo.
			//cria triangulo
			//Desenhe (dentro do painel central) um tri�ngulo azul com borda preta (espessura =2)
			//na posicao x1=650, y1=0; x2=600, y2=100; x3=700, y3=100.
			desenho.setColor(Color.orange);
			int [] pontoX_T1 = {650, 600, 700};//define a posicao x do triangulo
			int [] pontoY_T1 = {0, 100, 100};//define a posicao y do triangulo
			desenho.fillPolygon(pontoX_T1, pontoY_T1, 3);// desenha o triangulo
			desenho2D.setStroke(new BasicStroke(2));//define borda
			desenho.setColor(Color.red);
			desenho.drawPolygon(pontoX_T1, pontoY_T1, 3);//desenha borda
		}
		else { //caso seja painel 2
			desenho.setColor(this.getBackground());//define a cor de fundo do painel sul
			desenho.fillRect(0, 0, this.getWidth(), this.getHeight());//define a posicao do painel
			
			//desenha texto
			desenho.setFont(fonte);
			desenho2D.setColor(Color.red);
			desenho2D.drawString("Alexandre Wilian Nikitin", 50, 50);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String msg = "";
		
		switch (e.getButton()) {
		case MouseEvent.BUTTON1: {
			msg = "Voce clicou com o botao esquerdo do mouse";
			Player1_PosX = 50;//define a posicao x do quadrado
			Player1_PosY = 50;//define a posicao y do quadrado
			System.out.println(msg);
			break;
		}
		case MouseEvent.BUTTON2:{
			msg = "Voce clicou com o botao central do mouse";
			System.out.println(msg);
			break;
		}
		case MouseEvent.BUTTON3:
			msg = "Voce clicou com o botao direto do mouse";
			Player1_PosX = 200;//define a posicao x do quadrado
			Player1_PosY = 300;//define a posicao y do quadrado
			System.out.println(msg);
			break;
		}
		this.repaint();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Posicao do mouse: X = " + e.getX() + " ; y = " + e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Voce liberou um botao do mouse!");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Voce Entrou na Area do painel!");
		this.CorDeFundoPainelCentral = Color.black;
		this.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Voce SAIU da Area do painel!");
		this.CorDeFundoPainelCentral = Color.white;
		this.repaint();
	}
}