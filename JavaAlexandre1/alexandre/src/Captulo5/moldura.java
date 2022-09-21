package Captulo5;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class moldura extends JFrame{
	public moldura(){
		this.setTitle("Cap 5 - Escutadores de Teclado e Mouse");
		this.setAlwaysOnTop(true);
		this.setExtendedState(NORMAL);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		painelD2 P1 = new painelD2("centro");
		painelD2 P2 = new painelD2("sul");
		
		this.add(P1, BorderLayout.CENTER);
		this.add(P2, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
