package PRINCIPAL;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class principal {
/*
 * Aula 01 - fundamentos de Java game 2d
 * 
 * criando e manipulando JFrame (moldura)
 * 
 * Autro: Alexandre Wilian Nikitin
 * Data: 10/08/2022
 */
	public static void main(String[] args) throws InterruptedException {
		//Marcando o tempo do jogo
		long Tempo = System.nanoTime();
		
		//importando a biblioteca JFrame
		JFrame Moldura = new JFrame();
		JFrame Moldura2 = new JFrame();
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Moldura.isVisible());
		Moldura.setVisible(true);
		Moldura2.setVisible(true);
		System.out.println(Moldura.isVisible());
		
		//sleep
		TimeUnit.SECONDS.sleep(5);

		//altera tamanho da molduta
		Moldura.setSize(500,500);
		Moldura2.setSize(500,500);
		System.out.println(Moldura.getSize());
		
		//mudar titulo da tela
		Moldura.setTitle("AAAAAA");
		Moldura2.setTitle("BBBBB");
		//Moldura sempre em primeiro plano
		Moldura.setAlwaysOnTop(true);
		Moldura2.setAlwaysOnTop(true);
		//n�o permitir mudar tamanho da tela
		Moldura.setResizable(false);
		//aparece no centro da tela
		Moldura.setLocationRelativeTo(null);
		Moldura2.setLocation(0, 0);
		//Alterando plano de fundo da moldura
		Moldura.getContentPane().setBackground(Color.CYAN);
		Moldura2.getContentPane().setBackground(Color.RED);
		TimeUnit.SECONDS.sleep(5);
		Moldura.getContentPane().setBackground(Color.BLUE);
		Moldura2.getContentPane().setBackground(Color.BLACK);
	}

}
