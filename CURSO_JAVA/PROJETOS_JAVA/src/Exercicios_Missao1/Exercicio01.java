package Exercicios_Missao1;
/*
 * Autor: Alexandre Wilian Nikitin
 * Data: 20/02/2022
 */
public class Exercicio01 {

	public static void main(String[] args) {
		//Cria as variaveis
		double C = 0, K = 0, Re = 0, Ra = 0, F = 0;
						
		//Define um valor para a temperatura em C
		C = 32;
					
		//Converte C para K
		K = C + 273.15;
						
		//Converte C para Re
		Re = C * 0.8;
						
		//Converte C para Ra
		Ra = C * 1.8 + 32 + 459.67;
						
		//Converte C para F
		F = C * 1.8 + 32;
						
		//Printa os valores
		System.out.printf("\nSua temperatura em �C foi de: %.2f", C);
		System.out.printf("\nConvertido para Kelvin foi de: %.2f", K);
		System.out.printf("\nConvertido para R�aumur foi de: %.2f", Re);
		System.out.printf("\nConvertido para Rankine foi de: %.2f", Ra);
		System.out.printf("\nConvertido para Fahrenheit foi de: %.2f", F);
	}

}
