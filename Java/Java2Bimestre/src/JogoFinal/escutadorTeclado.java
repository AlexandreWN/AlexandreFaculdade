package JogoFinal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class escutadorTeclado implements KeyListener{

    public boolean down, up, left, right, idle = true, atk, chorar;

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37:
                this.left = true;
                this.idle = false;
                break;
            case 38:
                this.up = true;
                this.idle = false;
                break;
            case 39:
                this.right = true;
                this.idle = false;
                break;
            case 40:
                this.down = true;
                this.idle = false;
                break;
            case 67:
                this.atk = true;
                this.idle = false;
                break;
            case 88:
                this.chorar = true;
                this.idle = false;
                break;
            default:
                System.out.println(e.getKeyCode());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37:
                this.left = false;
                this.idle = true;
                break;
            case 38:
                this.up = false;
                this.idle = true;
                break;
            case 39:
                this.right = false;
                this.idle = true;
                break;
            case 40:
                this.down = false;
                this.idle = true;
                break;
            case 67:
                this.atk = false;
                this.idle = true;
                break;
            case 88:
                this.chorar = false;
                this.idle = true;
                break;
            default:
                System.out.println(e.getKeyCode());
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}
}
