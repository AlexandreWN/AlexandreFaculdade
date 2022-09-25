package Captulo06;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class moldura extends JFrame{
    public moldura(){
		this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setTitle("Aula 05 - CAP06 - DETECTORES DE COLISÃO");
		this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		painel P2 = new painel("norte");
		painel P1 = new painel("centro", P2);
		
		this.add(P1, BorderLayout.CENTER);
		this.add(P2, BorderLayout.NORTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
