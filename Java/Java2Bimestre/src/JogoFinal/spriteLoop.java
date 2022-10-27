package JogoFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class spriteLoop extends Thread implements Runnable, AncestorListener, ActionListener{
    private int fps = 10;
    private Timer timer;
    private long contadorFps;
    private painel cenaDoJogo;
    private escutadorTeclado escutaTecl;

    spriteLoop(painel p, escutadorTeclado eT){
        System.out.println("Sprite instanciado");
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
                cenaDoJogo.player.atualizaSprite(
                    escutaTecl.getLeft(), escutaTecl.getUp(), escutaTecl.getRight(), escutaTecl.getDown(), escutaTecl.idle, escutaTecl.getAtk(), escutaTecl.getChorar());

                cenaDoJogo.repaint();

                this.contadorFps++;
                tempoDecorrido = 0;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
