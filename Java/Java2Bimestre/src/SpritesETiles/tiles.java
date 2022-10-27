package SpritesETiles;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class tiles {
    private final int largura = 48, altura = 48;
    private int posX, posY;
    private Image imgAtual, agua, areia, bloco, gramaCima, gramaLado, tijolo;
    
    public tiles() {
        this.carregaImagensTiles();
    }
    
    public void desenhar(Graphics2D g, int linha, int coluna){
        this.posX = coluna * this.largura;
        this.posY = linha * this.altura;
        g.drawImage(this.imgAtual, this.posX, this.posY, this.largura, this.altura, null);
    }
    
    private void carregaImagensTiles() {
        ImageIcon icon;
        icon = new ImageIcon("res/tiles/GramaCima.png");
        this.gramaCima = icon.getImage();
        
        icon = new ImageIcon("res/tiles/agua.png.png");
        this.agua = icon.getImage();
        
        icon = new ImageIcon("res/tiles/Areia.png");
        this.areia = icon.getImage();
        
        icon = new ImageIcon("res/tiles/Bloco.png");
        this.bloco = icon.getImage();
        
        icon = new ImageIcon("res/tiles/GramaLado.png");
        this.gramaLado = icon.getImage();
        
        icon = new ImageIcon("res/tiles/Tijolo.png");
        this.tijolo = icon.getImage();
    }
    
    public void carregapecaDaMatriz(int valorDaPeca) {
        if(valorDaPeca == 0) this.imgAtual = this.bloco;
        if(valorDaPeca == 1) this.imgAtual = this.areia;
        if(valorDaPeca == 2) this.imgAtual = this.agua;
        if(valorDaPeca == 3) this.imgAtual = this.gramaCima;
        if(valorDaPeca == 4) this.imgAtual = this.gramaLado;
        if(valorDaPeca == 5) this.imgAtual = this.tijolo;
    }
}
