package Captulo5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class painel extends JPanel implements KeyListener{
	private String Id_P;
	painel(String Posicao){
		this.Id_P = Posicao;
		switch(Posicao) {
			case "centro":
				this.setPreferredSize(new Dimension(800,500));
				this.setBackground(Color.green);
				
				//o método abaixo permite que o painel Central processe os eventos do teclado
				this.addKeyListener(this);
				//detrmina o foco no painel Central
				this.setFocusable(true);
				break;
			case "sul":
				this.setPreferredSize(new Dimension(800,100));
				this.setBackground(Color.black);
				break;
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D desenho2D = (Graphics2D) g;
		if(this.Id_P == "centro") {
			//Desenha retangulo verde no painel de cima
			g.setColor(this.getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			
			//Desenha um quadrado preto com borda branca espessura 3
			g.setColor(Color.black);
			g.fillRect(50, 50, 100, 100);
			
			desenho2D.setStroke(new BasicStroke(3));
			g.setColor(Color.white);
			g.drawRect(50, 50, 100, 100);
			
			//Desenha triangulo azul com borda preta espessura 2
			desenho2D.setStroke(new BasicStroke(2));
			
			int[] pontosX = {650,600,700};
            int[] pontosY = {0,100,100};
            
            g.setColor(Color.blue);
            g.fillPolygon(pontosX, pontosY, 3);
            
            g.setColor(Color.black);
            g.drawPolygon(pontosX, pontosY, 3);
		}
		else{
			//Desenha retangulo preto no painel de cima
			g.setColor(this.getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Você liberou a tecla " + e.getKeyChar());
		System.out.println("Você liberou a tecla " + e.getKeyCode());
	}
}
