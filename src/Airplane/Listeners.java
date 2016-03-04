package Airplane;

import java.awt.event.*;

public class Listeners implements KeyListener, MouseListener, MouseMotionListener{


    @Override
    public void keyPressed(KeyEvent e) {
        int key =  e.getKeyCode();

        if (key == KeyEvent.VK_UP) Player.up = true;
        if (key == KeyEvent.VK_DOWN) Player.down = true;
        if (key == KeyEvent.VK_LEFT) Player.left = true;
        if (key == KeyEvent.VK_RIGHT) Player.rigth = true;

        if (key == KeyEvent.VK_SPACE) Player.isFiring = true;

        if (key == KeyEvent.VK_ENTER) {
            GamePanel.state = GamePanel.STATES.PLAY;
            GamePanel.menu.t.startTimer();
        }

        if (key == KeyEvent.VK_ESCAPE) GamePanel.state = GamePanel.STATES.MENUE;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) Player.up = false;
        if (key == KeyEvent.VK_DOWN) Player.down = false;
        if (key == KeyEvent.VK_LEFT) Player.left = false;
        if (key == KeyEvent.VK_RIGHT) Player.rigth = false;

        if (key == KeyEvent.VK_SPACE) Player.isFiring = false;
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
            GamePanel.clicOnMenu = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            GamePanel.clicOnMenu = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public void mouseDragged(MouseEvent e) {
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();

    }


    public void mouseMoved(MouseEvent e) {
        GamePanel.mouseX = e.getX();
        GamePanel.mouseY = e.getY();

    }
}
