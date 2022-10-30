package SpritesETiles;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class tiles {
    private final int largura = 48, altura = 48;
    private int posX, posY;
    private Image imgAtual, agua, areia, bloco, gramaCima, gramaLado, tijolo;
    private boolean colisao;

    public tiles() {
        this.carregaImagensTiles();
    }

    public boolean getColisao(){
        return colisao;
    }

    public  void setColisao(boolean colisao){
        this.colisao = colisao;
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
        if(valorDaPeca == 0){
            this.imgAtual = this.bloco;
            this.colisao = true;
        } 
        if(valorDaPeca == 1){
            this.imgAtual = this.areia;
            this.colisao = false;
        } 
        if(valorDaPeca == 2){
            this.imgAtual = this.agua;
            this.colisao = true;
        } 
        if(valorDaPeca == 3){
            this.imgAtual = this.gramaCima;
            this.colisao = false;
        } 
        if(valorDaPeca == 4){
            this.imgAtual = this.gramaLado;
            this.colisao = true;
        } 
        if(valorDaPeca == 5){
            this.imgAtual = this.tijolo;
            this.colisao = true;
        }
        //if (this.colisao == true) this.imgAtual = this.agua;
        //else this.imgAtual = this.gramaCima;
    }
}
