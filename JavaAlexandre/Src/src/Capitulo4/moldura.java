package Capitulo4;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class moldura extends JFrame{
	moldura(){
		this.setSize(500,500);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("Aula03 - CAP�TULO04 - FORMAS GEOMETRICAS");
		
		//define o layout da molduta
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		//centraliza a moldura na tela do computador
		this.setLocationRelativeTo(null);
		
		//libera a mem�ria depois que fecha a moldura
		this.setExtendedState(EXIT_ON_CLOSE);
		
		//cria paineis
		//painelD9 P1 = new painelD9(1);
		//painelD9 P2 = new painelD9(2);
		//this.add(P1);
		//this.add(P2);
		painelDesafioMaximo P11 = new painelDesafioMaximo();
		this.add(P11);
		
		//adapta o tamanho da moldura de acordo com os paineis adicionados
		this.pack();
		
		//mostra a moldura
		this.setVisible(true);
	}
}
