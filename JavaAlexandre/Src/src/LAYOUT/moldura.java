package LAYOUT;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class moldura extends JFrame {

	moldura(int x, int y, int localeX, int localeY, String name){
		switch(name){
			case "a":
				this.getContentPane().setBackground(Color.BLACK);
				break;
			case "b":
				this.getContentPane().setBackground(Color.CYAN);
				break;
			case "c":
				this.getContentPane().setBackground(Color.GREEN);
				break;
		}
		this.setSize(x,y);
		
		this.setLocation(localeX, localeY);
		this.setTitle(name);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
