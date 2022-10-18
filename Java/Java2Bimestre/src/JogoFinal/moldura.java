package JogoFinal;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class moldura extends JFrame{
	
	public moldura() {
        this.setTitle("Jogo Treino");
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		painel P1 = new painel("centro");
		this.add(P1, BorderLayout.CENTER);
	
		this.pack();		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
