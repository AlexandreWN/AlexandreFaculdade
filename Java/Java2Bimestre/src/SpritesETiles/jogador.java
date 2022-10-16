package SpritesETiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class jogador{
	private int posX, posY;
    private int largura, altura;
    private Color corDeFundo, corDaBorda;
    private int espessuraBorda;
    Image imagemPlayer;

    public jogador(int posX, int posY, int largura, int altura){
        ImageIcon icon;

        this.posX = posX;
        this.posY = posY;
        this.largura = largura;
        this.altura = altura;
        this.corDeFundo = Color.white;
        
        icon = new ImageIcon("res/player/down1.png");
        System.out.print(icon);
        this.imagemPlayer = icon.getImage();
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

        g.drawImage(imagemPlayer, this.posX, this.posY, this.largura, this.altura, null);
    }

    public void atualizaPosiicao(boolean left, boolean up, boolean right, boolean down){
        if(left) this.posX = this.posX - 3;
        if(right) this.posX = this.posX + 3;
        if(up) this.posY = this.posY - 3;
        if(down) this.posY = this.posY + 3;
    }
}
