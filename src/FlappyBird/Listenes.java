package FlappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listenes implements KeyListener{


    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP){
            if(GamePanel.bird.stoppress) {
                GamePanel.bird.up = true;
                GamePanel.bird.upMoment = GamePanel.bird.getBirdY();
                GamePanel.bird.stoppress = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)GamePanel.bird.stoppress = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
