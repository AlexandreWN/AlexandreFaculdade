package JogoFinal;

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
	
	jogador player;
	
	gameLoop loopDoJogo;

	spriteLoop  loopDoSprite;

	escutadorTeclado escutaTecl;
	
	painel(String Posicao){
		this.ID_P = Posicao;
		switch (Posicao) {
			case "centro":
			{
				this.setPreferredSize(new Dimension(800, 600));
				this.setBackground(Color.black);

				this.player = new jogador(200, 100, 200, 200);
				
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

			player.desenhar(g2D);
		}
	}
}
