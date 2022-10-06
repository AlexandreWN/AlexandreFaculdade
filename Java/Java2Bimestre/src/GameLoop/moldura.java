package GameLoop;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/*
 *Aula 06 - Cap07 - Game Loop
 * */

public class moldura extends JFrame{
	
	public moldura() {
        this.setTitle("Aula 05 - CAP06 - DETECTORES DE COLISÃO");
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		
		painel P1 = new painel("centro");
		painel P2 = new painel("sul");
		this.add(P1, BorderLayout.CENTER);
		this.add(P2, BorderLayout.SOUTH);
		
		
		
		this.pack();		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
