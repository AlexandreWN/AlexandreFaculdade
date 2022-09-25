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
		g.drawOval(0, 0, 150, 150);
		
		g.fillRect(300, 100, 50, 70);
		
		g.setColor(Color.pink);
		g.fillOval(300, 250, 100, 200);
		
		g.setColor(Color.gray);
		g.fillArc(40, 30, 100, 100, 0, 180);
		g.fillArc(70, 40, 100, 50, 90, -180);
		g.fillArc(10, 40, 100, 50, 90, 180);
		g.setColor(Color.blue);
		g.fillArc(40, 40, 100, 100, 180, 0);
	}
}