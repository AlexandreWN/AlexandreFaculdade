package Desenhos_Geo;
import java.awt.Color;

import javax.swing.JFrame;

public class moldura extends JFrame{
  moldura(){
	  this.setSize(500,500);
	  this.setAlwaysOnTop(true);
	  this.setResizable(false);
	  this.setTitle("Batata");
	  painel P1 = new painel();
	  this.add(P1);
	  this.setLocationRelativeTo(null);
	  this.setVisible(true);
	  
  }
}
