package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio03 {

	public static void main(String[] args) {
		//Variaveis
		double alimentacao = 0, transporte = 0, mediaali = 0, mediatrans = 0;
		
		//insere os valores de alimenta��o e trasporte durante o mes
		alimentacao = 300;
		transporte = 207;
		
		//faz o calculo da m�dia diaria levando em considera��o 23 dias uteis no mes
		mediaali = alimentacao / 23;
		mediatrans = transporte / 23;
		
		//Retorna a m�dia de gasto por dia
		System.out.printf("O aluno gastou em m�dia %.2f de alimenta��o e %.2f de trasporte por dia durante o m�s", mediaali, mediatrans);
	}

}
