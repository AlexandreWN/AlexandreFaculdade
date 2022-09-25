package Captulo6Labirinto;

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
	private jogador player1 = new jogador(50, 50, 50, 50, Color.white, Color.gray, 2);
	
	//Porta
	private porta porta = new porta(900, 600, 50, 50, Color.yellow, Color.gray, 2);

	//array de paredes
	private obstaculo paredes[] = new obstaculo[20];

	//prioridade
	private int prioridadeTop = 1;
	private int prioridadeRight = 1;
	private int prioridadeLeft = 1;
	private int prioridadeBottom = 1;

    painel(){
        this.setPreferredSize(new Dimension(1000,700));
        //o m�todo abaixo permite que o painel Central processe os eventos do teclado
        this.addKeyListener(this);
        //detrmina o foco no painel Central
        this.setFocusable(true);
    }

	private boolean verificaColisaoComPorta(){
		boolean resultado = true;

		int ptoDeColisaoPlayerY = player1.getPosY();
		int ptoDeColisaoPlayerX = player1.getPosX();
		int ptoDeColisaoInferiorPorta = porta.getPosY() + porta.getAltura();
		int ptoDeColisaoSuperiorPorta = porta.getPosY();
		int ptoDeColisaoDireitoPorta = porta.getPosX() + porta.getLargura();
		int ptoDeColisaoEsquerdoPorta = porta.getPosX();

		if(player1.getPosX() >= porta.getPosX() || player1.getPosY() >= porta.getPosY()){
			
			//Colisão Superior
			if (player1.getPosY() >= (porta.getPosY() + porta.getAltura()))
			{
				int ptoJ = player1.getPosX();
				int ptoK = player1.getPosX() + player1.getLargura();
				int ptoA = porta.getPosX();
				int ptoB = porta.getPosX() + porta.getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoInferiorPorta == ptoDeColisaoPlayerY)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO SUPERIOR");
					if (ptoDeColisaoInferiorPorta == ptoDeColisaoPlayerY)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
			}

			//Colisão Infeior
			if(player1.getPosY() + player1.getAltura() <= (porta.getPosY())){
				int ptoJ = player1.getPosX();
				int ptoK = player1.getPosX() + player1.getLargura();
				int ptoA = porta.getPosX();
				int ptoB = porta.getPosX() + porta.getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoSuperiorPorta == ptoDeColisaoPlayerY + player1.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO INFERIOR");
					if (ptoDeColisaoSuperiorPorta == ptoDeColisaoPlayerY + player1.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
			}

			//Colisão Direita
			if(player1.getPosX() + player1.getLargura() >= (porta.getPosX())){
				int ptoJ = player1.getPosY();
				int ptoK = player1.getPosY() + player1.getAltura();
				int ptoA = porta.getPosY();
				int ptoB = porta.getPosY() + porta.getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoEsquerdoPorta == ptoDeColisaoPlayerX + player1.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO DIREITA");
					if (ptoDeColisaoEsquerdoPorta == ptoDeColisaoPlayerX + player1.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
			}

			//colisão Esqueda
			if(player1.getPosX() <= (porta.getPosX() + porta.getLargura())){
				int ptoJ = player1.getPosY();
				int ptoK = player1.getPosY() + player1.getAltura();
				int ptoA = porta.getPosY();
				int ptoB = porta.getPosY() + porta.getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoDireitoPorta == ptoDeColisaoPlayerX)
					{
						System.out.println("COLISÃO ESQUERDA");
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO SUPERIOR");
					if (ptoDeColisaoDireitoPorta == ptoDeColisaoPlayerX)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
			}
			
		}
		return resultado;
	}

	private boolean verificaColisoes(){
		int cont = 0;
		boolean resultado = true;
		while(paredes[cont] != null){
			int ptoDeColisaoPlayerY = player1.getPosY();
			int ptoDeColisaoPlayerX = player1.getPosX();
			int ptoDeColisaoInferiorParede = paredes[cont].getPosY() + paredes[cont].getAltura();
			int ptoDeColisaoSuperiorParede = paredes[cont].getPosY();
			int ptoDeColisaoDireitoParede = paredes[cont].getPosX() + paredes[cont].getLargura();
			int ptoDeColisaoEsquerdoParede = paredes[cont].getPosX();


			//Colisão Superior
			if (player1.getPosY() >= (paredes[cont].getPosY() + paredes[cont].getAltura()))
			{
				int ptoJ = player1.getPosX();
				int ptoK = player1.getPosX() + player1.getLargura();
				int ptoA = paredes[cont].getPosX();
				int ptoB = paredes[cont].getPosX() + paredes[cont].getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO SUPERIOR");
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
			}

			//Colisão Infeior
			if(player1.getPosY() + player1.getAltura() <= (paredes[cont].getPosY())){
				int ptoJ = player1.getPosX();
				int ptoK = player1.getPosX() + player1.getLargura();
				int ptoA = paredes[cont].getPosX();
				int ptoB = paredes[cont].getPosX() + paredes[cont].getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player1.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO INFERIOR");
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player1.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
			}

			//Colisão Direita
			if(player1.getPosX() + player1.getLargura() >= (paredes[cont].getPosX())){
				int ptoJ = player1.getPosY();
				int ptoK = player1.getPosY() + player1.getAltura();
				int ptoA = paredes[cont].getPosY();
				int ptoB = paredes[cont].getPosY() + paredes[cont].getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player1.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO DIREITA");
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player1.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
			}

			//colisão Esqueda
			if(player1.getPosX() <= (paredes[cont].getPosX() + paredes[cont].getLargura())){
				int ptoJ = player1.getPosY();
				int ptoK = player1.getPosY() + player1.getAltura();
				int ptoA = paredes[cont].getPosY();
				int ptoB = paredes[cont].getPosY() + paredes[cont].getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						System.out.println("COLISÃO ESQUERDA");
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO SUPERIOR");
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						System.out.println("COLISÃO SUPERIOR");
						this.prioridadeLeft = -1;
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
        g.setColor(new Color(30,30,30));
        g.fillRect(0, 0, getWidth(), getHeight());

        //cria paredes
        int i = 0;
        this.paredes[i] = new obstaculo(0, 0, 50, getHeight(), Color.gray, Color.black, 0);
        i++;
        this.paredes[i] = new obstaculo(50, 0, getWidth() - 50, 50, Color.gray, Color.black, 0);
        i++;
        this.paredes[i] = new obstaculo(getWidth() -50, 0 , 50, getHeight(), Color.gray, Color.black, 0);
        i++;
        this.paredes[i] = new obstaculo(50, getHeight() - 50, getWidth() - 50, 50, Color.gray, Color.black, 0);
		i++;
        this.paredes[i] = new obstaculo(50, 100, getWidth() - 200, 50, Color.gray, Color.black, 0);
		i++;
        this.paredes[i] = new obstaculo(100, 200, getWidth() -400, 50, Color.gray, Color.black, 0);
		i++;
        this.paredes[i] = new obstaculo(getWidth() -250, 200, 100, 50, Color.gray, Color.black, 0);
		i++;
		this.paredes[i] = new obstaculo(getWidth() -100, 200, 50, 50, Color.gray, Color.black, 0);
        i++;
		this.paredes[i] = new obstaculo(getWidth() -250, 300, 100, 200, Color.gray, Color.black, 0);
		i++;
		this.paredes[i] = new obstaculo(getWidth() -100, 300, 50, 200, Color.gray, Color.black, 0);
        i++;
		this.paredes[i] = new obstaculo(getWidth() -250, 550, 200, 50, Color.gray, Color.black, 0);
        i++;
		this.paredes[i] = new obstaculo(50, 300, getWidth() - 350, 50, Color.gray, Color.black, 0);
        i++;
		this.paredes[i] = new obstaculo(50, 400, getWidth() - 350, 50, Color.gray, Color.black, 0);
        i++;
		this.paredes[i] = new obstaculo(100, 500, getWidth() - 300, 100, Color.gray, Color.black, 0);
        i++;
		
		
		//desenha as paredes na tela
        int cont = 0;
        while(paredes[cont] != null){
            paredes[cont].desenhar(g2D);
            cont++;
        }
        //player
        player1.desenhar(g2D);

		//porta
		porta.desenhar(g2D);

        System.out.println("Atualizando o Painel Central");
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
					if(verificaColisoes() == true || prioridadeTop > 0){
						player1.setPosY(player1.getPosY() - 5);
					}
					this.prioridadeBottom = 1;
					this.prioridadeTop = 1;
				}
				break;
			case 40: //baixo
				if(player1.getPosY() < (this.getHeight() -50)){
					if(verificaColisoes() == true || prioridadeBottom > 0){
						player1.setPosY(player1.getPosY() + 5);
					}
					this.prioridadeTop = 1;
					this.prioridadeBottom = 1;
				}
				break;
			case 37: //esquerda
				
				if((player1.getPosX() != 0)){
					if(verificaColisoes() == true || prioridadeLeft > 0){
						player1.setPosX(player1.getPosX() - 5);
					}
					this.prioridadeRight = 1;
					this.prioridadeLeft = 1;
				}
				break;
			case 39: //direita
				
				if(player1.getPosX() < (this.getWidth() -50)){
					if(verificaColisoes() == true || prioridadeRight > 0){
						player1.setPosX(player1.getPosX() + 5);
					}
					this.prioridadeLeft = 1;
					this.prioridadeRight= 1;
				}
				break;
			default:
				System.out.println("Uma tecla sem função foi pressionada");
				break;
		}
		if(e.getKeyCode() == 37 || e.getKeyCode() == 38 || e.getKeyCode() == 39 || e.getKeyCode() == 40){
			System.out.println(player1.getPosX());
			System.out.println(player1.getPosY());
			
			if(verificaColisaoComPorta()){
				this.repaint();
			}
			else{
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//estemétodo não será utilizado, mas não pode ser apagado”;
	}
}
