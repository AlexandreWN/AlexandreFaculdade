package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio03 {

	public static void main(String[] args) {
		//Variaveis
		double alimentacao = 0, transporte = 0, mediaali = 0, mediatrans = 0;
		
		//insere os valores de alimentação e trasporte durante o mes
		alimentacao = 300;
		transporte = 207;
		
		//faz o calculo da média diaria levando em consideração 23 dias uteis no mes
		mediaali = alimentacao / 23;
		mediatrans = transporte / 23;
		
		//Retorna a média de gasto por dia
		System.out.printf("O aluno gastou em média %.2f de alimentação e %.2f de trasporte por dia durante o mês", mediaali, mediatrans);
	}

}
