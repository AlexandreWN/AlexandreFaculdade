package SpritesETiles;

import java.awt.Rectangle;

public class verificadorColisao {
    private int colEsqX;
    private int colDirX;
    private int rowTopoY;
    private int rowBaseY;
    private boolean colisaoOcorreu;

    public verificadorColisao(){
        
    }

    public boolean verificaColisao(jogador player, tileMap cenaDoJogo, String direcao){
        this.colisaoOcorreu = false;

        int bordaEsqX = player.AreaSolida.x;
        int bordaDirX = player.AreaSolida.x + (int)jogador.AreaSolida.getWidth();
        int bordaTopoY = player.AreaSolida.y;
        int bordaBaseY = player.AreaSolida.y + (int)jogador.AreaSolida.getHeight();
    
        this.colEsqX = bordaEsqX/48;
        this.colDirX = bordaDirX/48;
        this.rowTopoY = bordaTopoY/48;
        this.rowBaseY = bordaBaseY/48;

        if(direcao == "cima"){
            if(jogador.AreaSolida.y < 0){
                if(cenaDoJogo.getCenaValida() == "BE"){
                    cenaDoJogo.setCenaValida("TE");
                }else{
                    cenaDoJogo.setCenaValida("TD");
                }
                int alturaCenario =  cenaDoJogo.cenarioValido.length*48;
                player.setPosY(alturaCenario -(int)jogador.AreaSolida.getHeight());
            }else{
                int prox_rowTopoY = (bordaTopoY - jogador.velocidade) / 48;
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowTopoY][colEsqX]);
    
                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
    
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowTopoY][colDirX]);
    
                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
            }
        }else if(direcao == "baixo"){
            int prox_rowBaseY = (bordaBaseY + jogador.velocidade) / 48;
            if(prox_rowBaseY < cenaDoJogo.cenarioValido.length){
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowBaseY][colEsqX]);

                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }

                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowBaseY][colDirX]);

                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
            }else{
                if(cenaDoJogo.getCenaValida() == "TE"){
                    cenaDoJogo.setCenaValida("BE");
                }else{
                    cenaDoJogo.setCenaValida("BD");
                }
                player.setPosY(-(int)jogador.AreaSolida.getHeight());
            }
        }else if(direcao == "direita"){
            int prox_colDirX = (bordaDirX + jogador.velocidade) / 48;
            if(prox_colDirX < cenaDoJogo.cenarioValido[0].length){
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[rowBaseY][prox_colDirX]);

                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
    
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[rowTopoY][prox_colDirX]);
    
                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
            }else{
                if(cenaDoJogo.getCenaValida() == "TE"){
                    cenaDoJogo.setCenaValida("TD");
                }else{
                    cenaDoJogo.setCenaValida("BD");
                }
                player.setPosX(-(int)jogador.AreaSolida.getWidth());
            }
        }else if(direcao == "esquerda"){
            int prox_colEsqX = (bordaEsqX - jogador.velocidade) / 48;
            if(jogador.AreaSolida.x < 0){
                if(cenaDoJogo.getCenaValida() == "TD"){
                    cenaDoJogo.setCenaValida("TE");
                }else{
                    cenaDoJogo.setCenaValida("BE");
                }
                int larguraCenario =  cenaDoJogo.cenarioValido[0].length*48;
                player.setPosX(larguraCenario -(int)jogador.AreaSolida.getWidth());
            }else{
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[rowBaseY][prox_colEsqX]);

                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
    
                cenaDoJogo.pecaDoCenario.carregapecaDaMatriz(cenaDoJogo.cenarioValido[rowTopoY][prox_colEsqX]);
    
                if(cenaDoJogo.pecaDoCenario.getColisao()){
                    this.colisaoOcorreu = true;
                }
            }
        }
        
        return colisaoOcorreu;
    }
    
    public boolean vericaColisao(Rectangle Sprite1, Rectangle Sprite2) {
        boolean retorno = false;
        if(Sprite1.intersects(Sprite2)) {
            retorno = true;
        }
        return retorno;
    }
}
