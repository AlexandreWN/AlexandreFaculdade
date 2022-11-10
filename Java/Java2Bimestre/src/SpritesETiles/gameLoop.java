package SpritesETiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class gameLoop extends Thread implements Runnable, AncestorListener, ActionListener{

    private int fps = 60;
    private Timer timer;
    private long contadorFps;
    private painel cenaDoJogo;
    private escutadorTeclado escutaTecl;

    gameLoop(painel p, escutadorTeclado eT){
        System.out.println("O loop foi iniciado");
        this.cenaDoJogo = p;
        this.escutaTecl = eT;
    }

    public void run(){
        this.contadorFps = 0;
        this.timer = new Timer(1000, this);
        this.timer.start();

        double frameRate = 1000000000/this.fps;
        double tempoDecorrido = 0;
        long tempoUltimaMedidaDoLoop = System.nanoTime();
        long tempoAtualDoLoop;

        while(this.isAlive()){
            tempoAtualDoLoop = System.nanoTime();
            tempoDecorrido = tempoDecorrido + (tempoAtualDoLoop - tempoUltimaMedidaDoLoop) / frameRate;

            tempoUltimaMedidaDoLoop = tempoAtualDoLoop;

            if(tempoDecorrido >= 1){
                verificadorColisao colisao = new  verificadorColisao();
                
                String direcao = "cima";

                if(escutaTecl.up) direcao  = "cima";
                if(escutaTecl.down) direcao  = "baixo";
                if(escutaTecl.right) direcao  = "direita";
                if(escutaTecl.left) direcao  = "esquerda";

                boolean bateu = colisao.verificaColisao(this.cenaDoJogo.player, this.cenaDoJogo.cenario, direcao);
                
                if(bateu == false){
                    
                    cenaDoJogo.player.atualizaPosiicao(escutaTecl.left, escutaTecl.up, escutaTecl.right, escutaTecl.down);
                    for(int num_obj = 0; num_obj < this.cenaDoJogo.obj.length; num_obj++) {
                        if(this.cenaDoJogo.obj[num_obj].visivel) {
                            if(this.cenaDoJogo.obj[num_obj].cenario == this.cenaDoJogo.cenario.getCenaValida()) {
                                boolean bateuEmObj = colisao.vericaColisao(this.cenaDoJogo.player.AreaSolida, this.cenaDoJogo.obj[num_obj].areaSolida);
                                if(bateuEmObj == true) {
                                    this.cenaDoJogo.obj[num_obj].visivel = false;
                                    this.cenaDoJogo.player.capturaObjeto(this.cenaDoJogo.obj[num_obj].nomeObj);
                                    System.out.println("numero de chaves: " +this.cenaDoJogo.player.inventarioJogador[0].qtdeObjeto);
                                    System.out.println("numero de moedas: " +this.cenaDoJogo.player.inventarioJogador[1].qtdeObjeto);
                                }
                            }
                        }
                    }
                }
                
                cenaDoJogo.repaint();

                this.contadorFps++;
                tempoDecorrido = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("FPS calculado: " + this.contadorFps);
        this.contadorFps = 0;
    }

    @Override
    public void ancestorAdded(AncestorEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorMoved(AncestorEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorRemoved(AncestorEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
