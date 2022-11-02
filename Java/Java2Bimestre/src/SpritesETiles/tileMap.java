package SpritesETiles;

import java.awt.Graphics2D;

public class tileMap {
    tiles pecaDoCenario;
    int [][] cenarioValido;
    private String cenaValida;

    public String getCenaValida(){
        return cenaValida;
    }
    public void setCenaValida(String cenaValida){
        this.cenaValida = cenaValida;

        switch (this.cenaValida){
            case "BE":
                this.cenarioValido = this.cenarioDoJogo3;
                break;
            case "BD":
                this.cenarioValido = this.cenarioDoJogo4;
                break;
            case "TE":
                this.cenarioValido = this.cenarioDoJogo1;
                break;
            case "TD":
                this.cenarioValido = this.cenarioDoJogo2;
                break;
        }
    }
    
    int[][] cenarioDoJogo1 = { 
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,3,3,3,3,3,3,3,3,1,1,1,1,1,1,0},
            {0,4,4,4,4,4,4,4,3,1,1,5,5,1,1,1},
            {0,2,2,2,2,2,2,2,3,1,1,5,3,1,1,1},
            {0,2,2,2,2,2,2,2,3,1,1,5,3,5,3,0},
            {0,2,2,2,2,2,2,2,3,1,1,5,3,5,3,0},
            {0,3,3,3,3,3,3,3,3,1,1,5,3,5,3,0},
            {0,3,5,5,5,5,5,5,5,5,5,5,3,5,3,0},
            {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
            {0,0,3,3,0,0,0,0,0,0,0,0,0,0,0,0}
        };
    int[][] cenarioDoJogo2 = { 
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,3,3,3,3,3,3,3,3,3,3,3,0},
            {1,1,1,1,3,3,3,3,3,3,3,3,3,3,3,0},
            {1,1,1,1,3,3,3,4,4,4,4,4,4,3,3,0},
            {0,1,1,1,1,1,1,2,2,2,2,2,2,3,3,0},
            {0,1,1,1,1,1,1,2,2,2,2,2,2,3,3,0},
            {0,1,1,1,1,1,1,2,2,2,2,2,2,3,3,0},
            {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
            {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,3,3,0,0}
        };
    int[][] cenarioDoJogo3 = { 
            {0,0,3,3,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,3,3,3,5,5,5,5,5,5,5,5,5,5,5,0},
            {0,3,3,3,3,3,3,3,3,3,3,3,3,3,5,0},
            {0,3,3,3,3,3,3,3,5,3,5,3,5,3,5,0},
            {0,3,3,3,3,3,3,3,5,3,5,3,5,3,5,0},
            {0,4,4,4,4,4,3,3,5,3,5,3,5,3,5,0},
            {0,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1},
            {0,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1},
            {0,2,2,2,2,2,5,5,5,5,5,5,5,5,5,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
    int[][] cenarioDoJogo4 = { 
            {0,0,0,0,0,0,0,0,0,0,0,0,3,3,0,0},
            {0,3,3,3,3,3,3,3,3,3,3,3,3,3,3,0},
            {0,4,4,4,4,4,4,3,3,4,4,4,4,4,4,0},
            {0,2,2,2,2,2,2,3,3,2,2,2,2,2,2,0},
            {0,2,2,2,2,2,2,3,3,2,2,2,2,2,2,0},
            {0,1,1,1,1,1,1,3,3,3,3,3,3,3,3,0},
            {1,1,1,1,1,1,1,3,3,4,4,4,4,4,4,0},
            {1,1,5,1,5,1,5,3,3,2,2,2,2,2,2,0},
            {0,1,5,1,5,1,5,3,3,2,2,2,2,2,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
    
    tileMap(){
        cenarioValido = cenarioDoJogo1;
        this.cenaValida = "TE";
        this.pecaDoCenario = new tiles();
    }
    public void desenhar(Graphics2D g) {
        int pecaDaMatriz;
        for(int col = 0; col < cenarioValido[0].length; col++) {
            for(int row = 0; row < cenarioValido.length; row++) {
                pecaDaMatriz = cenarioValido[row][col];
                this.pecaDoCenario.carregapecaDaMatriz(pecaDaMatriz);
                this.pecaDoCenario.desenhar(g, row, col);
            }
        }
    }
}

