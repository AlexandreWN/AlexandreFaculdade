package SpritesETiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class objetos {
    private int posX, posY;
    private int largura = 48, altura = 48;
    private Image imagemObjeto;
    String nomeObj;
    String cenario;
    Rectangle areaSolida;
    boolean visivel;
    
    public objetos(int x, int y, String cena ,String nome) {
        this.posX = x;
        this.posY = y;
        this.nomeObj = nome;
        this.cenario = cena;
        
        this.areaSolida = new Rectangle();
        this.areaSolida.x = this.posX + 10;
        this.areaSolida.y = this.posY + 12;
        this.areaSolida.width = this.largura - 17;
        this.areaSolida.height = this.altura - 25;
        
        this.visivel = true;
        
        ImageIcon icon;
        String caminho = "";
        
        if(this.nomeObj == "chave") {
            caminho = "res/tiles/" + this.nomeObj + ".png";
        }else if(this.nomeObj == "moeda") {
            caminho = "res/tiles/" + this.nomeObj + ".png";
        }
        icon = new ImageIcon(caminho);
        this.imagemObjeto = icon.getImage();
    }
    
    public void desenhar(Graphics2D g){
        if(this.visivel) {
            g.setColor(Color.black);
            g.fillRect(this.areaSolida.x, this.areaSolida.y, this.areaSolida.width, this.areaSolida.height);
            g.drawImage(imagemObjeto, this.posX, this.posY, this.largura, this.altura, null);
        }

    }
}
