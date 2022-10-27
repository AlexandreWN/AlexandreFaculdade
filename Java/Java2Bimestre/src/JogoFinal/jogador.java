package JogoFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.text.html.HTMLDocument.BlockElement;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class jogador{
	private int posX, posY;
    private int largura, altura;
    private Color corDeFundo, corDaBorda;
    private int espessuraBorda;
    private int col = 1, row = 1;

    BufferedImage SpriteSheet = null;
    private BufferedImage imagemPlayer;

    public jogador(int posX, int posY, int largura, int altura){
        this.posX = posX;
        this.posY = posY;
        this.largura = largura;
        this.altura = altura;
        this.corDeFundo = Color.white;
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            SpriteSheet = loader.loadImage("/player.png");
        }catch(IOException e){
            e.printStackTrace();
        }
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

    public void atualizaPosicao(boolean left, boolean up, boolean right, boolean down){
        if(left){
            this.posX = this.posX - 3;
        } 
<<<<<<< HEAD
        else if(right){
            if(this.posX  + 200 <= 1600 -3){
                this.posX = this.posX + 3;
            }
        } 
        else if(up){
            if(this.posY - 30 >= 3){
                this.posY = this.posY - 3;
            }
            
        } 
        else if(down){
            if(this.posY  + 200 <= 850 -3){
                this.posY = this.posY + 3;
            }
=======
        if(right){
            this.posX = this.posX + 3;
        } 
        if(up){
            this.posY = this.posY - 3;
        } 
        if(down){
            this.posY = this.posY + 3;
>>>>>>> 810a51bbd430ce607960d58001779440342a48fe
        } 
    }

    public void atualizaSprite(boolean left, boolean up, boolean right, boolean down, boolean idle, boolean atk, boolean chorar){
        SpriteSheet ss = new SpriteSheet(SpriteSheet);
        this.imagemPlayer = ss.grabImage(col, row, 85, 100);

        if(left){
            if(this.col > 8 || this.col < 5){
                this.col = 5;
            }
            if(this.col < 8){
                this.col ++;
                this.row = 1;
            }
            else{
                this.col = 5;
                this.row = 1;
            }
        } 

        if(right){
            if(this.col > 4){
                this.col = 1;
            }
            if(this.col < 4){
                this.col ++;
                this.row = 2;
            }
            else{
                this.col = 1;
                this.row = 2;
            }
        } 

        if(up){
            if(this.col > 8 || this.col < 6){
                this.col = 5;
            }
            if(this.col < 8){
                this.col ++;
                this.row = 2;
            }
            else{
                this.col = 6;
                this.row = 2;
            }
        } 

        if(down){
            if(this.col > 3 || this.col < 1){
                this.col = 1;
            }
            if(this.col < 3){
                this.col ++;
                this.row = 3;
            }
            else{
                this.col = 1;
                this.row = 3;
            }
        }

        if(idle){
            if(this.col < 3){
                this.col ++;
                this.row = 1;
            }
            else{
                this.col = 1;
                this.row = 1;
            }
        }

        if(atk){
            if(this.col > 7 || this.col < 3){
                this.col = 3;
            }
            if(this.col < 6){
                this.col ++;
                this.row = 3;
            }
            else{
                this.col = 4;
                this.row = 3;
            }
        }

        if(chorar){
            if(this.col < 8 && this.row < 4){
                this.col = 8;
                this.row = 3;
            }
            else if(this.col == 8){
                this.col = 1;
                this.row = 4;
            }
            else if(this.row == 4 && this.col < 6){
                this.col++;
                this.row = 4;
            }
            else if(this.col > 5 && this.row == 4){
                this.col = 6;
                this.row = 4;
            }
        }

    }
}
