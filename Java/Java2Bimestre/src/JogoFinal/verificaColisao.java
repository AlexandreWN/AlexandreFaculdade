package JogoFinal;

import java.lang.reflect.Array;

public class verificaColisao {
	private int prioridadeBottom = 0, prioridadeLeft= 0, prioridadeRight= 0, prioridadeTop= 0;

    public boolean verificaColisoes(jogador player, paredes[]parede){
		int cont = 0;
		boolean resultado = true;
		while(parede[cont] != null){
			int ptoDeColisaoPlayerY = player.getPosY();
			int ptoDeColisaoPlayerX = player.getPosX();
			int ptoDeColisaoInferiorParede = parede[cont].getPosY() + parede[cont].getAltura();
			int ptoDeColisaoSuperiorParede = parede[cont].getPosY();
			int ptoDeColisaoDireitoParede = parede[cont].getPosX() + parede[cont].getLargura();
			int ptoDeColisaoEsquerdoParede = parede[cont].getPosX();


			//Colisão Superior
			if (player.getPosY() >= (parede[cont].getPosY() + parede[cont].getAltura()))
			{
				int ptoJ = player.getPosX();
				int ptoK = player.getPosX() + player.getLargura();
				int ptoA = parede[cont].getPosX();
				int ptoB = parede[cont].getPosX() + parede[cont].getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoInferiorParede == ptoDeColisaoPlayerY)
					{
						this.prioridadeTop = -1;
						resultado = false;
					}
				}
			}

			//Colisão Infeior
			if(player.getPosY() + player.getAltura() <= (parede[cont].getPosY())){
				int ptoJ = player.getPosX();
				int ptoK = player.getPosX() + player.getLargura();
				int ptoA = parede[cont].getPosX();
				int ptoB = parede[cont].getPosX() + parede[cont].getLargura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoSuperiorParede == ptoDeColisaoPlayerY + player.getAltura())
					{
						this.prioridadeBottom = -1;
						resultado = false;
					}
				}
			}

			//Colisão Direita
			if(player.getPosX() + player.getLargura() >= (parede[cont].getPosX())){
				int ptoJ = player.getPosY();
				int ptoK = player.getPosY() + player.getAltura();
				int ptoA = parede[cont].getPosY();
				int ptoB = parede[cont].getPosY() + parede[cont].getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoEsquerdoParede == ptoDeColisaoPlayerX + player.getLargura())
					{
						this.prioridadeRight = -1;
						resultado = false;
					}
				}
			}

			//colisão Esqueda
			if(player.getPosX() <= (parede[cont].getPosX() + parede[cont].getLargura())){
				int ptoJ = player.getPosY();
				int ptoK = player.getPosY() + player.getAltura();
				int ptoA = parede[cont].getPosY();
				int ptoB = parede[cont].getPosY() + parede[cont].getAltura();
				if ((ptoJ > ptoA && ptoJ < ptoB) || (ptoK > ptoA && ptoK < ptoB))
				{
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
				else if (ptoJ == ptoA && ptoK == ptoB)
				{
					if (ptoDeColisaoDireitoParede == ptoDeColisaoPlayerX)
					{
						this.prioridadeLeft = -1;
						resultado = false;
					}
				}
			}
			cont++;
		}
		return resultado;
	}
}
