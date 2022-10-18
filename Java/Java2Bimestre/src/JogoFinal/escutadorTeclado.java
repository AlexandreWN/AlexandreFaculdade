package JogoFinal;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class escutadorTeclado implements KeyListener{

    public Map<Integer, Boolean> keys = new HashMap<Integer, Boolean>();
    public boolean idle = true;
    int count = 0;

    public escutadorTeclado(){
        for (int i = 37; i < 41; i++){
            this.keys.put(i, false);
        }
        this.keys.put(67, false);
        this.keys.put(88, false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(this.keys.containsKey(e.getKeyCode())){
            if(this.keys.get(e.getKeyCode()) == false){
                count++;
            }
            this.keys.put(e.getKeyCode(), true);
        }else{
            count--;
        }
        if (this.count > 0){
            this.idle = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.keys.containsKey(e.getKeyCode())){
            this.keys.put(e.getKeyCode(), false);
            count--;
        }
        else{
            count++;
        }
        if (this.count == 0){
            this.idle = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {}

    public boolean getLeft(){
        return this.keys.get(37);
    }
    public boolean getUp(){
        return this.keys.get(38);
    }
    public boolean getRight(){
        return this.keys.get(39);
    }
    public boolean getDown(){
        return this.keys.get(40);
    }
    public boolean getAtk(){
        return this.keys.get(67);
    }
    public boolean getChorar(){
        return this.keys.get(88);
    }
}
