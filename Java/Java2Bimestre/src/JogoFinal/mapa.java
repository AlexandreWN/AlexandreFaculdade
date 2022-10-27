package JogoFinal;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class mapa extends Rectangle{
	private int posX, posY;
    private int largura, altura;
    private Color corDeFundo, corDaBorda;
    private int espessuraBorda;

    public mapa(int posX, int posY, int largura, int altura, Color corDeFundo, Color corDaBorda, int espessuraBorda){
        this.posX = posX;
        this.posY = posY;
        this.largura = largura;
        this.altura = altura;
        this.corDeFundo = corDeFundo;
        this.corDaBorda = corDaBorda;
        this.espessuraBorda = espessuraBorda;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public int getLargura(){
        return largura;
    }

    public int getAltura(){
        return altura;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public void setLargura(int largura){
        this.largura = largura;
    }

    public void setAltura(int altura){
        this.altura = altura;
    }

    public void desenhar(Graphics2D g){
        g.setColor(this.corDeFundo);
		g.fillRect(this.posX, this.posY, this.largura, this.altura);

        g.setStroke(new BasicStroke(this.espessuraBorda));

        g.setColor(this.corDaBorda);
        g.drawRect(this.posX, this.posY, this.largura, this.altura);
    }
}
