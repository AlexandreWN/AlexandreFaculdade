package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio05 {

	public static void main(String[] args) {
		//variaveis
		double Volume = 0, Raio = 0, Altura = 0, Pi = 3.14159;
		
		//Define valor para as variaveis
		Raio = 32 * 2;
		Altura = 6;
		
		//Realiza o calculo
		Volume = Pi * Raio * Altura;
		
		//Retorna o valor encontrado
		System.out.printf("O volume encontrado foi: %f", Volume);
	}

}
