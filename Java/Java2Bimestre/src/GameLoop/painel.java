package GameLoop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class painel extends JPanel implements KeyListener, Runnable, ActionListener{
	
	int contadorDePrints;
	
	private painel PPainel;
	private String ID_P;
	private Timer timer;
	private Thread GameLoop;
	private final int FPS = 60;
	
	private paredes parede[] = new paredes[20];
	
	private jogador player = new jogador(100, 100, 50, 50, Color.white, Color.red, 1);
	
	//prioridade
	private int prioridadeTop = 1;
	private int prioridadeRight = 1;
	private int prioridadeLeft = 1;
	private int prioridadeBottom = 1;
	
	painel(String Posicao){
		this.ID_P = Posicao;
		switch (Posicao) {
		case "centro":
			this.setPreferredSize(new Dimension(800, 500));
			this.setBackground(Color.black);
			
			this.addKeyListener(this);
		    this.setFocusable(true);
		    this.GameLoop = new Thread(this);
		    this.GameLoop.start();
			break;
			
		case "sul":
			this.setPreferredSize(new Dimension(800, 100));
			this.setBackground(Color.green);
			break;
		}
        
    }

	painel(String posicao, painel PP){
		this(posicao);
		this.PPainel = PP;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		if(this.ID_P == "centro"){
			g.setColor(this.getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			
			criaParedes(g);
			player.desenhar(g2D);
		}
		else{
			g.setColor(this.getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
			
			escritaPainelSul(g, new Color(0,0,0), 25, 25, "Alexandre Wilian Nikitin",25,Font.BOLD,"Arial");
			escritaPainelSul(g, new Color(0,0,255), 250, 60, "Data: 05/10/2022",25,Font.PLAIN,"Arial");
		}
	}
	
	private void escritaPainelSul(Graphics g, Color cor, int x, int y, String texto, int tamanhoFonte, int style, String type) {
		Font fonte = new Font (type, style, tamanhoFonte);
		g.setFont(fonte);
		g.setColor(cor);
		g.drawString(texto, x, y);
	}
	
	private void criaParedes(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
        //cria paredes
        int i = 0;
        this.parede[i] = new paredes(0, 0, 25, getHeight(), Color.blue, Color.white, 2);
        i++;
        this.parede[i] = new paredes(getWidth() -25, 0, 25, getHeight(), Color.blue, Color.white, 2);
        i++;
        this.parede[i] = new paredes(0, 0, getWidth(), 50, Color.blue, Color.white, 2);
        i++;
        this.parede[i] = new paredes(0, getHeight() -50, getWidth(), 50, Color.blue, Color.white, 2);
        i++;
        
        int cont = 0;
        while(parede[cont] != null){
            parede[cont].desenhar(g2D);
            cont++;
        }
        
        g2D.setColor(Color.blue);
        g2D.drawLine(2, 50, 23, 50);
        g2D.drawLine(getWidth() -23, 50, getWidth() -2, 50);
        g2D.drawLine(2, getHeight() -50, 23, getHeight() -50);
        g2D.drawLine(getWidth() -23, getHeight() -50, getWidth() -2, getHeight() -50);
	}
	
	private boolean verificaColisoes(){
		int cont = 0;
		boolean resultado = true;
		while(parede[cont] != null){
			int ptoDeColisaoPlayerY = player.getPosY();
			int ptoDeColisaoPlayerX = player.getPosX();
			int ptoDeColisaoInferiorParede = parede[cont].getPosY() + parede[cont].getAltura();
			int ptoDeColisaoSuperiorParede = parede[cont].getPosY();
			int ptoDeColisaoDireitoParede = parede[cont].getPosX() + parede[cont].getLargura();
			int ptoDeColisaoEsquerdoParede = parede[cont].getPosX();


			//Colisão Superior
			if (player.getPosY() >= (parede[cont].getPosY() + parede[cont].getAltura()))
			{
				int ptoJ = player.getPosX();
				int ptoK = player.getPosX() + player.getLargura();
				int ptoA = parede[cont].getPosX();
				int ptoB = parede[cont].getPosX() + parede[cont].getLargura();
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
			if(player.getPosY() + player.getAltura() <= (parede[cont].getPosY())){
				int ptoJ = player.getPosX();
				int ptoK = player.getPosX() + player.getLargura();
				int ptoA = parede[cont].getPosX();
				int ptoB = parede[cont].getPosX() + parede[cont].getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO INFERIOR");
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
						System.out.println("COLISÃO INFERIOR");
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
			}

			//Colisão Direita
			if(player.getPosX() + player.getLargura() >= (parede[cont].getPosX())){
				int ptoJ = player.getPosY();
				int ptoK = player.getPosY() + player.getAltura();
				int ptoA = parede[cont].getPosY();
				int ptoB = parede[cont].getPosY() + parede[cont].getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					System.out.println("Em Rota De Colisão");
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					System.out.println("COLISÃO DIREITA");
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
						System.out.println("COLISÃO DIREITA");
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
			}

			//colisão Esqueda
			if(player.getPosX() <= (parede[cont].getPosX() + parede[cont].getLargura())){
				int ptoJ = player.getPosY();
				int ptoK = player.getPosY() + player.getAltura();
				int ptoA = parede[cont].getPosY();
				int ptoB = parede[cont].getPosY() + parede[cont].getAltura();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		
		//Direita 39
		//Esquerda 37
		//Cima 38
		//Baixo 40
		//esc 27
		switch(e.getKeyCode()){
			case 38: //cima
				if(player.getPosY() != 0){
					if(verificaColisoes() == true || prioridadeTop > 0){
						player.setPosY(player.getPosY() - 5);
					}
					this.prioridadeBottom = 1;
					this.prioridadeTop = 1;
				}
				break;
			case 40: //baixo
				if(player.getPosY() < (this.getHeight() -50)){
					if(verificaColisoes() == true || prioridadeBottom > 0){
						player.setPosY(player.getPosY() + 5);
					}
					this.prioridadeTop = 1;
					this.prioridadeBottom = 1;
				}
				break;
			case 37: //esquerda
				
				if((player.getPosX() != 0)){
					if(verificaColisoes() == true || prioridadeLeft > 0){
						player.setPosX(player.getPosX() - 5);
					}
					this.prioridadeRight = 1;
					this.prioridadeLeft = 1;
				}
				break;
			case 39: //direita
				
				if(player.getPosX() < (this.getWidth() -50)){
					if(verificaColisoes() == true || prioridadeRight > 0){
						player.setPosX(player.getPosX() + 5);
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
			System.out.println(player.getPosX());
			System.out.println(player.getPosY());
			
			
				this.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.contadorDePrints = 0;
		this.timer = new Timer(1000, this);
		this.timer.start();
		
		while(this.GameLoop.isAlive()) {
			this.contadorDePrints++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this.contadorDePrints);
	}
}
