package Captulo6Labirinto;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class moldura extends JFrame{
    public moldura(){
		this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setTitle("Aula 05 - CAP06 - DETECTORES DE COLISÃO");
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		painel P1 = new painel();
		
		this.add(P1);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
