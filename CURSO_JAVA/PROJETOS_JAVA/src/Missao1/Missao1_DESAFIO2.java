package Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Missao1_DESAFIO2 {

	public static void main(String[] args) {
		//printa no console "MISS�O 1 - DESAFIO 2"
		System.out.println("----------------------");
		System.out.println("|MISS�O 1 - DESAFIO 2|");
		System.out.println("----------------------");
		
		//cria as variaveis Num1, Num2 e Resultado do tipo double
		double Num1 = 0, Num2 = 0, Resultado = 0;
		
		//Atribui valores decimais as variaveis Num1 e Num2
		Num1 = 1.5;
		Num2 = 2.9;
		
		//Realisa  a multiplica��o das variaveis num1 e num2 e insere na variavel resultado
		Resultado = Num1 * Num2;
		
		//printa no console o resultado da multiplica��o
		System.out.printf("--------------------------------------------\n");
		System.out.printf("|O resultado de sua multiplica��o foi: %.2f|", Resultado);
		System.out.printf("\n--------------------------------------------\n");
		
		//printa no console "DESAFIO 2 CONCLU�DO!"
		System.out.println("----------------------");
		System.out.println("|DESAFIO 2 CONCLU�DO!|");
		System.out.println("----------------------");
	}

}