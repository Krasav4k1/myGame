package Tenis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listenes implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) Platform.left = true;
        if(key == KeyEvent.VK_RIGHT) Platform.rigth = true;

        if(key == KeyEvent.VK_A) Platform2.left = true;
        if(key == KeyEvent.VK_D) Platform2.rigth = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT) Platform.left = false;
        if(key == KeyEvent.VK_RIGHT) Platform.rigth = false;

        if(key == KeyEvent.VK_A) Platform2.left = false;
        if(key == KeyEvent.VK_D) Platform2.rigth = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
