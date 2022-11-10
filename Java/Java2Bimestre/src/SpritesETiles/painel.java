package SpritesETiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class painel extends JPanel{
	
	int contadorDePrints;
	
	private painel PPainel;
	private String ID_P;
	
	paredes[] parede;
	
	jogador player;
	
	objetos []obj;
	
	tileMap cenario;
	
	gameLoop loopDoJogo;

	spriteLoop  loopDoSprite;

	escutadorTeclado escutaTecl;
	
	painel(String Posicao){
		this.ID_P = Posicao;
		switch (Posicao) {
			case "centro":
			{
			    String caminho1 = "C:\\Users\\aluno\\Desktop\\AlexandreFaculdade\\Java\\Java2Bimestre\\res\\tiles\\GramaCima.png";
				this.setPreferredSize(new Dimension(768, 480));
				this.setBackground(Color.black);

				this.player = new jogador(50, 40, 48, 48);
				
				this.obj = new objetos[2];
				this.obj[0] = new objetos(200, 40, "TE" ,"chave");
				this.obj[1] = new objetos(300, 400, "BD" ,"moeda");
				
				this.cenario = new tileMap();
				
				escutaTecl = new escutadorTeclado();
				this.addKeyListener(escutaTecl);
				this.setFocusable(true);

				loopDoJogo = new gameLoop(this, escutaTecl);

				loopDoJogo.start();

				loopDoSprite = new spriteLoop(this, escutaTecl);

				loopDoSprite.start();

				break;
			}
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
			
			this.cenario.desenhar(g2D);
			player.desenhar(g2D);
			
			if(this.cenario.getCenaValida() == "TE") {
			    for(int i = 0; i < this.obj.length; i++) {
	                if(obj[i].cenario == "TE") {
	                    obj[i].desenhar(g2D);
	                }       
	            }
			}else if(this.cenario.getCenaValida() == "BD") {
                for(int i = 0; i < this.obj.length; i++) {
                    if(obj[i].cenario == "BD") {
                        obj[i].desenhar(g2D);
                    }       
                }
            }else if(this.cenario.getCenaValida() == "TD") {
                for(int i = 0; i < this.obj.length; i++) {
                    if(obj[i].cenario == "TD") {
                        obj[i].desenhar(g2D);
                    }       
                }
            }else if(this.cenario.getCenaValida() == "BE") {
                for(int i = 0; i < this.obj.length; i++) {
                    if(obj[i].cenario == "BE") {
                        obj[i].desenhar(g2D);
                    }       
                }
            }
		}
	}
	/*
	private void escritaPainelSul(Graphics g, Color cor, int x, int y, String texto, int tamanhoFonte, int style, String type) {
		Font fonte = new Font (type, style, tamanhoFonte);
		g.setFont(fonte);
		g.setColor(cor);
		g.drawString(texto, x, y);
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
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
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
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
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
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
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
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
			}
			cont++;
		}
		return resultado;
	}
	*/
}
