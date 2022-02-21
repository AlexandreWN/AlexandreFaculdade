package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio04 {

	public static void main(String[] args) {
		//Variaveis
		double cavalos = 0, massa = 0, altura = 0, segundos = 0;
		
		//determina os valores das variaveis
		massa = 9999;
		altura = 15;
		segundos = 60;
		
		//realiza o calculo
		cavalos = (massa * altura / segundos) / 745.6999;
		
		//retorna a quantidade de cavalos necessária
		System.out.printf("A quantidade de cavalos necessária é de: %f", cavalos);
	}

}
