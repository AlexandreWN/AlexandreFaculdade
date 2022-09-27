package Captulo5Mouse;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Moldura extends JFrame
{
	public Moldura()
	{
		this.setTitle("Cap 5 - Escutadores de Teeclado e Mouse");
		this.setAlwaysOnTop(true);
		this.setExtendedState(NORMAL);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		
		Painel P1 = new Painel("centro");
		Painel P2 = new Painel("sul");
		this.add(P1, BorderLayout.CENTER);
		this.add(P2, BorderLayout.SOUTH);
		
		
		
		this.pack();		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
		
	
	
}
