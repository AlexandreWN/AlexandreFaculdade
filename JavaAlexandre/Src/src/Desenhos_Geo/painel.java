package Desenhos_Geo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class painel extends JPanel {
	painel(){
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.green);
	}
	
	public void paintComponent(Graphics g) {
		g.drawLine(50, 250, 150, 250);
		g.setColor(Color.red);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.blue);
		g.drawRect(100, 100, 100, 100);
	}
}
