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
    Image imagemD1, imagemR1, imagemL1, imagemU1;
    Image imagemD2, imagemR2, imagemL2, imagemU2;
    Image imagemD3, imagemR3, imagemL3, imagemU3;
    Image imagemPlayer;

    public jogador(int posX, int posY, int largura, int altura){
        ImageIcon icon;

        this.posX = posX;
        this.posY = posY;
        this.largura = largura;
        this.altura = altura;
        this.corDeFundo = Color.white;
        
        icon = new ImageIcon("res/player/down1.png");
        this.imagemPlayer = icon.getImage();
        icon = new ImageIcon("res/player/down1.png");
        this.imagemD1 = icon.getImage();
        icon = new ImageIcon("res/player/down2.png");
        this.imagemD2 = icon.getImage();
        icon = new ImageIcon("res/player/down3.png");
        this.imagemD3 = icon.getImage();
        icon = new ImageIcon("res/player/left1.png");
        this.imagemL1 = icon.getImage();
        icon = new ImageIcon("res/player/left2.png");
        this.imagemL2 = icon.getImage();
        icon = new ImageIcon("res/player/left3.png");
        this.imagemL3 = icon.getImage();
        icon = new ImageIcon("res/player/right1.png");
        this.imagemR1 = icon.getImage();
        icon = new ImageIcon("res/player/right2.png");
        this.imagemR2 = icon.getImage();
        icon = new ImageIcon("res/player/right3.png");
        this.imagemR3 = icon.getImage();
        icon = new ImageIcon("res/player/up1.png");
        this.imagemU1 = icon.getImage();
        icon = new ImageIcon("res/player/up2.png");
        this.imagemU2 = icon.getImage();
        icon = new ImageIcon("res/player/up3");
        this.imagemU3 = icon.getImage();
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
        g.drawImage(imagemPlayer, this.posX, this.posY, this.largura, this.altura, null);
    }

    public void atualizaPosiicao(boolean left, boolean up, boolean right, boolean down){
        if(left){
            this.posX = this.posX - 3;
        } 
        if(right){
            this.posX = this.posX + 3;
        } 
        if(up){
            this.posY = this.posY - 3;
        } 
        if(down){
            this.posY = this.posY + 3;
        } 
    }

    public void atualizaSprite(boolean left, boolean up, boolean right, boolean down){
        if(left){
            if(this.imagemPlayer == this.imagemL1){
                this.imagemPlayer = this.imagemL2;
            }
            else if(this.imagemPlayer == this.imagemL2){
                this.imagemPlayer = this.imagemL3;
            }
            else{
                this.imagemPlayer = this.imagemL1;
            }
        } 
        if(right){
            if(this.imagemPlayer == this.imagemR1){
                this.imagemPlayer = this.imagemR2;
            }
            else if(this.imagemPlayer == this.imagemR2){
                this.imagemPlayer = this.imagemR3;
            }
            else{
                this.imagemPlayer = this.imagemR1;
            }
        } 
        if(up){
            if(this.imagemPlayer == this.imagemU1){
                this.imagemPlayer = this.imagemU2;
            }
            else if(this.imagemPlayer == this.imagemU2){
                this.imagemPlayer = this.imagemU3;
            }
            else{
                this.imagemPlayer = this.imagemU1;
            }
        } 
        if(down){
            if(this.imagemPlayer == this.imagemD1){
                this.imagemPlayer = this.imagemD2;
            }
            else if(this.imagemPlayer == this.imagemD2){
                this.imagemPlayer = this.imagemD3;
            }
            else{
                this.imagemPlayer = this.imagemD1;
            }
        } 
    }
}
