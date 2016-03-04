package TheDragon;

import java.awt.event.*;

public class Listenes implements KeyListener , MouseListener, MouseMotionListener{

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(!GamePanel.theDragon.down) {
            if (key == KeyEvent.VK_UP) {
                GamePanel.theDragon.up = true;
                GamePanel.theDragon.down = false;
            }
        }
        if(key == KeyEvent.VK_DOWN) {
            GamePanel.theDragon.up = false;
            GamePanel.theDragon.crouch = true;
        }
        if(key == KeyEvent.VK_ENTER){
            GamePanel.states = GamePanel.STATES.PLAY;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_DOWN) {
            GamePanel.theDragon.crouch = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            GamePanel.menu.pressMouse = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            GamePanel.menu.pressMouse = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GamePanel.menu.mouseX = e.getX();
        GamePanel.menu.mouseY = e.getY();
    }
}
