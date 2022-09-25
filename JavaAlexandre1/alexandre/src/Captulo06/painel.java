package Captulo06;

import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;

public class painel extends JPanel implements KeyListener{
	private String Id_P;
	//player
	private jogador player1 = new jogador(100, 100, 50, 50, Color.black, Color.white, 2);
	
	//parede
	private obstaculo parede1 = new obstaculo(300, 100, 50, 250, Color.green, Color.black, 2);
	private obstaculo parede2 = new obstaculo(500, 0, 50, 250, Color.red, Color.black, 2);
	private obstaculo parede3 = new obstaculo(60, 450, 300, 50, Color.pink, Color.black, 2);
	private obstaculo parede4 = new obstaculo(580, 280, 125, 125, Color.blue, Color.black, 2);
	
	//array de paredes
	private obstaculo paredes[] = new obstaculo[20];

	//coloca as paredes no array

	
	private int posX = player1.getPosX();
	private int posY = player1.getPosY();
	private painel PPainel;

    painel(String posicao){
		this.Id_P = posicao;
        switch(posicao) {
			case "centro":
				this.setPreferredSize(new Dimension(800,500));
				this.setBackground(new Color(245,222,179));
				//o m�todo abaixo permite que o painel Central processe os eventos do teclado
				this.addKeyListener(this);
				//detrmina o foco no painel Central
				this.setFocusable(true);
				break;
			case "norte":
				this.setPreferredSize(new Dimension(800,100));
				this.setBackground(new Color(210,105,30));
				break;
            default:
                break;
		}
        
    }

	painel(String posicao, painel PP){
		this(posicao);
		this.PPainel = PP;
	}

	private void escritaPainel(Graphics g, int posX, int posY, int posXPlayer1, int posYPlayer1){
		//Cria Fonte
		Font fonte1 = new Font ("Bookman Old Style", Font.BOLD, 25);
		Font fonte2 = new Font ("Copperplate GothicBold", Font.BOLD, 25);
		
		g.setFont(fonte1);
        g.setColor(new Color(255,255,255));
        g.drawString("Alexandre Wilian Nikitin  23*09*2022", posX, posY);

		g.setFont(fonte2);
        g.setColor(new Color(0,0,0));
        g.drawString("Posição do jogador:", posX + 225, posY + 35);
        g.drawString("posX = " + posXPlayer1 + " - posY = " + posYPlayer1, posX + 245, posY + 65);
	}

	private boolean verificaColisoes(){
		int cont = 0;
		boolean resultado = true;
		while(paredes[cont] != null){
			int ptoDeColisaoPlayer = player1.getPosY();
				int ptoDeColisaoParede = paredes[cont].getPosY() + paredes[cont].getAltura();
				System.out.println("Parede " + cont + ": " + ptoDeColisaoParede);
				System.out.println("Player : " + ptoDeColisaoPlayer);

				if (player1.getPosY() >= (paredes[cont].getPosY() + paredes[cont].getAltura()))
				{
					int ptoJ = player1.getPosX();
					int ptoK = player1.getPosX() + player1.getLargura();
					int ptoA = paredes[cont].getPosX();
					int ptoB = paredes[cont].getPosX() + paredes[cont].getLargura();
					if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
					{
						System.out.println("Em Rota De Colisão");
						if (ptoDeColisaoParede == ptoDeColisaoPlayer)
						{
							System.out.println("COLISÃO SUPERIOR");
							resultado = false;
						}
					}
					else if (ptoJ == ptoA && ptoK == ptoB)
					{
						System.out.println("COLISÃO SUPERIOR");
						if (ptoDeColisaoParede == ptoDeColisaoPlayer)
						{
							System.out.println("COLISÃO SUPERIOR");
							resultado = false;
						}
					}
				}
			cont++;
		}
		return resultado;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		if(this.Id_P == "centro"){
			g.setColor(new Color(245,222,179));
			g.fillRect(0, 0, getWidth(), getHeight());

			//cria paredes
			int i = 0;
			this.paredes[i] = new obstaculo(300, 100, 50, 250, Color.green, Color.black, 2);
			i++;
			this.paredes[i] = new obstaculo(500, 0, 50, 250, Color.red, Color.black, 2);
			i++;
			this.paredes[i] = new obstaculo(60, 450, 300, 50, Color.pink, Color.black, 2);
			i++;
			this.paredes[i] = new obstaculo(580, 280, 125, 125, Color.blue, Color.black, 2);

			//desenha as paredes na tela
			int cont = 0;
			while(paredes[cont] != null){
				paredes[cont].desenhar(g2D);
				cont++;
			}
			//player
			player1.desenhar(g2D);

			System.out.println("Atualizando o Painel Central");
		}
		else{
			g.setColor(new Color(210,105,30));
			g.fillRect(0, 0, getWidth(), getHeight());

			escritaPainel(g, 25, 25, posX, posY);
			System.out.println("Atualizando o Painel Norte");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//estemétodo não será utilizado, mas não pode ser apagado”;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());

		switch(e.getKeyCode()){
			case 38: //cima
				if(player1.getPosY() != 0){
					if(verificaColisoes() == true){
						player1.setPosY(player1.getPosY() - 5);
					}
				}
				break;
			case 40: //baixo
				if(player1.getPosY() < (this.getHeight() -50)){
					player1.setPosY(player1.getPosY() + 5);
				}
				break;
			case 37: //esquerda
				if((player1.getPosX() != 0)){
					player1.setPosX(player1.getPosX() - 5);
				}
				break;
			case 39: //direita
				if(player1.getPosX() < (this.getWidth() -50)){
					player1.setPosX(player1.getPosX() + 5);
				}
				break;
			default:
				System.out.println("Uma tecla sem função foi pressionada");
				break;
		}
		if(e.getKeyCode() == 37 || e.getKeyCode() == 38 || e.getKeyCode() == 39 || e.getKeyCode() == 40){
			PPainel.posX = player1.getPosX();
			PPainel.posY = player1.getPosY();
			System.out.println(player1.getPosX());
			System.out.println(player1.getPosY());
			this.posX = player1.getPosX();
			this.posY = player1.getPosY();
			PPainel.repaint();
			this.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//estemétodo não será utilizado, mas não pode ser apagado”;
		
	}
}
