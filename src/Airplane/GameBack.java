package Airplane;

import javax.swing.*;
import java.awt.*;

public class GameBack {

    //Fields
    private Image image;


    //Constructor
    public GameBack() {
        this.image = new ImageIcon("nasa-inn_494946.jpg").getImage();

    }

    //Functions
    public void update() {

    }

    public void draw(Graphics2D g) {
        int leftOrRight = GamePanel.player.movelBackgroundLeftOrRight / 3;
        int upOrDown = GamePanel.player.movelBackgroundUpOrDown / 3;
       g.drawImage(image,-400 + leftOrRight, -240 + upOrDown, 1600 , 840, null);


    }

}


