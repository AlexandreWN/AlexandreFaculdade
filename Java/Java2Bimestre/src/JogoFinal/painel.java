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
	
	private paredes parede[] = new paredes[20];
	
	jogador player;
	
	gameLoop loopDoJogo;

	spriteLoop  loopDoSprite;

	escutadorTeclado escutaTecl;
	
	painel(String Posicao){
		this.ID_P = Posicao;
		switch (Posicao) {
			case "centro":
			{
				this.setPreferredSize(new Dimension(1600, 900));
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
			criaParedes(g2D);
		}
	}
	/*
	private void escritaPainelSul(Graphics g, Color cor, int x, int y, String texto, int tamanhoFonte, int style, String type) {
		Font fonte = new Font (type, style, tamanhoFonte);
		g.setFont(fonte);
		g.setColor(cor);
		g.drawString(texto, x, y);
	}
	*/
	
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
}
