package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Cria as variaveis
		double Nota1 = 0, Nota2 = 0, Nota3 = 0, Nota4 = 0, Media = 0;
		int divisor = 4;
			
		//insere os valores nas variaveis
		Nota1 = 7;
		Nota2 = 8;
		Nota3 = 9;
		Nota4 = 5;
					
		//calcula a m�dia das notas
		Media = (Nota1 + Nota2 + Nota3 + Nota4) / divisor;
			
		//Retorna a m�dia do aluno
		System.out.printf("A nota m�dia do aluno foi de: %.2f", Media);
	}

}