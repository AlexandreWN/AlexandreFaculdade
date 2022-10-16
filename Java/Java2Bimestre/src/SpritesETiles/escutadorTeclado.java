package SpritesETiles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class escutadorTeclado implements KeyListener{

    public boolean down, up, left, right;

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37:
                this.left = true;
                break;
            case 38:
                this.up = true;
                break;
            case 39:
                this.right = true;
                break;
            case 40:
                this.down = true;
                break;
            default:
                System.out.println("tecla sem efeito");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case 37:
                this.left = false;
                break;
            case 38:
                this.up = false;
                break;
            case 39:
                this.right = false;
                break;
            case 40:
                this.down = false;
                break;
            default:
                System.out.println("tecla sem efeito");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}
}
